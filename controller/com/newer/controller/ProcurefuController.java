package com.newer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.enquire.pojo.Enquire;
import com.newer.enquire.pojo.EnquireDetail;
import com.newer.enquire.pojo.IdMapping;
import com.newer.enquire.pojo.Orders;
import com.newer.enquire.pojo.Stock;
import com.newer.service.EnquireFuService;
import com.newer.service.IdMappingServicec;
import com.newer.service.StockOrdersService;

@Controller
@RequestMapping("/procurefu")
public class ProcurefuController {
	
	@Resource(name = "stockOrdersService")
	private StockOrdersService stockOrdersService;
	
	@Resource(name = "enquireFuService")
	private EnquireFuService enquireFuService;
	
	@Resource(name = "idMappingServicec")
	private IdMappingServicec idMappingServicec;

	
	@RequestMapping("/procurefuController_goadd")
	public String findById(@RequestParam(required = true, value = "id") Integer id, 
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("进入询价编制页面");
		HttpSession session = request.getSession();
		session.setAttribute("stockEnquireID", id);
		Stock stock = stockOrdersService.findById(id);
		modelMap.put("stock", stock);
		List<Orders> list = stockOrdersService.findRole(id);
		modelMap.put("list", list);
		System.out.println("离开询价编制页面");
		return "procure/procurefuadd";
	}
	
	@RequestMapping("/procurefuController_add")
	public void add(Enquire enquire,
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("进入编制询价书");
		//获得采购id
		HttpSession session = request.getSession();
		int stockID=(Integer)session.getAttribute("stockEnquireID");
		
		int count=0;
		
		//1.向询价表添加一条数据
		int count1=0;
		enquire.setBuildDate(new Date());
		count1=enquireFuService.add(enquire);
		if(count1>0){
			//2.根据采购id，修改编号对应表
			//获得询价表的最大的id，即刚刚添加成功后的数据
			int enquireID=enquireFuService.findMaxID();
			int count2=0;
			IdMapping idMapping=new IdMapping();
			idMapping.setStockID(stockID);
			idMapping.setEnquireID(enquireID);
			count2=idMappingServicec.modifyEqnuireID(idMapping);
			
			//3.向询价书详细表中(根据采购计划的需求信息)对应添加多条数据
			//根据采购id获得需求计划的集合
			List<Orders> list = stockOrdersService.findRole(stockID);
			//遍历集合，进行添加
			int count3=0;
			for(int i=0;i<list.size();i++){
				Orders orders=list.get(i);
				EnquireDetail enquireDetail=new EnquireDetail();
				enquireDetail.setEnquireId(enquireID);
				enquireDetail.setOrderId(orders.getId());
				enquireDetail.setMaterialCode(orders.getMaterialCode());
				enquireDetail.setMaterialName(orders.getMaterialName());
				enquireDetail.setAmount(orders.getAmount());
				enquireDetail.setMeasureUnit(orders.getMeasureUnit());
				enquireDetail.setStartDate(orders.getStartDate());
				enquireDetail.setEndDate(orders.getEndDate());
				enquireDetail.setStandard("Z000-1");
				enquireDetail.setFactory(enquire.getCompany());
				enquireDetail.setProdYear("S003-1");
				enquireDetail.setWrap("标准包装");
				enquireDetail.setRemark("");
				count3+=enquireFuService.add1(enquireDetail);				
			}
			if(count3>0){
				count=count1;
			}
			
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println(count);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("询价书编制采购");		
	}
}
