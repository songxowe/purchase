package com.newer.purchase.enquire.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.core.util.StringCodeProcessor;
import com.newer.purchase.enquire.pojo.EnquireX;
import com.newer.purchase.enquire.service.EnquireXService;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

/**
 * 表示层：修改询价书
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/enquire")//enquire
public class EnquireXController {
	@Resource(name = "enquireXService")
	private EnquireXService enquireXService;

	/**
	 * 显示询价书列表
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param status
	 * @param enquireName
	 * @param response
	 */
	@RequestMapping("/enquireXController_list")
	public void list(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "status") String status,
			@RequestParam(required = false, value = "enquireName") String enquireName, HttpServletResponse response) {
		// 设置字符集
		response.setCharacterEncoding("utf-8");
		// 判断status 状态是否为空
		if (!StringUtils.isEmpty(status)) {
			status = "%" + status + "%";
		}
		// 判断enquireName是否为空
		if (!StringUtils.isEmpty(enquireName)) {
			enquireName = "%" + enquireName + "%";
		}

		// 设置分页页号和分页
		Integer pageno = (page - 1) * rows;
		Integer pagesize = page * rows;

		Pager<EnquireX> pager = enquireXService.findPager(pageno, pagesize, sort, order, status, enquireName);
		// 设置时间格式
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		config.registerJsonValueProcessor(String.class, new StringCodeProcessor());
		JSON json = JSONSerializer.toJSON(pager, config);
		// 封装分页数据到json
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
