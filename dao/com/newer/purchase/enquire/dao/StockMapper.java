package com.newer.purchase.enquire.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.purchase.enquire.pojo.Stock;

@Repository("stockMapper")
public interface StockMapper {
	
	List<Stock> findPager(
		      @Param("pageno") Integer pageno, 
		      @Param("pagesize") Integer pagesize, 
		      @Param("sort") String sort,
		      @Param("order") String order, 
		      @Param("stock_name") String stock_name,
		      @Param("stock_type") String stock_type);
	 long findPagerTotal(@Param("stock_name") String stock_name,@Param("stock_type") String stock_type);
	  @Delete("delete from STOCK where ID=#{id}")
	  int remove(Integer id);
}
