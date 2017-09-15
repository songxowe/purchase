package com.newer.purchase.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Enquire;
import com.newer.purchase.pojo.EnquireDetail;
import com.newer.purchase.pojo.Quote;
import com.newer.purchase.pojo.QuoteDetail;
import com.newer.purchase.pojo.dto.PoEnquire;
import com.newer.purchase.pojo.dto.PoQuote;

@Repository("quoteMapper")
public interface QuoteMapper {

	//查询询价书
	List<PoEnquire> findEnquire(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
		      @Param("order") String order,@Param("enquireName") String enquireName,@Param("beginDate") Date beginDate,
		      @Param("endDate") Date endDate,@Param("stockType") String stocktype,@Param("userId") Integer userId);
	
	int findEnquireTotal(@Param("enquireName") String enquireName,@Param("beginDate") Date beginDate,@Param("userId") Integer userId,
		      @Param("endDate") Date endDate,@Param("stockType") String stockType);
	
	Enquire findById(Integer id);
	
	//查询询价明细表(单个关联查询 询价表-询价明细表-需求表)
	EnquireDetail findByEnquire(Integer enquireId);
	
	//报价(insert 同时改变 关系对照表相应字段)
	@Insert("insert into QUOTE(ID,QUOTE_NUM,ENQUIRE_ID,SUPPLIER_ID,QUO_COMPANY,QUO_ADDRESS,QUO_LINKMAN,"
			+ "QUO_PHONE,QUO_FAX,QUO_EMAIL,QUE_TITLE,QUE_DATE,END_DATE,SUM_AMOUNT,OVERALL_PRICE,QUO_REMARK,"
			+ "STATUS) values(#{id},#{quoteNum},#{enquireId},#{supplier.id},#{quoCompany},#{quoAddress},"
			+ "#{quoLinkman},#{quoPhone},#{quoFax},#{quoEmail},#{queTitle},#{queDate,jdbcType=DATE},"
			+ "#{endDate,jdbcType=DATE},#{sumAmount},#{overallPrice},#{quoRemark,jdbcType=VARCHAR},#{status})")
	@SelectKey(statement="select SEQ_QUOTE.nextval from dual", before = true, keyProperty = "id", resultType = int.class)
	int addQuote(Quote quote);
	
	@Insert("insert into QUOTE_DETAIL(ID,QUOTE_ID,ORDER_ID,MATERIAL_CODE,MATERIAL_NAME,MEASURE_UNIT,STANDARD,FACTORY,"
			+ "PROD_YEAR,WRAP,AMOUNT,UNIT_PRICE,SUM_PRICE,MIX_PRICE,OTHER_PRICE,TOTAL_PRICE,START_DATE,END_DATE) values"
			+ "(#{id},#{quoteId},#{orderId},#{materialCode},#{materialName},#{measureUnit},#{standard,jdbcType=VARCHAR},#{factory,jdbcType=VARCHAR},"
			+ "#{prodYear,jdbcType=VARCHAR},#{wrap,jdbcType=VARCHAR},#{amount},#{unitPrice},#{sumPrice},#{mixPrice},#{otherPrice},"
			+ "#{totalPrice},#{startDate,jdbcType=DATE},#{endDate,jdbcType=DATE})")
	@SelectKey(statement="select SEQ_QUOTE_DETAIL.nextval from dual",before=true,keyProperty="id",resultType=int.class)
	int addQuoteDetail(QuoteDetail quoteDetail);
	
	//查询报价书(对报价表分页查询)
	List<PoQuote> findQuote(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
		      @Param("order") String order,@Param("queTitle") String queTitle,@Param("beginDate") Date beginDate,
		      @Param("endDate") Date endDate,@Param("supplierId") Integer supplierId,@Param("userId") Integer userId);
	
	int findQuoteTotal(@Param("queTitle") String queTitle,@Param("beginDate") Date beginDate,@Param("userId") Integer userId,
		      @Param("endDate") Date endDate,@Param("supplierId") Integer supplierId);
	
	//查询报价明细表(关联单个查询 报价-报价明细-需求表)
	QuoteDetail findByQuote(Integer quoteId);
	
	//报价维护(update)
	@Update("update QUOTE set QUOTE_NUM=#{quoteNum},ENQUIRE_ID=#{enquireId},QUO_COMANY=#{quoCompany},QUO_ADDRESS=#{quoAddress},"
			+ "QUO_LINKMAN=#{quoLinkman},QUO_PHONE=#{quoPhone},QUO_FAX=#{quoFax},QUO_EMAIL=#{quoEmail},QUO_TITLE=#{quoTitle},"
			+ "QUO_DATE=#{quoDate},END_DATE=#{endDate},SUM_AMOUNT=#{sumAmount},OVERALL_PRICE=#{overallPrice},QUO_REMARK=#{quoRemark},"
			+ "STATUS=#{status},SUPPLIER_ID=#{supplierId} where ID=#{id}")
	int modifyQuote(Quote quote);
	
	@Update("update QUOTE_DETAIL set QUOTE_ID=#{quoteId},MATERIAL_CODE=#{materialCode},MATERIAL_NAME=#{materialName},"
			+ "MEASURE_UNIT=#{measureUnit},STANDARD=#{standard},FACTORY=#{factory},PROD_YEAR=#{prodYear},WRAP=#{wrap},AMOUNT=#{amount},"
			+ "UNIT_PRICE=#{unitPrice},SUM_PRICE=#{sumPrice},MIX_PRICE=#{mixPrice},OTHER_PRICE=#{otherPrice},TOTAL_PRICE=#{totalPrice},"
			+ "START_DATE=#{startDate},END_DATE=#{endDate} where ID=#{id}")
	int modifyQuoteDetail(QuoteDetail quoteDetail);
	
	@Update("update ID_MAPPING set STATUS='C001-90' where ENQUIRE_ID=#{enquireId}")
	int modifyStatus(Integer enquireId);
	
	@Select("select id from (select * from quote order by id desc) where rownum=1")
	int getQuoteId();
}
