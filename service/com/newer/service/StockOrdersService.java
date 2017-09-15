package com.newer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.dao.StockOrdersMapper;
import com.newer.enquire.pojo.Orders;
import com.newer.enquire.pojo.Stock;

@Service("stockOrdersService")
public class StockOrdersService {
	@Resource(name="stockOrdersMapper")
	private StockOrdersMapper stockOrdersMapper;
	/*
	 * 根据主键id,查询Stock
	 */
	public Stock findById(Integer id){
		return stockOrdersMapper.findById(id);
	}
	/*
	 * 根据STOCK主键id,查询ORDERS所有
	 */
	public List<Orders> findRole(Integer Id){
		return stockOrdersMapper.findRole(Id);
	}
	
}
