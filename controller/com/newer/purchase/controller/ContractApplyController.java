package com.newer.purchase.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.core.util.StringCodeProcessor;
import com.newer.purchase.pojo.ContractApply;
import com.newer.purchase.pojo.ContractApplyPanner;

import com.newer.purchase.service.ContractApplyService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class ContractApplyController {

	@Resource(name = "contractApplyService")
	private ContractApplyService contractApplyService;
	/**
	 * 部长审批 Planer
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param contAppNum
	 * @param response
	 */
	@RequestMapping("/contractApplyPlanerController_list")
	public void listPlaner(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "contAppNum") String contAppNum,
			HttpServletResponse response) {
		try {
			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;
			Pager<ContractApplyPanner> pager = contractApplyService.findPagerPlaner(pageno, pagesize, sort, order, contAppNum);
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
	
	@RequestMapping("/ContractApplyPlanerController_findById")
	public String findById(@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "inmappingId") Integer inmappingId, ModelMap modelMap){
		if(id !=null){
			
			ContractApply contractApply=contractApplyService.findByIdCa(id);
			ContractApply contractApplys=new ContractApply();
			contractApplys.setPlanDate(new Date());
			modelMap.put("contractApplys",contractApplys);
			modelMap.put("inmappingId", inmappingId);
			modelMap.put("contractApply",contractApply);
		}
		return "contractApplyPanneredit";
	}
	
	@RequestMapping("/contractApplyPlanerController_addplanAgree")
	public void addPlaner(ContractApply contractApply,@RequestParam(required = false, value = "inmappingId") Integer inmappingId,
			@RequestParam(required = false, value = "planAgree") String planAgree,
			HttpServletRequest request){
		contractApply.setPlanDate(new Date());
		contractApplyService.modifyPlaner(contractApply);
		if("S002-0".equals(planAgree)){
			planAgree="C001-131";
		}else{
			planAgree="C001-130";
		}
		contractApplyService.modifyPlanerStatus(planAgree, inmappingId);
	}
	
	
	/**
	 * 厂长审批 Planer
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param contAppNum
	 * @param response
	 */

	@RequestMapping("/contractApplyPannerController_viewstockPanner")
	  public String view(@RequestParam(required = false, value = "id") Integer id, ModelMap modelMap) {
	    if (id != null) {
	      ContractApplyPanner contractApplyPanner = contractApplyService.findByIdCaP(id);
	      modelMap.put("contractApplyPanner", contractApplyPanner);	      
	    }
	    return "contractApplyPannerview";
	  }
	
	
	@RequestMapping("/contractApplyLeaderController_list")
	public void listLeader(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "contAppNum") String contAppNum,
			HttpServletResponse response) {
		try {
			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;
			Pager<ContractApplyPanner> pager = contractApplyService.findPagerLeader(pageno, pagesize, sort, order, contAppNum);
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
	@RequestMapping("/contractApplyLeaderController_addLeaderleadAgree")
	public void addLeader(ContractApply contractApply,@RequestParam(required = false, value = "inmappingId") Integer inmappingId,
			@RequestParam(required = false, value = "leadAgree") String leadAgree,
			HttpServletRequest request){
		System.out.println("进入厂长审核-----------------------");
		contractApply.setLeadDate(new Date());
		System.out.println(contractApply);
		contractApplyService.modifyLeader(contractApply);
		
		System.out.println(leadAgree);
		if("S002-0".equals(leadAgree)){
			
			leadAgree="C001-141";
		}else{
			leadAgree="C001-140";
		}
		contractApplyService.modifyLeaderStatus(leadAgree, inmappingId);
	}
	@RequestMapping("/ContractApplyLeaderController_findById")
	public String findByIdLeader(@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "inmappingId") Integer inmappingId, ModelMap modelMap){
		if(id !=null){
			
			ContractApply contractApply=contractApplyService.findByIdCa(id);
			ContractApply contractApplys=new ContractApply();
			contractApplys.setLeadDate(new Date());
			
			modelMap.put("contractApplys",contractApplys);
			modelMap.put("inmappingId", inmappingId);
			modelMap.put("contractApply",contractApply);
	}
		return "contractApplyLeaderedit";
	}
	
	
	
}
