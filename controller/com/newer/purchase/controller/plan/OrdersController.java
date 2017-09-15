package com.newer.purchase.controller.plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.Constants;
import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.core.util.StringCodeProcessor;
import com.newer.pojo.User;
import com.newer.purchase.pojo.Employee;
import com.newer.purchase.pojo.IdMapping;
import com.newer.purchase.pojo.plan.Orders;
import com.newer.purchase.pojo.plan.OrdersView;
import com.newer.purchase.service.plan.EmployeeFuService;
import com.newer.purchase.service.plan.IdMappingService;
import com.newer.purchase.service.plan.OrdersService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

/**
 * 需求计划处理器
 * @author FUQIAN
 *
 */
@Controller
@RequestMapping("/ordersf")
public class OrdersController {
	
	@Resource(name="ordersServicef")
	private OrdersService ordersServicef;
	
	@Resource(name="employeeServicef")
	private EmployeeFuService employeeServicef;
	
	@Resource(name="idMappingServicef")
	private IdMappingService idMappingServicef;
	
	
	/**
	 * 录入需求计划  (查询当前用户的员工信息+页面的信息——>录入需求计划——>在编码对应表中添加一条数据)
	 * 
	 * @param orders
	 * @param request
	 * @param response
	 */
	@RequestMapping("/ordersController_save")
	public void save(Orders orders,HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入录入需求");
		int count=0;
		int count1=0;
		if(orders!=null){
			//获得当前用户信息
			HttpSession session = request.getSession();
			User user=(User)session.getAttribute(Constants.USER_IN_SESSION);
			if(user!=null){
				//根据用户id查询员工表
				Employee employee=employeeServicef.findById(user.getId());			
				//将员工信息添加到Orders对象中
				orders.setAuthorId(employee.getId());
				orders.setAuthor(employee.getEmpName());
				orders.setPhone(employee.getPhone());
				orders.setFax(employee.getFax());
				orders.setEmail(employee.getEmail());
				orders.setBuildDate(new Date());
			}
			//添加需求计划信息
			count1=ordersServicef.add(orders);
			
			//向编码对应表中添加一条记录
			if(count1>0){
				int orderId=idMappingServicef.getOrderId();
				idMappingServicef.addIdMapping(orderId);
			}
			
			
		}		
		String json = "{\"count\":" + count + "}";

		try {
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("离开录入需求");
	}
	
	

	/**
	 * 需求计划一览表  查询需求计划
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param materialCode
	 * @param materialName
	 * @param status
	 * @param response
	 */
	@RequestMapping("/ordersController")
	public void list(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "materialCode") String materialCode, 
			@RequestParam(required = false, value = "materialName") String materialName,
			@RequestParam(required = false, value = "status") String status,
			HttpServletResponse response) {
		System.out.println("进入需求计划查询");
		try {
			if (!StringUtils.isEmpty(materialCode)) {
				materialCode = "%" + materialCode+ "%";
			}
			if (!StringUtils.isEmpty(materialName)) {
				materialName = "%" + materialName+ "%";
			}
			
			
			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<OrdersView> pager =ordersServicef.findPager(pageno, pagesize, sort, order, materialCode, materialName, status);
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
		System.out.println("离开需求计划查询");
	}
	
	
	/**
	 * 需求计划详情表
	 * @param id
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("ordersController_details")
	public String getDetails(@RequestParam(required=false,value="id")Integer id,
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("进入需求计划详情/go修改");
		Orders orders=ordersServicef.findById(id);
		modelMap.put("orders", orders);
		String type=request.getParameter("type");
		if(type!=null){
			//通过当前需求id，查询需求的采购状态码
			IdMapping idMapping=idMappingServicef.findByOrderId(orders.getId());
			String struts=idMapping.getStatus();
			
			System.out.println("离开go修改");
			return "ordersedit";
		}else{
			System.out.println("离开需求计划详情");
			return "ordersdetails";
		}
	
	}
	
	
	
	/**
	 * 进行需求计划修改
	 * @param orders
	 * @param request
	 * @param response
	 */
	@RequestMapping("ordersController_edit")
	public void edit(Orders orders,
			HttpServletRequest request,
			HttpServletResponse response){
		
		System.out.println("进入需求计划修改");
		System.out.println(orders);
		int count=0;
		if(orders!=null&&orders.getId()!=null){
			count=ordersServicef.modify(orders);
		}
		String json = "{\"count\":" + count + "}";

		try {
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("离开修改需求计划");
		
		
	}
	
	
	/**
	 * 需求计划确认
	 * @param id
	 * @param response
	 */
	@RequestMapping("/ordersController_ensure")
	public void ensure(@RequestParam(required = true, value = "id") Integer id, HttpServletResponse response){
		System.out.println("1----------------------------------------s");
		System.out.println("进入确认Id:"+id);
		int count=idMappingServicef.modifyIdMapping(id);
		
		try {
		      PrintWriter out = response.getWriter();
		      out.println(count);
		      out.flush();
		      out.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
	}
	
	
	@RequestMapping("ordersController_stauts")
	public void stauts(@RequestParam(required=false,value="id")Integer id,
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("进入采购状态码id:"+id);
		
		Orders orders=ordersServicef.findById(id);
		//通过当前需求id，查询需求的采购状态码
		IdMapping idMapping=idMappingServicef.findByOrderId(orders.getId());
		int count=0;
		if("C001-10".equals(idMapping.getStatus())){
			count=1;
		}
		try {
		      PrintWriter out = response.getWriter();
		      out.println(count);
		      out.flush();
		      out.close();
		} catch (IOException e) {
		      e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("/ordersController_remove")
	public void remove(@RequestParam(required = true, value = "ids") String ids, 
			HttpServletResponse response) {
		int count = 0;
	    String[] id_ = ids.split(",");
	    for (int i = 0; i < id_.length; i++) {
	      Integer id = NumberUtils.createInteger(id_[i]);
	      count += ordersServicef.remove(id);
	    }

	    try {
	      PrintWriter out = response.getWriter();
	      out.println(count);
	      out.flush();
	      out.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	
	
	@RequestMapping("/ordersController_list")
	public void list1(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "materialCode") String materialCode, 
			@RequestParam(required = false, value = "materialName") String materialName,
			HttpServletResponse response) {
		System.out.println("进入未编采购的需求计划查询");
		try {
			if (!StringUtils.isEmpty(materialCode)) {
				materialCode = "%" + materialCode+ "%";
			}
			if (!StringUtils.isEmpty(materialName)) {
				materialName = "%" + materialName+ "%";
			}
			
			
			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<OrdersView> pager =ordersServicef.findPager1(pageno, pagesize, sort, order, materialCode, materialName);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("离开未编采购的需求计划查询");
	}
	

	

}
