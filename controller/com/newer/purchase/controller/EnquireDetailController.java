package com.newer.purchase.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.purchase.enquire.service.EnquireServicec;
import com.newer.purchase.pojo.Enquire;
import com.newer.purchase.pojo.EnquireDetail;
import com.newer.purchase.service.EnquireDetailServicec;

/**
 * 询价书明细  控制器
 * @author
 */
public class EnquireDetailController {
	@Resource(name="enquireDetailServiceY")
	private EnquireDetailServicec enquireDetailServiceY;
	
	@Resource(name="enquireServicec")
	private EnquireServicec enquireService;
	/**
	 * 根据询价书id查询询价书细节
	 * @param enquireId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/enquireDetailController_findEnquireDetailByEnquireIdY")
	public String findEnquireDetailByEnquireId(@RequestParam(required=true,value="enquireId") Integer enquireId,ModelMap modelMap){
		if(enquireId!=null){
		
			Enquire enquire=enquireService.findById(enquireId);
			modelMap.put("enquire", enquire);
			
			List<EnquireDetail> enquireDetailList=enquireDetailServiceY.findEnquireDetailByEnquireId(enquireId);
			modelMap.put("enquireDetailList", enquireDetailList);
		}
		return "purchase/enquiredetail";
	}

}