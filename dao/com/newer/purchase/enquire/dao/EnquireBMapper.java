package com.newer.purchase.enquire.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.newer.purchase.enquire.pojo.EnquireB;


/**
 * 与询价书对应的需求计划信息
 * @author Administrator
 *
 */
@Repository("enquireBMapper")
public interface EnquireBMapper {
	/**
	 * 根据id 来查询对应的需求计划信息
	 * @param id
	 * @return
	 */
	List<EnquireB> queryAll(Integer id);
}
