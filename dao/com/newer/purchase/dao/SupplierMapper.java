package com.newer.purchase.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Supplier;

@Repository("supplierMapper")
public interface SupplierMapper {
	
	@Select("select ID from SUPPLIER where USER_ID=#{userId}")
	Supplier findById(Integer userId);
}
