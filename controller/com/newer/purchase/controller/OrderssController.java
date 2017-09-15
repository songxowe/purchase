package com.newer.purchase.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.purchase.pojo.dto.Orderss;
import com.newer.purchase.service.OrderssService;

@Controller
public class OrderssController {
	@Resource(name="orderssService")
	private OrderssService orderssService;
	
	@RequestMapping("/orderssController_findById")
	  public String findById(@RequestParam(required = false, value = "id") Integer id, ModelMap modelMap) {
	    if (id != null) {
	      Orderss orderss = orderssService.findById(id);
	      modelMap.put("orderss", orderss);
	    }
	    return "orderssedit";
	  }

}
