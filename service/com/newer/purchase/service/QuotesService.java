package com.newer.purchase.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.dao.QuotesMapper;
import com.newer.purchase.pojo.Contract;
import com.newer.purchase.pojo.ContractDetail;
import com.newer.purchase.pojo.dto.Contractfile;
import com.newer.purchase.pojo.dto.Preparecontract;

@Service("quotesService")
public class QuotesService {
	@Resource(name="quotesMapper")
	private QuotesMapper quotesMapper;
	
	public List<Preparecontract> findQuote(Integer id,Integer quoteId){
		return quotesMapper.findQuote(id,quoteId);
	}
	//合同录入修改状态码
	public int modify(Integer contId){
		return quotesMapper.modify(contId);
	}
	//修改编号对照表合同id
	public int modifyContId(Integer contId,Integer eid){
		return quotesMapper.modifyContId(contId,eid);
	}
	
	//合同已签订将已签订的报价书id更新至编号对照表
	public int modifyQid(Integer qid,Integer eid){
		return quotesMapper.modifyQid(qid, eid);
	}
	public Pager<Contractfile> findPager(Integer pageno, Integer pagesize, String sort, String order,
			String contNum	){
			
			Pager<Contractfile> pager=new Pager<Contractfile>();
			pager.setRows(quotesMapper.findPager(pageno, pagesize, sort, order, contNum));
			pager.setTotal(quotesMapper.findTotal(contNum));
			return pager;
		}
	//合同归档状态码修改
	public int modifyId(Integer id){
		return quotesMapper.modifyId(id);
	}
	
	//添加合同表信息
	public int addContract(Contract contract){
		return quotesMapper.addContract(contract);
	}
	//添加合同明细表信息
	public int addContractDetail(ContractDetail contractDetail){
		return quotesMapper.addContractDetail(contractDetail);
	}
	//查找合同表id
	public int findContractId(){
		return quotesMapper.findContractId();
	}
	
	public String getCode(){
		Date d=new Date();
		StringBuffer code=new StringBuffer();
		code.append(d.getYear()+1900);
		code.append(String.format("%02d", d.getMonth()+1));
		code.append(String.format("%02d", d.getDay()));
		code.append(String.format("%02d", d.getHours()));
		code.append(String.format("%02d", d.getMinutes()));
		code.append(String.format("%02d", d.getSeconds()));			
		return code.toString();
	}
}
