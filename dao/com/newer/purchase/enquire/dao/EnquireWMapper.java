package com.newer.purchase.enquire.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Enquire;


/**
 * 询价书列表：获取询价书
 * @author Administrator
 *
 */
@Repository("enquireWMapper")
public interface EnquireWMapper {
	 /**
     * 根据id获取询价书的所有信息
     * @param id
     * @return
     */
	@Select("select id,enquire_num enquireNum,enquire_name enquireName,company,linkman,address,phone,fax,zip,email,end_date endDate,remark from enquire where id=#{id}")
	Enquire findById(Integer id);
}
