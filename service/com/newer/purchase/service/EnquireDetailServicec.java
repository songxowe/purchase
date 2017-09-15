package com.newer.purchase.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.dao.EnquireDatailMapperc;
import com.newer.purchase.pojo.EnquireDetail;

/**
 * 询价书明细 业务逻辑类
 * @author Administrator
 *
 */
@Service("enquireDetailServicec")
public class EnquireDetailServicec {
	@Resource(name="enquireDatailMapperc")
	private EnquireDatailMapperc enquireDatailMapper;
	
	public List<EnquireDetail> findEnquireDetailByEnquireId(Integer enquireId){
		return enquireDatailMapper.findEnquireDetailByEnquireId(enquireId);
		
	}
}
