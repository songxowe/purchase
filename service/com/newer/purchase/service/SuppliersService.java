package com.newer.purchase.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.dao.SuppliersMapper;
import com.newer.purchase.pojo.Supplier;







@Service("suppliersService")
public class SuppliersService {
	
	
	@Resource(name = "suppliersMapper")
	private SuppliersMapper suppliersMapper;
	
	
	
	
	/**
	 * 条件 + 分页查询所有供应商信息
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param supplierNum
	 * @param company
	 * @param kind
	 * @return
	 */
	public Pager<Supplier> findPager(Integer pageno, Integer pagesize, String sort, String order, 
			String supplierNum,
			String company, 
			String kind) {
		Pager<Supplier> pager = new Pager<Supplier>();
		pager.setRows(suppliersMapper.findPager(pageno, pagesize, sort, order, supplierNum, company, kind));
		pager.setTotal(suppliersMapper.findPagerTotal(supplierNum, company, kind));
		return pager;
	}
	
	
	
	/**
	 * 根据id 查询供应商信息
	 * @param id
	 * @return
	 */
	public Supplier findById(Integer id){
		return suppliersMapper.findById(id);
	}
	
	

	
	
	public int add(Supplier supplier) {
		return suppliersMapper.add(supplier);
	}
	
	
	/**
	 * 查询最大的id
	 * @return
	 */
	public int findMaxId(){
		return suppliersMapper.findMaxId();
	}
	

}
