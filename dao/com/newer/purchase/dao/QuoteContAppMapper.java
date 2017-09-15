package com.newer.purchase.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.ContAppList;
import com.newer.purchase.pojo.Employee;
import com.newer.purchase.pojo.Enquire;
import com.newer.purchase.pojo.EnquireList;
import com.newer.purchase.pojo.IdMapping;
import com.newer.purchase.pojo.QuoteDetail;
@Repository("quoteContAppMapper")
public interface QuoteContAppMapper {
	
	/**
	 *	查所有已揭示报价的询价书列表+分页
	 */
	public List<EnquireList> findEnquirePager(
			@Param("beginPage")Integer beginPage,
			@Param("endPage")Integer endPage,
			@Param("order")String order,
			@Param("sort")String sort,
			@Param("enquireName")String enquireName,
			@Param("beginDate")Date beginDate,
			@Param("endDate")Date endDate
			);
	/**
	 * 查总记录数
	 */
	public int findTotal(
			@Param("enquireName")String enquireName,
			@Param("beginDate")Date beginDate,
			@Param("endDate")Date endDate
			);
	
	/**
	 * 询价书明细+所有对应报价书
	 */
	public Enquire findEnquireById(int id);
	
	/**
	 * 查询报价明细
	 */
	public QuoteDetail findQuoteDetail(int qid);
	
	
	/**
	 * 新增合同申请
	 */
	@Insert("insert into contract_apply(id,cont_app_num,stat_quote,top_quote,low_quote,all_sum_price,remark,author_id,author)"+
	 " values(seq_contract_apply.nextval,#{contAppNum},#{statQuote},#{minPrice},#{maxPrice},#{sumPrice},#{remark,jdbcType=VARCHAR},#{authorId},#{author})")
	public int addContractApply(
			@Param("contAppNum")String contAppNum,
			@Param("statQuote")int statQuote,
			@Param("minPrice")double minPrice,
			@Param("maxPrice")double maxPrice,
			@Param("sumPrice")double sumPrice,
			@Param("remark")String remark,
			@Param("authorId")int authorId,
			@Param("author")String author);
	
	/**
	 * 按用户ID查询员工信息
	 */
	@Select("select id,emp_num empNum,emp_name empName,sex,phone,fax,email,zip,address from employee where user_id=#{uid}")
	public Employee findEmpByUserId(int uid);
	
	/**
	 * 按询价表ID查询编号对照表
	 */
	@Select("select id,order_id orderId,stock_id stockId,enquire_id enquireId from id_mapping where enquire_id=#{eid}")
	public IdMapping findIdMapping(int eid);
		
	/**
	 * 查最新插入的申请表ID
	 */
	@Select("select id from (select id from contract_apply order by id desc) where rownum=1")
	public int findContAppId();
		
	/**
	 * 按ID更改编号对照表状态
	 */
	@Update("update id_mapping set status=#{status} where id=#{mappingId}")
	public int modifyIdMappingStatus(@Param("mappingId")int mappingId,@Param("status")String status);
	
	/**
	 * 将申请表id更新进编号对照表
	 */
	@Update("update id_mapping set cont_app_id=#{contAppId} where id=#{id}")
	public int modifyIdMappingContApp(@Param("contAppId")int contAppId,@Param("id")int id);
	
	/**
	 * 按申请表id查询价书id
	 */
	@Select("select enquire_id from id_mapping where cont_app_id=#{contAppId}")
	public int findEnquireByContAppId (Integer contAppId);
	
	/**
	 * 合同申请分页
	 */
	public List<ContAppList> findContAppPager(
			@Param("beginPage")Integer beginPage,
			@Param("endPage")Integer endPage,
			@Param("order")String order,
			@Param("sort")String sort,
			@Param("contAppNum")String contAppNum);
	
	/**
	 * 合同申请总数
	 */
	public int findContAppTotal(@Param("contAppNum")String contAppNum);
	
}
