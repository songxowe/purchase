package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.ContractApply;
import com.newer.purchase.pojo.ContractApplyPanner;

@Repository("contractApplyMapper")
public interface ContractApplyMapper {
	
	/**
	 * 合同申请财务部长
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param contAppNum
	 * @param id
	 * @return
	 */
	
	List<ContractApplyPanner> findPagerPlaner(
			 @Param("pageno") Integer pageno, 
		      @Param("pagesize") Integer pagesize, 
		      @Param("sort") String sort,
		      @Param("order") String order, 
		      @Param("contAppNum") String contAppNum
			);
	long findPagerTotalPlaner(@Param("contAppNum") String contAppNum);
	
	
	/**
	 * 财务部长合同审批
	 * @param contractApply
	 * @return
	 */
	@Update("update CONTRACT_APPLY set PLANER_ID=#{planerId,jdbcType=VARCHAR},PLANER=#{planer,jdbcType=VARCHAR},PLAN_AGREE=#{planAgree,jdbcType=VARCHAR},PLAN_OPINION=#{planOpinion,jdbcType=VARCHAR},PLAN_DATE=#{planDate,jdbcType=DATE} where ID=#{id} ")
	int modifyPlaner(ContractApply contractApply);
	
	/**
	 * 修改编号对照表的财务部审批状态（同意或者不同意）
	 * @param id
	 * @return
	 */
	
	@Update("update ID_MAPPING set status=#{status} where id=#{id}")
	int modifyPlanerStatus(@Param("status") String status,@Param("id") Integer id);
	
	/**
	 * 合同申请厂长
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param contAppNum
	 * @param id
	 * @return
	 */
	List<ContractApplyPanner> findPagerLeader(
			 @Param("pageno") Integer pageno, 
		      @Param("pagesize") Integer pagesize, 
		      @Param("sort") String sort,
		      @Param("order") String order, 
		      @Param("contAppNum") String contAppNum
			);
	long findPagerTotalLeader(@Param("contAppNum") String contAppNum);
	
	/**
	 * 厂长合同审批
	 * @param contractApply
	 * @return
	 */
	@Update("update CONTRACT_APPLY set LEADER_ID=#{leaderId},LEADER=#{leader,jdbcType=VARCHAR},LEAD_AGREE=#{leadAgree,jdbcType=VARCHAR},LEAD_OPINION=#{leadOpinion,jdbcType=VARCHAR},LEAD_DATE=#{leadDate} where ID=#{id}")
	int modifyLeader(ContractApply contractApply);
	
	/**
	 * 修改编号对照表的厂长批状态（同意或者不同意）
	 * @param id
	 * @return
	 */
	
	@Update("update ID_MAPPING set status=#{status} where id=#{id}")
	int modifyLeaderStatus(@Param("status") String status,@Param("id") Integer id);
	
	@Select("select ID,CONT_APP_NUM,STAT_QUOTE,TOP_QUOTE,LOW_QUOTE,ALL_SUM_PRICE,REMARK,AUTHOR_ID,AUTHOR,PLANER_ID,PLANER,PLAN_AGREE,PLAN_OPINION,PLAN_DATE,LEADER_ID,LEADER,LEAD_AGREE,LEAD_OPINION,LEAD_DATE from CONTRACT_APPLY  where ID=#{id}")
	ContractApply findByIdCa(Integer id);
	
	@Select("select ca.id as id,ca.CONT_APP_NUM contAppNum,ca.STAT_QUOTE statQuote,ca.TOP_QUOTE topQuote,ca.LOW_QUOTE lowQuote,ca.ALL_SUM_PRICE allSumPrice,"
	+"ca.REMARK remark,ca.AUTHOR_ID authorId,ca.AUTHOR author,ca.PLANER_ID planerId,ca.PLANER planer,ca.PLAN_AGREE  planAgree,ca.PLAN_OPINION planOpinion,"
	+"ca.PLAN_DATE planDate,ca.LEADER_ID leaderId,ca.LEADER leader,ca.LEAD_AGREE leadAgree,ca.LEAD_OPINION leadOpinion,ca.LEAD_DATE leadDate,"
	+"i.id inmappingId,i.status status,c.supplier_num supplierNum,cd.MATERIAL_CODE materialCode,cd.MATERIAL_NAME materialName,cd.AMOUNT amount,"
	+"cd.UNIT_PRICE unitPrice,cd.MEASURE_UNIT measureUnit,cd.SUM_PRICE sumPrice,cd.MIX_PRICE mixPrice,cd.OTHER_PRICE otherPrice,cd.TOTAL_PRICE totalPrice,"
	+"cd.END_DATE endDate,cd.ADDRESS address,cd.FACTORY factory,s.STOCK_NAME stockname,s.START_DATE startDate "
	+"from ID_MAPPING i LEFT OUTER JOIN CONTRACT c on i.cont_id=c.id LEFT OUTER JOIN CONTRACT_APPLY ca on i.cont_app_id=ca.id " 
	+"LEFT OUTER JOIN CONTRACT_DETAIL cd on i.cont_id=cd.id  LEFT OUTER JOIN stock s on i.stock_id=s.id where ca.ID=#{id}")
	ContractApplyPanner findByIdCaP(Integer id);
}
