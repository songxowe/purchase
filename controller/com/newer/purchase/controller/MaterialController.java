package com.newer.purchase.controller;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.newer.core.util.Constants;
import com.newer.core.util.Pager;
import com.newer.pojo.User;
import com.newer.purchase.pojo.Material;
import com.newer.purchase.service.MaterialService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class MaterialController {
	@Resource(name="materialService")
	private MaterialService materialService;
	
	@RequestMapping("/materialController")
	public void list(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "materialNum") String materialNum,
		      @RequestParam(required = false, value = "materialName") String materialName,
		      HttpServletResponse response){
			
				
				try {
					if (!StringUtils.isEmpty(materialNum)) {
						// tips:为了体验转换为大写 (若模糊查询中文则不需要)
						materialNum = "%" + materialNum.toUpperCase() + "%";
					}
					if (!StringUtils.isEmpty(materialName)) {
						materialName = "%" + materialName.toUpperCase() + "%";
					}
					Integer pageno = (page - 1) * rows;
			        Integer pagesize = page * rows;
			        
			        Pager<Material> pager=materialService.findPager(pageno, pagesize, sort, order,materialNum, materialName);
			        JsonConfig jsonConfig=new JsonConfig();
			        JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
					 PrintWriter out = response.getWriter();
					 out.println(json.toString());
				     out.flush();
				     out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
	}
	
	
	@RequestMapping("/materialController_remove")
	public void remove(@RequestParam(required = true, value = "mids") String mids,HttpServletResponse response)
	{
		int count = 0;
	    String[] ids = mids.split(",");
	    
	    for(int i=0;i<ids.length;i++){
	    	
	    	Integer id = NumberUtils.createInteger(ids[i]);
	        count += materialService.remove(id);
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
	
	@RequestMapping("/materialController_save")
	public void save(Material material, HttpServletResponse response){
		int count=0;
		if(material!=null&&material.getId()!=null){
			System.out.println(material.getMaterialUnit()+"----"+material.getMaterialNum());
			
			count=materialService.modify(material);
		}else{
			count=materialService.add(material);
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
	
	  @RequestMapping("/materialController_view")
	  public String view(@RequestParam(required = true, value = "id") Integer id, ModelMap modelMap) {
	    if (id != null) {
	      Material material = materialService.findById(id);
	      modelMap.put("material", material);
	    }
	    return "materialview";
	  }
	  
	  @RequestMapping("/materialController_findById")
	  public String findById(@RequestParam(required = false, value = "id") Integer id, ModelMap modelMap){
		  if (id != null) {
			      Material material = materialService.findById(id);
			      modelMap.put("material", material);
			    }
		  return "materialedit";
	  }
	  
	  @RequestMapping("/materialController_goadd")
		public String getSingle(@RequestParam(required=false,value="id")Integer id,ModelMap modelMap,
					HttpServletRequest request,HttpServletResponse response){
			System.out.println("进入go新增/");
			HttpSession session = request.getSession();
			User user=(User)session.getAttribute(Constants.USER_IN_SESSION);
			System.out.println("id:"+user.getId());
			System.out.println("username:"+user.getUsername());
			
			if(id!=null){
				Material material=materialService.findById(id);
				System.out.println("num:"+material.getMaterialNum()+"  "+"name:"+material.getMaterialName());
				modelMap.put("material", material);		
			}
			System.out.println("离开go新增/修改");
			return "ordersadd";
		}

}
