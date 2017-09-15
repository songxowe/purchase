package com.newer.purchase.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.dao.OrderssMapper;
import com.newer.purchase.pojo.dto.Orderss;

@Service("orderssService")
public class OrderssService {
	@Resource(name="orderssMapper")
	private OrderssMapper orderssMapper;
	
	public Orderss findById(Integer id){
		return orderssMapper.findById(id);
	}

}
