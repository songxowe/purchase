package com.newer.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.newer.purchase.pojo.IdMapping;
import com.newer.purchase.pojo.Stock;
import com.newer.purchase.service.IdMappingService;
import com.newer.purchase.service.StocksService;


@Controller
public class IdMappingController {
	@Resource(name="idMappingService")
	private IdMappingService idMappingService;
	@Resource(name="stocksService")
	private StocksService stocksService;
	@RequestMapping("/idMappingController_saveIdMapping")
	  public void saveIdMapping(@RequestParam(value="status")String status,@RequestParam(value="id")Integer id, HttpServletResponse response) {
	    System.out.println("进入报批");
	    System.out.println(status);
	    System.out.println(id);
	    if(status.equals("C001-60")){
	    	stocksService.modify(id);
	    }
		int count = 0;
	    count = idMappingService.modifyIdMapping(status,id);
	    try {
	      PrintWriter out = response.getWriter();
	      out.println(count);
	      out.flush();
	      out.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	
	@RequestMapping("/idMappingController_save")
	public void save(IdMapping idMapping, HttpServletResponse response) {
		int count = 0;
		if (idMapping != null && idMapping.getId() != null) {
			count = idMappingService.modify(idMapping);
		} else {
			count = idMappingService.add(idMapping);
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
