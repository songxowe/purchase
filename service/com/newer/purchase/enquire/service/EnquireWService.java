package com.newer.purchase.enquire.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.enquire.dao.EnquireWMapper;
import com.newer.purchase.pojo.Enquire;


/**
 * 询价书详细表
 * @author Administrator
 *
 */
@Service("enquireWService")
public class EnquireWService {
	@Resource(name="enquireWMapper")
	private EnquireWMapper enquireWMapper;
	/**
	 * 根据id 获取询价书的信息
	 * @param id
	 * @return
	 */
	public Enquire findById(Integer id){
		return enquireWMapper.findById(id);
	}
}
