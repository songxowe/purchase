package com.newer.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.purchase.pojo.Supplier;
import com.newer.purchase.service.SuMaSupViewService;
import com.newer.purchase.service.SuppliersService;
import com.newer.purchase.pojo.SuMaSupView;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller

public class SuppliersController {

	@Resource(name = "suppliersService")
	private SuppliersService suppliersService;
	
	@Resource(name="suMaSupViewServicef")
	private SuMaSupViewService  suMaSupViewServicef;
	/**
	 * 查看供应商信息一览表
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param supplierNum
	 * @param company
	 * @param kind
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/supplierController_list")
	public void list(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "supplierNum") String supplierNum,
			@RequestParam(required = false, value = "company") String company,
			@RequestParam(required = false, value = "kind") String kind, HttpServletResponse response) throws IOException {
		System.out.println("进入供应商信息查询");
	
		
			if (!StringUtils.isEmpty(supplierNum)) {
				
				supplierNum = "%" +supplierNum.toUpperCase()+"%";
				System.out.println(supplierNum+""+"1");
			}
			if (!StringUtils.isEmpty(company)) {
				company = "%"+ company + "%";
			}
			if (!StringUtils.isEmpty(kind)) {
				kind = "%" + kind+ "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<Supplier> pager = suppliersService.findPager(pageno, pagesize, sort, order, supplierNum, company,
					kind);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
			System.out.println(supplierNum);
			System.out.println(kind);
		
		System.out.println("离开供应商信息查询");
	}

	/**
	 * 进入供应商页面跳转
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/supplierController_goSupplier")
	public String doSupplier(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入到供应商页面");
		

	return "supplierlist2";
		}

	

	/**
	 * 在供应商页面选择供应商，返回json数组
	 * 
	 * @param ids
	 * @param response
	 */
	@RequestMapping("/supplierController_suppliers")
	public void listSupplier(@RequestParam(required = true, value = "ids") String ids, HttpServletResponse response) {
		System.out.println("进入供应商选择");
		try {
			String[] ids_ = ids.split(",");
			List<Supplier> list = new ArrayList<Supplier>();

			for (int i = 0; i < ids_.length; i++) {
				Integer id = NumberUtils.createInteger(ids_[i]);
				Supplier supplier = suppliersService.findById(id);
				list.add(supplier);
			}

			// JsonConfig jsonConfig = new JsonConfig();
			JSONArray jsonArray = JSONArray.fromObject(list);
			// JSONObject json = (JSONObject) JSONSerializer.toJSON(list,
			// jsonConfig);

			PrintWriter out = response.getWriter();
			System.out.println(jsonArray.toString());
			out.println(jsonArray.toString());
			out.flush();
			out.close();
			System.out.println("完成供应商选择");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 查看供应商基本信息
	 * 
	 * @param id
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/supplierController_supplier")
	public String goSupplier(@RequestParam(required = true, value = "id") Integer id, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入供应商基本信息");
		Supplier supplier = suppliersService.findById(id);
		modelMap.put("supplier", supplier);
		return "supplierdetails";

	}

	/**
	 * 显示供应商注册信息
	 * 
	 * @param id
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 */
//	@RequestMapping("/supplierController_register")
//	public String goSupplier1(@RequestParam(required = true, value = "id") Integer id, ModelMap modelMap,
//			HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("进入供应商注册信息");
//		SuEmpSupView suEmpSupView = suppliersServicef.findSById1(id);
//		modelMap.put("suEmpSupView", suEmpSupView);
//
//		return "plan/supplierregistermsg";
//
//	}

	@RequestMapping("/supplierController_add")
	public void add(Supplier supplier, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入添加供应商");
		System.out.println("kind:" + supplier.getKind());
		HttpSession session = request.getSession();
		int id = suppliersService.findMaxId();
		session.setAttribute("supplierID", id);

		int count = 0;
		long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String supplierNum="W"+nowLong;
		supplier.setSupplierNum(supplierNum);
		System.out.println(supplier);
		count = suppliersService.add(supplier);

		

		try {
			PrintWriter out = response.getWriter();
			out.println(count);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("离开添加供应商");

	}
	
	
	
	@RequestMapping("/supplierController_listView")
	public void listView(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "company") String company,
			@RequestParam(required = false, value = "materialName") String materialName,
		HttpServletResponse response) {
		System.out.println("进入供应商物资信息查询");
		try {
		if (!StringUtils.isEmpty(company)) {
			company = "%" + company + "%";
		}
			if (!StringUtils.isEmpty(materialName)) {
				materialName = "%" + materialName + "%";
			}


		Integer pageno = (page - 1) * rows;
		Integer pagesize = page * rows;

			Pager<SuMaSupView> pager = suMaSupViewServicef.findPager(pageno, pagesize, sort, order, company, materialName);
			JsonConfig jsonConfig = new JsonConfig();			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

		JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
		out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(company);
	System.out.println("离开供应商物资信息查询");
	}

	
	@RequestMapping("/supplierController_chooseSupplier")
	public void chooseSupplier(@RequestParam(required = true, value = "id") Integer id,
			HttpServletRequest request, HttpServletResponse response){
		System.out.println("进入定向采购供应商选择");
		
		
		
		int count=0;
		
		String stockType = request.getParameter("stockType");
		System.out.println("stockType=" + stockType);
		if ("C000-2".equals(stockType)) {
			count=1;
			HttpSession session = request.getSession();
			session.setAttribute("chooseSupplierID", id);
			System.out.println("id:"+id);
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
