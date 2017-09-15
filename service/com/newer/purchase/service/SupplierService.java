package com.newer.purchase.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.newer.purchase.dao.SupplierMapper;
import com.newer.purchase.pojo.Supplier;

@Repository("supplierService")
public class SupplierService {
	
	@Resource(name = "supplierMapper")
	private SupplierMapper supplierMapper;

	public Supplier findById(Integer userId){
		return supplierMapper.findById(userId);
	}
}
