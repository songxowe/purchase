package com.newer.purchase.controller;


import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.core.util.StringCodeProcessor;
import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.StockPanner;
import com.newer.purchase.pojo.dto.Stocks;
import com.newer.purchase.service.StockPannerService;
import com.newer.purchase.service.StocksService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class StockPannerController {
	
	@Resource(name="stockPannerService")
	private  StockPannerService stockPannerService;
	
	@Resource(name="stocksService")
	private StocksService stocksService;
	
	
	@RequestMapping("/stockPannerController_liststockPanner")
	public void list(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "stockName") String stockName,
		      @RequestParam(required = false, value = "endDate") Date endDate,
		      HttpServletResponse response){
		try{
			
			Integer pageno = (page - 1) * rows;
		    Integer pagesize = page * rows;
		    Pager<StockPanner> pager = stockPannerService.findPager(pageno, pagesize, sort, order, endDate, stockName);
		    JsonConfig jsonConfig = new JsonConfig();
		    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		    jsonConfig.registerJsonValueProcessor(String.class, new StringCodeProcessor());
		    JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

		      PrintWriter out = response.getWriter();
		      out.println(json.toString());
		      out.flush();
		      out.close();
		}catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
	@RequestMapping("/stockPannerController_viewstockPanner")
	public String view(@RequestParam(required = true, value = "id") Integer id,
			 ModelMap modelMap){
		if(id!=null){
			Stocks stocks=stocksService.findById(id);
			 StringCodeProcessor scp=new StringCodeProcessor();

			 stocks.setLeadAgree((String) scp.processArrayValue(stocks.getLeadAgree(), new JsonConfig()));
			 stocks.setStockType((String) scp.processArrayValue(stocks.getStockType(), new JsonConfig()));

		      modelMap.put("stocks", stocks);	
		}
		return "stockPannerviewz" ;
	}
	
	@RequestMapping("/stockPannerController_findByIdstockPanner")
	public String findById(@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "inmappingId") Integer inmappingId, ModelMap modelMap){
		if(id !=null){
			
			Stock stock=stockPannerService.findById(id);
			Stock stocks=new Stock();
			stocks.setLeadDate(new Date());
			modelMap.put("stocks",stocks);
			modelMap.put("inmappingId", inmappingId);
			modelMap.put("stock",stock);
		}
		return "stockPannereditz";
	}
	@RequestMapping("/stockPannerController_modifystockPanner")
	public void mdify(Stock stock,@RequestParam(required = false, value = "inmappingId") Integer inmappingId,
			@RequestParam(required = false, value = "leadAgree") String leadAgree,
			HttpServletRequest request){
		stock.setLeadDate(new Date());
		stockPannerService.modifyStock(stock);
		if(leadAgree=="S002-0"){
			leadAgree="C001-51";
		}else{
			leadAgree="C001-50";
		}
		stockPannerService.modifyStatus(leadAgree, inmappingId);
	}
	
	
	
	@RequestMapping("/stocksPannerController_listview")
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
}
