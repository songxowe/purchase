package com.newer.purchase.enquire.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.enquire.dao.EnquireBMapper;
import com.newer.purchase.enquire.pojo.EnquireB;

@Service("enquireBService")
public class EnquireBService {
	@Resource(name="enquireBMapper")
	private EnquireBMapper enquireBMapper;
	
	public List<EnquireB> queryAll(Integer id){
		return enquireBMapper.queryAll(id);
	}
}