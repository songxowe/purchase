package com.newer.purchase.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.StockPanner;


@Repository("stockPannerMapper")
public interface StockPannerMapper {
	
	
	List<StockPanner> findPager(
			  @Param("pageno") Integer pageno, 
		      @Param("pagesize") Integer pagesize, 
		      @Param("sort") String sort,
		      @Param("order") String order,
		      @Param("endDate") Date endDate, 
		      @Param("stockName") String stockName
		      
		      );
	
	long findPagerTotal(@Param("endDate") Date endDate, @Param("stockName") String stockName);
	/**
	 * 修改编号对照表的采购状态（同意或者不同意）
	 * @param id
	 * @return
	 */
	@Update("update Stock set LEADER_ID=#{leaderId,jdbcType=VARCHAR},SUBMIT_DATE=#{submitDate,jdbcType=VARCHAR},LEADER=#{leader,jdbcType=VARCHAR},LEAD_AGREE=#{leadAgree,jdbcType=VARCHAR},LEAD_OPINION=#{leadOpinion,jdbcType=VARCHAR},LEAD_DATE=#{leadDate,jdbcType=DATE} where ID=#{id}")
	int modifyStock(Stock stock);
	
	/**
	 * 修改编号对照表的采购状态（同意或者不同意）
	 * @param id
	 * @return
	 */
	@Update("update ID_MAPPING set status=#{status} where id=#{id}")
	int modifyStatus(@Param("status") String status,@Param("id") Integer id);
	
	@Select("select ID,STOCK_NUM,STOCK_NAME,BUILD_DATE,AUTHOR_ID,AUTHOR,STOCK_TYPE,BUDGET,START_DATE,END_DATE,SUBMIT_DATE,REMARK,LEADER_ID,LEADER,LEAD_AGREE,LEAD_OPINION,LEAD_DATE from Stock  where ID=#{id}")
	Stock findById(Integer id);
	
}
