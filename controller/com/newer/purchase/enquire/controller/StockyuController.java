package com.newer.purchase.enquire.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.purchase.enquire.pojo.Stock;
import com.newer.purchase.enquire.service.StockService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
@Controller
public class StockyuController {
	@Resource(name="stockService")
	private StockService stockService;
	@RequestMapping("/stockController")
	public void list(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "stock_name") String stock_name,
		      @RequestParam(required = false, value = "stock_type") String stock_type, HttpServletResponse response) {

		try {
				    if (!StringUtils.isEmpty(stock_name)) {
				     stock_name = "%" + stock_name + "%";
				    }
				    

		      Integer pageno = (page - 1) * rows;
		      Integer pagesize = page * rows;

		      Pager<Stock> pager = stockService.findPager(pageno, pagesize, sort, order, stock_name,stock_type);

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
		  }
	@RequestMapping("/stockController_remove")
	 public void remove(@RequestParam(required = true, value = "ids") String ids, HttpServletResponse response) {
	    int count = 0;
	    String[] stockIds = ids.split(",");
	    for (int i = 0; i < stockIds.length; i++) {
	      Integer id = NumberUtils.createInteger(stockIds[i]);
	      count += stockService.remove(id);
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
}
