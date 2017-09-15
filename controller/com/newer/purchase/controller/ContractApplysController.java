package com.newer.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.Pager;
import com.newer.purchase.pojo.ContractApply;
import com.newer.purchase.pojo.dto.ContractApplys;
import com.newer.purchase.service.ContractApplysService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class ContractApplysController {
	@Resource(name="contractApplysService")
	private ContractApplysService contractApplysService;
	
	@RequestMapping("/contractApplysController")
	public void list(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "contAppNum") String contAppNum,
		      HttpServletResponse response){
		System.out.println("------------------------------------------");
		System.out.println(page+" "+rows+" "+sort+" "+order+" "+contAppNum);
		try{
			if(!StringUtils.isEmpty(contAppNum)){
				contAppNum = "%" + contAppNum.toUpperCase() + "%";
			}
			Integer pageno = (page - 1) * rows;
		      Integer pagesize = page * rows;
		      Pager<ContractApplys> pager=contractApplysService.findPager(pageno, pagesize, sort, order, contAppNum);
		      
		      JsonConfig jsonConfig=new JsonConfig();
		        JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
		        System.out.println("--------------------------------");
		        System.out.println(json);
		        
				 PrintWriter out = response.getWriter();
				 out.println(json.toString());
			     out.flush();
			     out.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
