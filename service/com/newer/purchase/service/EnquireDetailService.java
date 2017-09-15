package com.newer.purchase.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.dao.EnquireDatailMapper;
import com.newer.purchase.pojo.EnquireDetail;

/**
 * 询价书明细 业务逻辑类
 * @author Administrator
 *
 */
@Service("enquireDetailService")
public class EnquireDetailService {
	@Resource(name="enquireDatailMapper")
	private EnquireDatailMapper enquireDatailMapper;
	
	public List<EnquireDetail> findEnquireDetailByEnquireId(Integer enquireId){
		return enquireDatailMapper.findEnquireDetailByEnquireId(enquireId);
		
	}
}
