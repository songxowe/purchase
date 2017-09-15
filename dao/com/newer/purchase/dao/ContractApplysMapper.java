package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.dto.ContractApplys;



@Repository("contractApplysMapper")
public interface ContractApplysMapper {
	/**
	   * 分页查询 + 条件查询
	   * @param pageno
	   * @param pagesize
	   * @param sort
	   * @param order
	   * @param id
	   * @param contAppNum
	   * @return 
	   */
	
	List<ContractApplys> findPager(
		      @Param("pageno")Integer pageno,
		      @Param("pagesize")Integer pagesize,
		      @Param("sort")String sort,
		      @Param("order")String order,
		      
		      @Param("contAppNum")String contAppNum);
	
	long findPagerTotal(@Param("contAppNum") String contAppNum);
}
