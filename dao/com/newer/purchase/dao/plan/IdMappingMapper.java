package com.newer.purchase.dao.plan;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.IdMapping;


@Repository("idMappingMapperf")
public interface IdMappingMapper {
	
	/**
	 * 新增编号对照表记录
	 * @param idMapping
	 * @return
	 */
	@Insert("insert into ID_MAPPING(ID,ORDER_ID,STATUS) values(seq_id_mapping.nextval,#{orderId},#{status})")
	int addOrderID(IdMapping idMapping);
	

	/**
	 * 2.需求计划确认
	 * 根据当前的需求计划序号id，修改编码对应表中采购状态码,由C001-10改为C001-20
	 * C001-20;未编采购计划(需求计划已确认)
	 * @param idMapping
	 * @return
	 */
	@Update("Update ID_MAPPING set ORDER_ID=#{orderId,jdbcType=INTEGER},STOCK_ID=#{stockId,jdbcType=INTEGER},"
			+ "ENQUIRE_ID=#{enquireId,jdbcType=INTEGER},CONT_APP_ID=#{contAppId,jdbcType=INTEGER},"
			+ "QUOTE_ID=#{quoteId,jdbcType=INTEGER},CONT_ID=#{contId,jdbcType=INTEGER},"
			+ "STATUS=#{status,jdbcType=VARCHAR} where ID=#{id}")
	int modifyByOrderID(IdMapping idMapping);
	
	
	/**
	 * 3.需求计划编制为采购计划
	 * 根据当前的需求计划序号id和状态为C001-20，修改状态为C001-30
	 * 同时，修改编码对应表的采购id为当前采购计划生成的序号
	 * @param idMapping
	 * @return
	 */
	@Update("update ID_Mapping set STATUS=#{status},STOCK_ID=#{stockID} where ORDER_ID=#{orderID} and STATUS='C001-20' ")
	int modifyByStockID(IdMapping idMapping);
	
	
	
	/**
	 * 4.修改状态,未报批改成未审批
	 * C001-30：采购计划未报批 -->C001-40：采购计划未审批
	 * @param stockID
	 * @return
	 */
	@Update("update ID_MAPPING set status='C001-40' where STOCK_ID=#{stockID} and status='C001-30'")
	int modify1(Integer stockID);
	
	
	
	/**
	 * 6.修改状态,采购计划下达
	 * C001-50：采购计划未下达(采购计划已审批)-->C001-60：未编询价书(采购计划已下达)
	 * @param stockID
	 * @return
	 */
	@Update("update ID_MAPPING set status='C001-60' where STOCK_ID=#{stockID} and status='C001-50'")
	int modify2(Integer stockID);
	
	
	/**
	 * 7.编制询价书
	 * 根据C001-60和采购计划序号
	 * 修改 status='C001-70' , enquire_id=#{enquireID}
	 * @param idMapping
	 * @return
	 */
	@Update("update ID_MAPPING set status='C001-90',ENQUIRE_ID=#{enquireID} where STOCK_ID=#{stockID} and status='C001-60'")
	int modifyEqnuireID(IdMapping idMapping);
	
	
	
	/**
	 * 根据需求的序号，查询编码对应表的信息(状态码)
	 * @param orderID
	 * @return
	 */
	@Select("select Id as id,ORDER_ID as orderID,STOCK_ID as stockID,ENQUIRE_ID as enquireID,CONT_APP_ID as contAppID,QUOTE_ID as quoteID,CONT_ID as contID,STATUS as status from ID_MAPPING where ORDER_ID=#{orderID}")
	IdMapping findByOrderId(Integer orderID);
	
	@Delete("delete from ID_Mapping where ORDER_ID=#{orderID} and STATUS=#{status}")
	int remove(IdMapping idMapping);
	
	
	/**
	 * 合同申请计划员审批
	 * @param idMapping
	 * @return
	 */
	@Update("update ID_Mapping set STATUS='C001-130'  where CONT_APP_ID=#{contAppID} and STATUS='C001-120'")
	int modifyByContAppID(IdMapping idMapping);

	/**
	 * 编制合同申请并保存后，更新编号对照表中的合同申请序号和状态数据
	 * @param enquireID
	 * @param contAppID
	 * @return
	 */
	@Update("Update ID_MAPPING set CONT_APP_ID=#{contAppID},STATUS='C001-110', QUOTE_ID=#{quoteID} where STATUS='C001-90' and ENQUIRE_ID=#{enquireID}")
	int updateConAppId(@Param("enquireID")Integer enquireID,@Param("contAppID")Integer contAppID,@Param("quoteID")Integer quoteID); 
	/**
	 * 确认合同申请
	 * @return
	 */
	@Update("Update ID_MAPPING set STATUS='C001-120' where STATUS='C001-110' and CONT_APP_ID=#{contAppId}")
	int confirmContApp(@Param("contAppId")Integer contAppId);
	
	
	/**
	 *  获取最新插入的需求计划id，用于插入编号对照表
	 */
	@Select("select id from(select*from orders order by id desc) where rownum=1")
	public int getOrderId();
	
	
	/**
	 * 新增idmapping
	 */
	@Insert("insert into id_mapping(id,order_id,status) values(seq_id_mapping.nextval,#{orderId},'C001-10')")
	public int addIdMapping(@Param(value="orderId")Integer orderId);
	
	/***
	 * 需求确认，修改idmapping
	 */
	@Update("update id_mapping set status='C001-20' where order_Id=#{orderId}")
	public int modifyIdMapping(@Param(value="orderId")Integer orderId);
	
	@Update("update id_mapping set status='C001-100' where enquire_id=#{enquireId}")
	public int modifyQuote(Integer enquireId);
    
}
