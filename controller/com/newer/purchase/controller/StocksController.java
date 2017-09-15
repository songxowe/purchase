package com.newer.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.core.util.StringCodeProcessor;
import com.newer.purchase.pojo.dto.Stocks;
import com.newer.purchase.service.IdMappingService;
import com.newer.purchase.service.StocksService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class StocksController {
	@Resource(name="stocksService")
	private StocksService stocksService;
	@Resource(name="idMappingService")
	private IdMappingService idMappingService;
	
	@RequestMapping("/stocksController_list")
	public void list(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "stockName") String stockName,
		      @RequestParam(required = false, value = "status") String status,
		      @RequestParam(required = false, value = "stockType") String stockType,
		      HttpServletResponse response){

				
		try {
			
		      if (!StringUtils.isEmpty(stockName)) {
		        // tips:为了体验转换为大写 (若模糊查询中文则不需要)
		    	  stockName = "%" + stockName.toUpperCase() + "%";
		      }
		      

		      Integer pageno = (page - 1) * rows;
		      Integer pagesize = page * rows;

		      Pager<Stocks> pager = stocksService.findPager(pageno, pagesize, sort, order, stockName, status,stockType);

		      JsonConfig jsonConfig = new JsonConfig();
		      jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		      jsonConfig.registerJsonValueProcessor(String.class, new StringCodeProcessor());
		      JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

		      PrintWriter out = response.getWriter();
		      out.println(json.toString());
		      out.flush();
		      out.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
	}
	
	@RequestMapping("/stocksController_view")
	  public String view(@RequestParam(required = false, value = "id") Integer id, ModelMap modelMap) {
	    if (id != null) {
	      Stocks stocks = stocksService.findById(id);
	      StringCodeProcessor scp=new StringCodeProcessor();
	      stocks.setLeadAgree((String) scp.processArrayValue(stocks.getLeadAgree(), new JsonConfig()));
	      stocks.setStockType((String) scp.processArrayValue(stocks.getStockType(), new JsonConfig()));

	      modelMap.put("stocks", stocks);	      
	    }
	    return "stocksView";
	  }
	
	@RequestMapping("/stocksController_remove")
	public void remove(Integer id,HttpServletResponse response){
		int count = 0;
		if(id != null){
			idMappingService.remove(id);
			stocksService.remove(id);
		}
		try {
			PrintWriter out=response.getWriter();
			out.println(count);
		    out.flush();
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
