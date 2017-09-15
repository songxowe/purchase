package com.newer.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.core.util.StringCodeProcessor;
import com.newer.purchase.pojo.Enquire;
import com.newer.purchase.pojo.EnquireDetail;
import com.newer.purchase.pojo.Orders;
import com.newer.purchase.pojo.Quote;
import com.newer.purchase.pojo.QuoteDetail;
import com.newer.purchase.pojo.Supplier;
import com.newer.purchase.pojo.dto.PoEnquire;
import com.newer.purchase.pojo.dto.PoQuote;
import com.newer.purchase.service.OrdersService;
import com.newer.purchase.service.QuoteService;
import com.newer.purchase.service.SupplierService;
import com.newer.purchase.service.plan.IdMappingService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class QuoteController {

	@Resource(name = "quoteService")
	private QuoteService quoteService;
	
	@Resource( name = "ordersService")
	private OrdersService ordersService;
	
	@Resource( name = "supplierService")
	private SupplierService supplierService;
	
	@Resource( name = "idMappingServicef")
	private IdMappingService idMappingService;
	
	/**
	 * 
	 * 询价表分页查询
	 */
	@RequestMapping("/quoteController_enquireList")
	public void enquireList(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "enquireName") String enquireName,
		      @RequestParam(required = false, value = "beginDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
		      @RequestParam(required = false, value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
		      @RequestParam(required = false, value = "supplierId") Integer supplierId,
		      @RequestParam(required = false, value = "userId") Integer userId,
		      @RequestParam(required = false, value = "stockType") String stockType,
		      HttpServletResponse response){
		
		try {
			if(!StringUtils.isEmpty(enquireName)){
				enquireName = "%"+enquireName +"%";
			}
			
			Date date = new Date();
			Integer pageno = (page - 1) * rows;
		    Integer pagesize = page * rows;
		    
		    Pager<PoEnquire> pager = quoteService.findEnquire(pageno, pagesize, sort, order, enquireName, beginDate, endDate, stockType, userId);
		    
		    for (PoEnquire enquire : pager.getRows()) {
				if(enquire.getEndDate().before(date)){
					quoteService.modifyStatus(enquire.getId());
				}
			}
		    
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
	
	/**
	 * 
	 * 报价书分页查询
	 */
	@RequestMapping("/quoteController_quoteList")
	public void quoteList(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "queTitle") String queTitle,
		      @RequestParam(required = false, value = "beginDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
		      @RequestParam(required = false, value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
		      @RequestParam(required = false, value = "supplierId") Integer supplierId,
		      @RequestParam(required = false, value = "userId") Integer userId,
		      HttpServletResponse response){
		
		try {
			if(!StringUtils.isEmpty(queTitle)){
				queTitle = "%"+queTitle+"%";
			}
			//System.out.println(userId);
			Integer pageno = (page - 1) * rows;
		    Integer pagesize = page * rows;

		    Pager<PoQuote> pager = quoteService.findQuote(pageno, pagesize, sort, order, queTitle, beginDate, endDate, supplierId, userId);
		    
		    for (PoQuote PoQuote : pager.getRows()) {
				Date date = new Date();
				if(PoQuote.getEndDate().before(date)){
					idMappingService.modifyQuote(PoQuote.getEnquireId());
				}
			}
		    
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
	
	/**
	 * 单个查询询价书详情
	 * @return
	 */
	@RequestMapping("/quoteController_findByEnquire")
	public String findByEnquire(@RequestParam(required = false, value ="enquireId") Integer enquireId,ModelMap map){
		if(enquireId !=null){
			EnquireDetail enquireDetail = quoteService.findByEnquire(enquireId);
			Enquire enquire = quoteService.findById(enquireId);
			Orders orders = ordersService.findByOrders(enquireDetail.getOrderId());
			map.put("enquireDetail", enquireDetail);
			map.put("enquire", enquire);
			map.put("orders", orders);
		}
		return "enquireDetailEdit";
	}

	@RequestMapping("/quoteController_enquireView")
	public String enquireView(@RequestParam(required = false, value ="enquireId") Integer enquireId,ModelMap map){
		if(enquireId !=null){
			EnquireDetail enquireDetail = quoteService.findByEnquire(enquireId);
			Enquire enquire = quoteService.findById(enquireId);
			Orders orders = ordersService.findByOrders(enquireDetail.getOrderId());
			map.put("enquireDetail", enquireDetail);
			map.put("enquire", enquire);
			map.put("orders", orders);
		}
		return "enquireDetailView";
	}
	
	/**
	 * 
	 * 单个查询报价书详情
	 */
	@RequestMapping("/quoteController_quoteView")
	public String quoteView(@RequestParam(required = false, value ="quoteId") Integer quoteId,ModelMap map){
		if(quoteId != null){
			QuoteDetail quoteDetail=quoteService.findByQuote(quoteId);
			map.put("quoteDetail", quoteDetail);
		}
		return "quoteView";
	}
	
	@RequestMapping("/quoteController_findByQuote")
	public String findByQuote(@RequestParam(required = false, value ="quoteId") Integer quoteId,ModelMap map){
		if(quoteId != null){
			QuoteDetail quoteDetail=quoteService.findByQuote(quoteId);
			//System.out.println(quoteDetail);
			map.put("quoteDetail", quoteDetail);
		}
		return "quoteDetailEdit";
	}
	
	
	/**
	 * 
	 * 新增报价书
	 */
	
	@RequestMapping("/quoteController_addQuote")
	public String addQuote(@RequestParam(required = false, value ="enquireId") Integer enquireId,ModelMap map){
		if(enquireId != null){
			
			EnquireDetail enquireDetail = quoteService.findByEnquire(enquireId);
			Enquire enquire = quoteService.findById(enquireId);
			Orders orders = ordersService.findByOrders(enquireDetail.getOrderId());
			map.put("enquireDetail", enquireDetail);
			map.put("enquire", enquire);
			map.put("orders", orders);
		}
		return "addQuote";
	}
	
	@RequestMapping("/quoteController_saveQuote")
	public void save(Quote quote,QuoteDetail quoteDetail,HttpServletResponse response,
			@RequestParam(required = false, value ="userId") Integer userId){
		int count=0;
		System.out.println("yonghu"+userId);
			Supplier supplier=new Supplier();
			supplier=supplierService.findById(userId);
			System.out.println("gongyiingshang"+supplier.getId());
			
			Double sumAmount=null;
			Double overallPrice=null;
			
			sumAmount=(double)quoteDetail.getAmount();
			overallPrice=quoteDetail.getTotalPrice();
			
			quote.setQueDate(new Date());
			quote.setSumAmount(sumAmount);
			quote.setOverallPrice(overallPrice);
			quote.setStatus("B001-1");
			quote.setSupplier(supplier);
			
			System.out.println(quote);
			System.out.println(quoteDetail);
			
			count=quoteService.addQuote(quote);
			if(count>0){
				int quoteId=quoteService.getQuoteId();
				quoteDetail.setQuoteId(quoteId);
				int a=quoteService.addQuoteDetail(quoteDetail);
				
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
	
	/**
	 * 
	 * 新增报价数详情
	 */
	@RequestMapping("/quoteController_editQuoteDetail")
	public void modifyQuoteDetail(QuoteDetail quoteDetail,HttpServletResponse response){
		int count=0;
			
		count=quoteService.modifyQuoteDetail(quoteDetail);
		
		try {
		      PrintWriter out = response.getWriter();
		      out.println(count);
		      out.flush();
		      out.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
		
}
