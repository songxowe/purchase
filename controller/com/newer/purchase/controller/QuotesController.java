package com.newer.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.newer.core.util.JsonDateValueProcessor;
import com.newer.core.util.Pager;
import com.newer.purchase.pojo.Contract;
import com.newer.purchase.pojo.ContractDetail;
import com.newer.purchase.pojo.dto.Contractfile;
import com.newer.purchase.pojo.dto.Preparecontract;
import com.newer.purchase.service.QuotesService;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class QuotesController {
	@Resource(name="quotesService")
	private QuotesService quotesService;
	
	

	
	@RequestMapping("/quoteController_editcont")
	public String list(@RequestParam(required = true, value = "enquireid") Integer enquireid, ModelMap modelMap){
		System.out.println("合同编制-------------------------------------------------");
		if(enquireid!=null){
			List<Preparecontract> preparecontract =quotesService.findQuote(enquireid,null);
			Contract cont=new Contract();
			cont.setContDate(new Date());
			cont.setContNum(quotesService.getCode());
			modelMap.put("preparecontract", preparecontract);
			modelMap.put("enquireid", enquireid);
			modelMap.put("contract", cont);
			
		}
		return "contract";
	}
	
	
	
	@RequestMapping("/contractController")//cwrap 包装要求
	public void add(
			Contract contract,
			ContractDetail contractDetail,
			@RequestParam(value = "vdate",required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date vdate,
			@RequestParam(value = "cwrap") String cwrap, 
			@RequestParam(value = "eid") Integer eid,
			@RequestParam(value = "qid") Integer qid,
			HttpServletResponse response){
		System.out.println("----------------进入合同编制");
		Preparecontract preparecontract=quotesService.findQuote(eid, qid).get(0);
		contract.setContDate(new Date());
		contract.setVerifyDate(vdate);
		contract.setWrapRequire(cwrap);
		contract.setSuppliernum(preparecontract.getSnum());
		contractDetail.setWrapRequire(cwrap);
		if(quotesService.addContract(contract)>0){
			contractDetail.setContId(quotesService.findContractId());
			contractDetail.setMaterialCode(preparecontract.getMaterialCode());
			contractDetail.setMaterialName(preparecontract.getMaterialName());
			contractDetail.setAmount(preparecontract.getAmount());
			contractDetail.setUnitPrice(preparecontract.getUnitPrice());
			contractDetail.setMeasureUnit(preparecontract.getMeasureUnit());
			contractDetail.setSumPrice(preparecontract.getSumPrice());
			contractDetail.setMixPrice(preparecontract.getMixPrice());
			contractDetail.setOtherPrice(preparecontract.getOtherPrice());
			contractDetail.setTotalPrice(preparecontract.getTotalPrice());
			contractDetail.setEndDate(preparecontract.getEndDate());
			contractDetail.setAddress(contract.getPlace());
			contractDetail.setTrans(contract.getTran());
			System.out.println(contractDetail);
			int rows=quotesService.addContractDetail(contractDetail);
			System.out.println("rows="+rows);
			if(rows>0){
				
				int mid=quotesService.findContractId();
				quotesService.modifyContId(mid, eid);
				System.out.println(eid);
				quotesService.modifyQid(qid, eid);
				quotesService.modify(mid);
			}
		}
		
		System.out.println("-----------------离开合同编制");
		
	}
	
	@RequestMapping("/contractFile")
	public void list(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "contNum") String contNum,
		      HttpServletResponse response){
		System.out.println("------------------------------------------");
		System.out.println(page+" "+rows+" "+sort+" "+order+" "+contNum);
		try{
			if(!StringUtils.isEmpty(contNum)){
				contNum = "%" + contNum.toUpperCase() + "%";
			}
			Integer pageno = (page - 1) * rows;
		      Integer pagesize = page * rows;
		      Pager<Contractfile> pager=quotesService.findPager(pageno, pagesize, sort, order, contNum);
		      
		      JsonConfig jsonConfig=new JsonConfig();
		      jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
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
	
	@RequestMapping("/contractFilecomplete")
	public void modifyId(@RequestParam(value = "id") Integer id,
			HttpServletResponse response) throws IOException{
		System.out.println("合同归档---------------------------------id="+id);
		int count=quotesService.modifyId(id);
		PrintWriter pw=response.getWriter();
		pw.print(count);
		pw.close();
	}
}
