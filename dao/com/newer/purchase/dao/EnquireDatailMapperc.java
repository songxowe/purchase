package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.EnquireDetail;


/**
 * 询价细明表
 * @author Administrator
 *
 */

@Repository("enquireDatailMapperc")
public interface EnquireDatailMapperc {
	/**
	 * 根据询价书id查询询价书明细
	 * @param enquireId
	 * @return
	 */
	@Select("Select MATERIAL_CODE materialCode,MATERIAL_NAME materialName,AMOUNT,"
			+ "MEASURE_UNIT measureUnit,START_DATE startDate,END_DATE endDate,STANDARD,FACTORY,"
			+ "PROD_YEAR prodYear,WRAP	,REMARK  from ENQUIRE_DETAIL where enquire_ID=#{enquireId}")
	
	List<EnquireDetail> findEnquireDetailByEnquireId(Integer enquireId);
	
}
