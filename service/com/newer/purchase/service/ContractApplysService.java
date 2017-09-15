package com.newer.purchase.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.newer.core.util.Pager;
import com.newer.purchase.dao.ContractApplysMapper;
import com.newer.purchase.pojo.dto.ContractApplys;



@Service("contractApplysService")
public class ContractApplysService {
	@Resource(name="contractApplysMapper")
	private ContractApplysMapper contractApplysMapper;
	
	public Pager<ContractApplys> findPager(Integer pageno, Integer pagesize, String sort, String order,
			String contAppNum){
		
		Pager<ContractApplys> pager=new Pager<ContractApplys>();
		pager.setRows(contractApplysMapper.findPager(pageno, pagesize, sort, order,  contAppNum));
		pager.setTotal(contractApplysMapper.findPagerTotal(contAppNum));
		return pager;
	}
}
