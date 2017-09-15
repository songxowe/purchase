package com.newer.purchase.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.IdMapping;
@Repository("idMappingMapper")
public interface IdMappingMapper {
	@Update("update ID_MAPPING set STATUS=#{status} where STOCK_ID=#{stockId}")
	int modifyIdMapping(@Param("status") String status,@Param("stockId") Integer stockId);
	
	@Delete("delete from ID_MAPPING where ID=#{id}")
	int remove(Integer id);
	
	//添加编号对照表数据
		@Insert("insert into ID_MAPPING(ID,ORDER_ID,STOCK_ID,ENQUIRE_ID,CONT_APP_ID,QUOTE_ID,CONT_ID,STATUS) values(#{id},#{orderId,jdbcType=INTEGER},#{stockId,jdbcType=INTEGER},#{enquireId,jdbcType=INTEGER},#{contAppId,jdbcType=INTEGER},#{quoteId,jdbcType=INTEGER},#{contId,jdbcType=INTEGER},#{status,jdbcType=VARCHAR})")
		@SelectKey(statement="select seq_id_mapping.nextval from dual",keyProperty="id",resultType=int.class,before=true)
		int add(IdMapping idMapping);
		
		
		//修改编号对照表
		@Update("Update ID_MAPPING set ORDER_ID=#{orderId,jdbcType=INTEGER},STOCK_ID=#{stockId,jdbcType=INTEGER},"
				+ "ENQUIRE_ID=#{enquireId,jdbcType=INTEGER},CONT_APP_ID=#{contAppId,jdbcType=INTEGER},"
				+ "QUOTE_ID=#{quoteId,jdbcType=INTEGER},CONT_ID=#{contId,jdbcType=INTEGER},"
				+ "STATUS=#{status,jdbcType=VARCHAR} where ID=#{id}")
		int modify(IdMapping idMapping);

}
