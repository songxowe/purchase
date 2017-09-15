package com.newer.purchase.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;


import com.newer.core.util.Pager;
import com.newer.purchase.dao.ContractApplyMapper;
import com.newer.purchase.pojo.ContractApply;
import com.newer.purchase.pojo.ContractApplyPanner;


@Service("contractApplyService")
public class ContractApplyService {
	
	@Resource(name="contractApplyMapper")
	private ContractApplyMapper contractApplyMapper;
	
	
	public Pager<ContractApplyPanner> findPagerPlaner(Integer pageno, Integer pagesize, String sort, String order, String contAppNum
		      ){
		 Pager<ContractApplyPanner> pager = new Pager<ContractApplyPanner>();
		    // 设置分页数据
		    pager.setRows(contractApplyMapper.findPagerPlaner(pageno, pagesize, sort, order, contAppNum));
		    // 设置数据总数
		    pager.setTotal(contractApplyMapper.findPagerTotalPlaner(contAppNum));
		   return pager;
	}
	public int modifyPlaner(ContractApply contractApply){
		return contractApplyMapper.modifyPlaner(contractApply);
	}
	
	public int modifyPlanerStatus(String planAgree,Integer inmappingId){
		return contractApplyMapper.modifyPlanerStatus(planAgree, inmappingId);
	}
	
	
	public Pager<ContractApplyPanner> findPagerLeader(Integer pageno, Integer pagesize, String sort, String order, String contAppNum
		      ){
		 Pager<ContractApplyPanner> pager = new Pager<ContractApplyPanner>();
		    // 设置分页数据
		    pager.setRows(contractApplyMapper.findPagerLeader(pageno, pagesize, sort, order, contAppNum));
		    // 设置数据总数
		    pager.setTotal(contractApplyMapper.findPagerTotalLeader(contAppNum));
		   return pager;
	}
	
	
	public int modifyLeader(ContractApply contractApply){
		return contractApplyMapper.modifyLeader(contractApply);
	}
	
	public int modifyLeaderStatus(String leadAgree,Integer inmappingId){
		return contractApplyMapper.modifyLeaderStatus(leadAgree, inmappingId);
	}
	
	public ContractApply findByIdCa(Integer id){
		return contractApplyMapper.findByIdCa(id);
	}
	
	public ContractApplyPanner findByIdCaP(Integer id){
		return contractApplyMapper.findByIdCaP(id);
	}
	
}
