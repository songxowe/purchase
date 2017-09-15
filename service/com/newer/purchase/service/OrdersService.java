package com.newer.purchase.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.newer.purchase.dao.OrdersMapper;
import com.newer.purchase.pojo.Orders;

@Repository("ordersService")
public class OrdersService {
	
	@Resource(name = "ordersMapper")
	private OrdersMapper ordersMapper;

	public Orders findById(Integer id){
		return ordersMapper.findById(id);
	}
	
	public Orders findByOrders(Integer id){
		return ordersMapper.findByOrders(id);
	}
}
