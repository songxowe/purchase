package com.newer.purchase.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.purchase.enquire.service.EnquireServicec;
import com.newer.purchase.pojo.Enquire;


/**
 * 询价书明细界面 
 * @author 
 */
@Controller
@RequestMapping("/enquire")
public class EnquireController {
	@Resource(name="enquireServicec")
	private EnquireServicec enquireServiceY;
	
	/**
	 * 根据询价书id查询询价书部分信息
	 * 返回询价书明细界面
	 * @param id
	 * @param modelMap
	 * @return
	 */
	
	@RequestMapping("/enquireController_findEnquireByIdY")
	public String findEnquireById(@RequestParam(required=true,value="id") Integer id,ModelMap modelMap){
		if(id!=null){
			Enquire enquire=enquireServiceY.findById(id);
			modelMap.put("enquire", enquire);
		}
		return "purchase/enquiredetail";
	}
	
}
