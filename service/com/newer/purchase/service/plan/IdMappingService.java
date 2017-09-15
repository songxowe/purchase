package com.newer.purchase.service.plan;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.newer.purchase.dao.plan.IdMappingMapper;
import com.newer.purchase.pojo.IdMapping;


/**
 * 编码对应表服务层
 * @author FUQIAN
 *
 */
@Service("idMappingServicef")
public class IdMappingService {
	
	@Resource(name="idMappingMapperf")
	private IdMappingMapper idMappingMapperf;

	/**
	 * 1.把需求计划序号等添加到编码对应表
	 * 采购状态码为C001-10需求计划未确认
	 * @param idMapping
	 * @return
	 */
	public int addOrderID(IdMapping idMapping){
		return idMappingMapperf.addOrderID(idMapping);
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
		IdMapping idMapping1=idMappingMapperf.findByOrderId(idMapping.getOrderId());
		if("C001-10".equals(idMapping1.getStatus())){
			count=idMappingMapperf.modifyByOrderID(idMapping);
		}
		return count;
	}
	
	/**
	 * 根据需求的序号，查询编码对应表的信息(状态码)
	 * @param orderID
	 * @return
	 */
	public IdMapping findByOrderId(Integer orderID){
		return idMappingMapperf.findByOrderId(orderID);
	}
	
	
	/**
	 * 合同申请计划员审批
	 * @param idMapping
	 * @return
	 */
	public int modifyByContAppID(IdMapping idMapping){
		return idMappingMapperf.modifyByContAppID(idMapping);
	}
	
	
	/**
	 * 4.修改状态,未报批改成未审批
	 * C001-30：采购计划未报批 -->C001-40：采购计划未审批
	 * @param stockID
	 * @return
	 */
	public int modify1(Integer stockID){
		return idMappingMapperf.modify1(stockID);
	}
	
	
	
	
	/**
	 * 6.修改状态,采购计划下达
	 * C001-50：采购计划未下达(采购计划已审批)-->C001-60：未编询价书(采购计划已下达)
	 * @param stockID
	 * @return
	 */
	public int modify2(Integer stockID){
		return idMappingMapperf.modify2(stockID);
	}
	
	
	
	/**
	 * 7.编制询价书
	 * 根据C001-60和采购计划序号
	 * 修改 status='C001-70' , enquire_id=#{enquireID}
	 * @param idMapping
	 * @return
	 */
	public int modifyEqnuireID(IdMapping idMapping){
		return idMappingMapperf.modifyEqnuireID(idMapping);
	}
	/**
	 * 编制合同申请并保存后，更新编号对照表中的合同申请序号和状态数据
	 * @param enquireID
	 * @param contAppID
	 * @return
	 */
	public int updateConAppId(Integer enquireID,Integer contAppID,Integer quoteID){
		return idMappingMapperf.updateConAppId(enquireID, contAppID, quoteID);
	}
	/**
	 * 确认合同申请
	 * @param id
	 * @return
	 */
	public int confirmContApp(@Param("contAppId") Integer contAppId){
		return idMappingMapperf.confirmContApp(contAppId);
	}
	
	
	/**
	 * 新增idmapping
	 */
	public int addIdMapping(Integer orderId){
		return idMappingMapperf.addIdMapping(orderId);
	}
	
	/***
	 * 需求确认，修改idmapping
	 */
	public int modifyIdMapping(Integer orderId){
		return idMappingMapperf.modifyIdMapping(orderId);
	}
	/**
	 *  获取最新插入的需求计划id，用于插入编号对照表
	 */
	public int getOrderId(){
		return idMappingMapperf.getOrderId();
	}
	
	public int modifyQuote(Integer enquireId){
		return idMappingMapperf.modifyQuote(enquireId);
	}
}
