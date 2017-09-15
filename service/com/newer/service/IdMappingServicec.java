package com.newer.service;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.newer.dao.IdMappingMapperc;
import com.newer.enquire.pojo.IdMapping;


/**
 * 编码对应表服务层
 * @author FUQIAN
 *
 */
@Service("idMappingServicec")
public class IdMappingServicec {
	
	@Resource(name="idMappingMapperc")
	private IdMappingMapperc idMappingMapperc;

	/**
	 * 1.把需求计划序号等添加到编码对应表
	 * 采购状态码为C001-10需求计划未确认
	 * @param idMapping
	 * @return
	 */
	public int addOrderID(IdMapping idMapping){
		return idMappingMapperc.addOrderID(idMapping);
	}
	
	/**
	 * 2.需求计划确认
	 * 根据当前的需求计划序号id，修改编码对应表中采购状态码,由C001-10改为C001-20
	 * C001-20;未编采购计划(需求计划已确认)
	 * @param idMapping
	 * @return
	 */
	public int modifyByOrderID(IdMapping idMapping){
		int count=0;
		IdMapping idMapping1=idMappingMapperc.findByOrderId(idMapping.getOrderID());
		if("C001-10".equals(idMapping1.getStatus())){
			count=idMappingMapperc.modifyByOrderID(idMapping);
		}
		return count;
	}
	
	/**
	 * 根据需求的序号，查询编码对应表的信息(状态码)
	 * @param orderID
	 * @return
	 */
	public IdMapping findByOrderId(Integer orderID){
		return idMappingMapperc.findByOrderId(orderID);
	}
	
	
	/**
	 * 合同申请计划员审批
	 * @param idMapping
	 * @return
	 */
	public int modifyByContAppID(IdMapping idMapping){
		return idMappingMapperc.modifyByContAppID(idMapping);
	}
	
	
	/**
	 * 4.修改状态,未报批改成未审批
	 * C001-30：采购计划未报批 -->C001-40：采购计划未审批
	 * @param stockID
	 * @return
	 */
	public int modify1(Integer stockID){
		return idMappingMapperc.modify1(stockID);
	}
	
	
	
	
	/**
	 * 6.修改状态,采购计划下达
	 * C001-50：采购计划未下达(采购计划已审批)-->C001-60：未编询价书(采购计划已下达)
	 * @param stockID
	 * @return
	 */
	public int modify2(Integer stockID){
		return idMappingMapperc.modify2(stockID);
	}
	
	
	
	/**
	 * 7.编制询价书
	 * 根据C001-60和采购计划序号
	 * 修改 status='C001-70' , enquire_id=#{enquireID}
	 * @param idMapping
	 * @return
	 */
	public int modifyEqnuireID(IdMapping idMapping){
		return idMappingMapperc.modifyEqnuireID(idMapping);
	}
	/**
	 * 编制合同申请并保存后，更新编号对照表中的合同申请序号和状态数据
	 * @param enquireID
	 * @param contAppID
	 * @return
	 */
	public int updateConAppId(Integer enquireID,Integer contAppID,Integer quoteID){
		return idMappingMapperc.updateConAppId(enquireID, contAppID, quoteID);
	}
	/**
	 * 确认合同申请
	 * @param id
	 * @return
	 */
	public int confirmContApp(@Param("contAppId") Integer contAppId){
		return idMappingMapperc.confirmContApp(contAppId);
	}
}