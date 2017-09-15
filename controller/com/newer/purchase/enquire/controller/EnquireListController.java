package com.newer.purchase.enquire.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.purchase.enquire.pojo.EnquireB;
import com.newer.purchase.enquire.service.EnquireBService;
import com.newer.purchase.enquire.service.EnquireWService;
import com.newer.purchase.pojo.Enquire;


/**
 * 表示层：修改询价书
 * @author Administrator
 *
 */
@Controller
public class EnquireListController {
	@Resource(name="enquireWService")
	private EnquireWService enquireWService;
	@Resource(name="enquireBService")
	private EnquireBService enquireBService;
	
	/**
	 * 跳转至修改询价书界面，并赋初值
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/enquireController_getW")
	public String get(@RequestParam(required=true,value="id")Integer id,ModelMap modelMap){
		//根据获取当前询价书信息
		if(id!=null){
			Enquire enquire=enquireWService.findById(id);
			modelMap.put("enquire", enquire);
			List<EnquireB> list=enquireBService.queryAll(id);
			modelMap.put("list",list);
		}
		return "enquire/enquireInfoW";
	}
	
}