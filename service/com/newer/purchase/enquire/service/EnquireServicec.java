package com.newer.purchase.enquire.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.dao.EnquireMapperc;
import com.newer.purchase.pojo.Enquire;
import com.newer.purchase.pojo.EnquireDetail;

@Service("enquireServicec")
public class EnquireServicec {
	@Resource(name="enquireMapperc")
	private EnquireMapperc enquireMapper;
	
	/**
	 * 编制询价书
	 */
	
	public int add(Enquire enquire){
		
		try {
			String orderNum1 = "";
			long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmm").format(new Date()));
			String orderNum = enquireMapper.findMaxNum();
			
			String orderNum_ = "";
			String str="";
			if (orderNum != null) {
				if ("9999".equals(orderNum)) {
					orderNum = "U0000000000000001";
				}
				str = orderNum.substring(13, 17);				

			} else {
				str = "0001";
			}
			int num = Integer.parseInt(str) + 1;
			orderNum_ = Integer.toString(num);
			if (orderNum_.length() <= 5) {
				for (int i = 0; i <= 5 - orderNum_.length(); i++) {
					orderNum_ = "0" + orderNum_;
				}
			}

			orderNum1 = "U" + nowLong + orderNum_;
			enquire.setEnquireNum(orderNum1);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new NumberFormatException("数据类型转换错误!");
		}
		
		
		return enquireMapper.add(enquire);
		
	}
	
	/**
	 * 添加询价书明细
	 * @param enquireDetail
	 * @return
	 */
	public int add1(EnquireDetail enquireDetail){
		return enquireMapper.add1(enquireDetail);
	}
	
	
	/**
	 * 查询当前询价书最大的id
	 * @return
	 */
	public int findMaxID(){
		return enquireMapper.findMaxID();
	}
	
	
	  public Enquire findById(Integer id) {
		    return enquireMapper.findById(id);
		  }	
	  
	  
	  public int modify(Enquire enq) {
		    return enquireMapper.modify(enq);
		  }
}
