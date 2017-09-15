package com.newer.purchase.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Enquire;
import com.newer.purchase.pojo.EnquireDetail;

/**
 * 询价书   业务逻辑类
 * @author Administrator
 *
 */
@Repository("enquireMapperc")
public interface EnquireMapperc {
	
	@Select("Select ID,ENQUIRE_NUM enquireNum,ENQUIRE_NAME enquireName,COMPANY,LINKMAN,"
			+ "ADDRESS,PHONE,FAX,ZIP,EMAIL,END_DATE endDate from ENQUIRE where ID=#{id}")
	Enquire findById(Integer id);
	
	@Insert("insert into ENQUIRE(ID,ENQUIRE_NUM,ENQUIRE_NAME,COMPANY,LINKMAN,ADDRESS,PHONE,FAX,ZIP,EMAIL,BUILD_DATE,END_DATE,REMARK) values(#{id},#{enquireNum},#{enquireName},#{company},#{linkman},#{address},#{phone},#{fax},#{zip},#{email},#{bulidDate},#{endDate},#{remark})")
	@SelectKey(statement="select SEQ_ENQUIRE.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int add(Enquire enquire);

	@Select("select max(ENQUIRE_NUM) from ENQUIRE")
	String findMaxNum();
	
	@Insert("insert into ENQUIRE_DETAIL(ID,ENQUIRE_ID,ORDER_ID,MATERIAL_CODE,MATERIAL_NAME,AMOUNT,MEASURE_UNIT,START_DATE,END_DATE,STANDARD,FACTORY,PROD_YEAR,WRAP,REMARK) "
	+"values(#{id},#{enquireId},#{orderId},#{materialCode},#{materialName},#{amount},#{measureUnit},#{startDate},#{endDate},#{standard},#{factory},#{prodYear},#{wrap},#{remark})")
	@SelectKey(statement="select SEQ_ENQ_DETAIL.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int add1(EnquireDetail enquireDetail);
	
	@Select("select max(id) from ENQUIRE")
	int findMaxID();
	
	@Update("update ENQUIRE set ENQUIRE_NUM=#{enquire_num},ENQUIRE_NAME=#{enquire_name},COMPANY=#{company},LINKMAN=#{linkman},ADDRESS=#{address},PHONE=#{phone},FAX=#{fax},ZIP=#{zip},EMAIL=#{email},END_DATE=#{end_date},REMARK=#{remark} where ID=#{id}")
	int modify(Enquire enq);
	  
}
