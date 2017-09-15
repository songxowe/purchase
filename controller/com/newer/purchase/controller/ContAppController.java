package com.newer.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.Constants;
import com.newer.core.util.DateValueProcessor;

import com.newer.core.util.Pager;
import com.newer.core.util.StringCodeProcessor;
import com.newer.pojo.User;
import com.newer.purchase.pojo.ContAppList;
import com.newer.purchase.pojo.ContractApply;
import com.newer.purchase.pojo.Employee;
import com.newer.purchase.pojo.Enquire;

import com.newer.purchase.pojo.EnquireList;
import com.newer.purchase.pojo.IdMapping;
import com.newer.purchase.service.QuoteContAppService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class ContAppController {
	@Resource(name = "quoteContAppService")
	private QuoteContAppService quoteContAppService;

	@RequestMapping("enquireList")
	public void enquireList(@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "rows", required = true) Integer rows,
			@RequestParam(value = "sort", required = true) String sort,
			@RequestParam(value = "order", required = true) String order,
			@RequestParam(value = "enquireName", required = false) String enquireName,
			@RequestParam(value = "beginDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			HttpServletResponse resp) throws IOException {
		int beginPage = (page - 1) * rows;
		int endPage = page * rows;
		if(enquireName!=null &&!"".equals(enquireName)){
			enquireName="%"+enquireName+"%";
		}
		Pager<EnquireList> pager = quoteContAppService.findEnquirePager(beginPage, endPage, order, sort, enquireName,
				beginDate, endDate);		
		PrintWriter pw = resp.getWriter();
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(Date.class, new DateValueProcessor());
		JSONObject jo = (JSONObject) JSONSerializer.toJSON(pager, jc);
		System.out.println(jo);
		pw.print(jo);
		pw.close();
	}
	
	@RequestMapping("findEnquire")
	public String findEnquire(
			@RequestParam(value = "eid", required = false) Integer eid,
			@RequestParam(value = "cid", required = false) Integer cid,
			ModelMap map){
		System.out.println("findEnquire------------------------eid="+eid);
		if(cid!=null){
			System.out.println("------------------------cid="+cid);
			eid=quoteContAppService.findEnquireByContAppId(cid);
			System.out.println("------------------------eid="+eid);
			map.put("flag", "flag");
		}
		
		Enquire enquire=quoteContAppService.findEnquireById(eid);
		map.put("enquire", enquire);
		return "quoteviewW";
	}
	
	@RequestMapping("editContractApply")
	public String editContApp(@RequestParam(value = "eid", required = true) Integer eid,ModelMap map){
		Enquire enquire=quoteContAppService.findEnquireById(eid);
		map.put("enquire", enquire);
		return "editContractApplyW";
	}
	
	@RequestMapping("addContractApply")
	public void addContApp(ContractApply apply,
			@RequestParam(value="eid")int eid,
			HttpServletResponse resp,
			HttpServletRequest req) throws IOException{
		System.out.println("----------------------进入新增合同申请");
		User user = (User) req.getSession().getAttribute(Constants.USER_IN_SESSION);
		Employee emp=quoteContAppService.findEmpByUserId(user.getId());
		double minPrice=Double.parseDouble(apply.getLowQuote());
		double maxPrice=Double.parseDouble(apply.getTopQuote());
		String contAppNum=quoteContAppService.getCode();
		int statQuote=Integer.parseInt(apply.getStatQuote());
		double sumPrice=apply.getAllSumPrice();
		String remark=apply.getRemark();
		int authorId=emp.getId();
		String author=emp.getEmpName();
		int count=quoteContAppService.addContractApply(contAppNum, statQuote, minPrice, maxPrice, sumPrice, remark, authorId, author);
		if(count>0){
			int contAppId=quoteContAppService.findContAppId();
			IdMapping mapping=quoteContAppService.findIdMapping(eid);
			int mappingId= mapping.getId();
			quoteContAppService.modifyIdMappingContApp(contAppId,mappingId);
			quoteContAppService.modifyIdMappingStatus(mappingId, "C001-110");
		}
		PrintWriter pw=resp.getWriter();
		pw.print(count);
		pw.close();
		
	}
	
	@RequestMapping("contAppList")
	public void contAppList(@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "rows", required = true) Integer rows,
			@RequestParam(value = "sort", required = true) String sort,
			@RequestParam(value = "order", required = true) String order,
			@RequestParam(value = "contAppNum", required = false) String contAppNum,
			HttpServletResponse resp) throws IOException{
		System.out.println("合同申请列表------------------------");
		int beginPage = (page - 1) * rows;
		int endPage = page * rows;
		if(contAppNum!=null &&!"".equals(contAppNum)){
			contAppNum="%"+contAppNum+"%";
		}
		Pager<ContAppList> pager = quoteContAppService.findContAppPager(beginPage, endPage, order, sort, contAppNum);
		PrintWriter pw = resp.getWriter();
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(String.class, new StringCodeProcessor());
		JSONObject jo = (JSONObject) JSONSerializer.toJSON(pager, jc);
		System.out.println(jo);
		pw.print(jo);
		pw.close();
		
		
	}
	
	@RequestMapping("sendContApp")
	public void sendContApp(@RequestParam(value = "mid") Integer mid,HttpServletResponse resp) throws IOException{
		System.out.println("进入送审------------------------------");
		int count=quoteContAppService.modifyIdMappingStatus(mid, "C001-120");
		PrintWriter pw=resp.getWriter();
		pw.print(count);
		pw.close();
	}
	
	
	
	
	
	
	

}
