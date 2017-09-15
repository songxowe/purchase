package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Contract;
import com.newer.purchase.pojo.ContractDetail;
import com.newer.purchase.pojo.dto.Contractfile;
import com.newer.purchase.pojo.dto.Preparecontract;

@Repository("quotesMapper")
public interface QuotesMapper {
	
	List<Preparecontract> findQuote(@Param(value="id")Integer id,@Param(value="quoteId")Integer quoteId);
	
	@Insert("insert into CONTRACT(ID,CONT_NUM,BUYER,SELLER ,SUPPLIER_NUM,CONT_DATE,CONT_TYPE,STOCK_TYPE,CONT_ITEM ,MONEY,TAX_RATE,WRAP_BACK,VERIFY_STAND,TRAN,PAY_COND,VERIFY_DATE,QUALITY_STAND,STANDARD_NO,PLACE,CONT_PRICE,TRANSPORT,PAY_WAY,OUT_PERM,OUT_DAY,WRAP_REQUIRE,REMARK) "
			+ "values(#{id},#{contNum},#{buyer},#{seller},#{suppliernum},#{contDate},#{contType},#{stockType},#{contItem},#{money},#{taxRate},#{wrapBack},#{verifyStand},#{tran},#{payCond},#{verifyDate},#{qualityStand},#{standardNo,jdbcType=VARCHAR},#{place},#{contPrice},#{transport},#{payWay},#{outPerm},#{outDay},#{wrapRequire},#{remark,jdbcType=VARCHAR})")
	@SelectKey(statement="select SEQ_CONTRACT.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int addContract(Contract contract);
	
	@Insert("insert into CONTRACT_DETAIL(ID,CONT_ID,MATERIAL_CODE,MATERIAL_NAME,AMOUNT,UNIT_PRICE,MEASURE_UNIT,SUM_PRICE,MIX_PRICE,OTHER_PRICE,TOTAL_PRICE,END_DATE,ADDRESS,TRANS,WRAP_REQUIRE,FACTORY,OTHER_REQUIRE ) "
			+ "values(#{id},#{contId},#{materialCode,jdbcType=VARCHAR},#{materialName,jdbcType=VARCHAR},#{amount,jdbcType=INTEGER},#{unitPrice,jdbcType=DOUBLE},#{measureUnit,jdbcType=VARCHAR},#{sumPrice,jdbcType=DOUBLE},#{mixPrice,jdbcType=DOUBLE},#{otherPrice,jdbcType=DOUBLE},#{totalPrice,jdbcType=DOUBLE},#{endDate,jdbcType=DATE},#{address,jdbcType=VARCHAR},#{trans,jdbcType=VARCHAR},#{wrapRequire,jdbcType=VARCHAR},#{factory,jdbcType=VARCHAR},#{otherRequire,jdbcType=VARCHAR})")
	@SelectKey(statement="select SEQ_CONTRACT_DETAIL.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int addContractDetail(ContractDetail contractDetail);
	
	
	@Select("select id from (select id from contract order by id desc) where rownum=1")
	int findContractId();
	//合同已签订状态码修改
	@Update("update ID_MAPPING set STATUS='C001-150' where CONT_ID=#{contid}")
	int modify(Integer contId);
	
	//合同已签订将已签订的报价书id更新至编号对照表
	@Update("update ID_MAPPING set QUOTE_ID=#{qid} where ENQUIRE_ID=#{eid}")
	int modifyQid( @Param("qid")Integer qid, @Param("eid")Integer eid);
	
	//修改编号对照表合同id
	@Update("update ID_MAPPING set CONT_ID=#{contid} where ENQUIRE_ID=#{eid}")
	int modifyContId(@Param("contid")Integer contid,@Param("eid")Integer eid);
	
	
	List<Contractfile> findPager(
		      @Param("pageno")Integer pageno,
		      @Param("pagesize")Integer pagesize,
		      @Param("sort")String sort,
		      @Param("order")String order,
		      @Param("contNum") String contNum);
	
	long findTotal(@Param("contNum") String contNum);
	//合同归档状态码修改
	@Update("update ID_MAPPING set STATUS='C001-160' where cont_ID=#{id}")
	int modifyId(Integer id);
}
