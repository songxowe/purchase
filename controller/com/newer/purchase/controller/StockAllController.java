package com.newer.purchase.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.Constants;
import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.core.util.StockRandom16;
import com.newer.pojo.User;
import com.newer.purchase.pojo.Orders;
import com.newer.purchase.pojo.OrdersMapping;
import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.Supplier;
import com.newer.purchase.service.StockAllService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class StockAllController {
	@Resource(name="stockAllService")
	private StockAllService stockAllService;
	@InitBinder
	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
	}

	
	  @RequestMapping("/stockAllController")
	  public void list(@RequestParam(required = true, value = "page") Integer page,
	      @RequestParam(required = true, value = "rows") Integer rows,
	      @RequestParam(required = true, value = "sort") String sort,
	      @RequestParam(required = true, value = "order") String order,
	      @RequestParam(required = false, value = "materialCode") String materialCode,
	      @RequestParam(required = false, value = "materialName") String materialName,
	      HttpServletResponse response) {

	    try {
	      if (!StringUtils.isEmpty(materialCode)) {
	        // tips:为了体验转换为大写 (若模糊查询中文则不需要)
	    	  materialCode = "%" + materialCode.toUpperCase() + "%";
	      }
	      if (!StringUtils.isEmpty(materialName)) {
		        // tips:为了体验转换为大写 (若模糊查询中文则不需要)
	    	  materialName = "%" + materialName.toUpperCase() + "%";
		  }

	      Integer pageno = (page - 1) * rows;
	      Integer pagesize = page * rows;

	      Pager<OrdersMapping> pager = stockAllService.findPager(pageno, pagesize, sort, order, materialCode, materialName);

	      JsonConfig jsonConfig = new JsonConfig();
	      jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
	      //jsonConfig.registerJsonValueProcessor(Dept.class, new DeptValueProcessor());

	      JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

	      PrintWriter out = response.getWriter();
	      out.println(json.toString());
	      out.flush();
	      out.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	  
	  @RequestMapping("/stockAllController_view")
	  public String view(@RequestParam(required = true, value = "id") Integer id, ModelMap modelMap) {
		    if (id != null) {
		    	Orders orders = stockAllService.findById(id);
		    	modelMap.put("orders", orders);
		    }
		    return "stockAllview";
	  }
	  
	  @RequestMapping("/stockAllController_findById")
	  public String findById(@RequestParam(required = false, value = "id") Integer id,@RequestParam(required = false, value = "mappingId") Integer mappingId, ModelMap modelMap,HttpServletRequest request) {
		    if (id != null) {
		    	Orders orders = stockAllService.findById(id);
		    	
		    	Stock stock = new Stock();
		    	stock.setStockNum(StockRandom16.random16().toString());
		    	User user = (User) request.getSession().getAttribute(Constants.USER_IN_SESSION);
		    	//System.out.println(user);
		    	String userName=stockAllService.findUser(user);
		    	stock.setAuthor(userName);//编制人
		    	stock.setBudget(orders.getSumPrice());
		    	stock.setBuildDate(new Date());
		    	
		    	List<Supplier> supplier= stockAllService.findName(orders.getMaterialCode());
		    	
		    	modelMap.put("supplier", supplier);
		    	modelMap.put("stock", stock);
		    	modelMap.put("orders", orders);
		    	modelMap.put("mappingId", mappingId);
		    }
		    return "stockedit";
	  }
	  
	  @RequestMapping("stockAllController_add")
	  public void add(HttpServletRequest request,Stock stock,
			  @RequestParam(value="mappingId")Integer mappingId,
			  @RequestParam(value="suppliers")String suppliers){
		  System.out.println("----------------------------进入编制采购");
		  stock.setBuildDate(new Date());
		  User user = (User) request.getSession().getAttribute(Constants.USER_IN_SESSION);
		  stock.setAuthorId(user.getId());
		  System.out.println(stock);
		  stockAllService.add(stock, mappingId);//新增一条采购数据
		  int sid=stockAllService.findStockId(stock.getStockNum(), stock.getStockName());//通过采购编码和采购名称查询出采购计划的主键ID
		  stockAllService.modifyIdMapping(sid, mappingId);//修改编号对照表
		  if(suppliers.length()>0){
			  String[] sup=suppliers.split(",");//如果选择多个供应商，那么就转成数组
			  for(String s:sup){
				  int a=Integer.parseInt(s);//将数组中单个提取				  
				  stockAllService.addStockSupplier(sid, a);
			  }
			  
		  }
	  }
}
