package com.newer.purchase.enquire.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.purchase.enquire.pojo.Stenqi;


@Repository("stenqiMapper")
public interface StenqiMapper {
	List<Stenqi> findPager(
		@Param("pageno") Integer pageno, 
		@Param("pagesize") Integer pagesize, 
		@Param("sort") String sort,
		@Param("order") String order, 
		@Param("sename") String sename,
		@Param("stype") String stype);
		
	long findPagerTotal(@Param("sename") String sename,@Param("stype") String status);

}
