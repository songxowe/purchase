package com.newer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.enquire.pojo.Enquire;
import com.newer.enquire.pojo.EnquireDetail;

/**
 * 询价书   业务逻辑类
 * @author Jeana Yi
 * 2016年10月26日
 */
@Repository("enquireMapperf")
public interface EnquireMapperF {
	/**
	 * 根据询价书序号查询询价书内容
	 * @param id
	 * @return
	 */
	@Select("Select ID,ENQUIRE_NUM enquireNum,ENQUIRE_NAME enquireName,COMPANY,LINKMAN,"
			+ "ADDRESS,PHONE,FAX,ZIP,EMAIL,END_DATE endDate from ENQUIRE where ID=#{id}")
	Enquire findById(Integer id);

	@Insert("insert into ENQUIRE(ID,ENQUIRE_NUM,ENQUIRE_NAME,COMPANY,LINKMAN,ADDRESS,PHONE,FAX,ZIP,EMAIL,END_DATE,REMARK,BUILD_DATE) values(#{id},#{enquireNum},#{enquireName},#{company},#{linkman},#{address},#{phone},#{fax},#{zip},#{email},#{endDate},#{remark},#{buildDate})")
	@SelectKey(statement="select SEQ_ENQUIRE.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int add(Enquire enquire);
	
	
	
	@Select("select max(ENQUIRE_NUM) from ENQUIRE")
	String findMaxNum();
	
	
	@Insert("insert into ENQUIRE_DETAIL(ID,ENQUIRE_ID,ORDER_ID,MATERIAL_CODE,MATERIAL_NAME,AMOUNT,MEASURE_UNIT,START_DATE,END_DATE,STANDARD,FACTORY,PROD_YEAR,WRAP,REMARK) "
	+"values(#{id},#{enquireId},#{orderId},#{materialCode},#{materialName},#{amount},#{measureUnit},#{startDate},#{endDate},#{standard},#{factory},#{prodYear},#{wrap},#{remark})")
	@SelectKey(statement="select SEQ_ENQUIRE_DETAIL.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int add1(EnquireDetail enquireDetail);
	
	
	@Select("select max(id) from ENQUIRE")
	int findMaxID();
	
	
	 
	 @Update("update ENQUIRE set ENQUIRE_NUM=#{enquire_num},ENQUIRE_NAME=#{enquire_name},COMPANY=#{company},LINKMAN=#{linkman},ADDRESS=#{address},PHONE=#{phone},FAX=#{fax},ZIP=#{zip},EMAIL=#{email},END_DATE=#{end_date},REMARK=#{remark} where ID=#{id}")
	  int modify(Enquire enq);
	  
}
