package com.newer.purchase.enquire.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.purchase.enquire.pojo.EnquireX;

@Repository("enquireXMapper")
public interface EnquireXMapper {
	/**
     * 分页数据：
     * @param pageno
     * @param pagesize
     * @param sort
     * @param order
     * @param status
     * @param enquireName
     * @return
     */
	List<EnquireX> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
		      @Param("order") String order,@Param("status")String status,@Param("enquireName")String enquireName);
	/**
	 * 查询记录总数
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param status
	 * @param enquireName
	 * @return
	 */
	long findPagerTotal(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize, @Param("sort") String sort,
		      @Param("order") String order,@Param("status")String status,@Param("enquireName")String enquireName);
	
}
