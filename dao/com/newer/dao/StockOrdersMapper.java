package com.newer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.newer.enquire.pojo.Orders;
import com.newer.enquire.pojo.Stock;



@Repository("stockOrdersMapper")
public interface StockOrdersMapper {
	/**
	 * 根据主键id,查询Stock
	 * @param
	 */
	Stock findById(Integer id);
	/*
	 * 根据STOCK主键id,查询ORDERS所有
	 */
	List<Orders> findRole(Integer Id);
	
}
