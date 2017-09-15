package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.dto.Stocks;

@Repository("stocksMapper")
public interface StocksMapper {
	
	List<Stocks> findPager(@Param("pageno") Integer pageno, 
	@Param("pagesize") Integer pagesize, 
    @Param("sort") String sort,
    @Param("order") String order, 
    @Param("stockName") String stockName,
    @Param("status") String status,
    @Param("stockType") String stockType);
	
	int findTotal( @Param("stockName") String stockName,@Param("status") String status,@Param("stockType") String stockType);
	
	@Select("select S.ID id,STOCK_NUM stockNum,COMPANY company,STOCK_NAME stockName,S.AUTHOR author,BUDGET budget,S.START_DATE sstartDate,S.END_DATE endDate,"
			+ "MATERIAL_CODE materialCode,MATERIAL_NAME materialName,AMOUNT amount,MEASURE_UNIT measureUnit,O.START_DATE ostartDate,"
			+ "SUM_PRICE sumPrice,UNIT_PRICE unitPrice,STOCK_TYPE stockType,S.REMARK remark,LEAD_AGREE leadAgree,LEAD_OPINION leadOpinion "
			+ "from ID_MAPPING i LEFT OUTER JOIN STOCK s on i.stock_id=s.id LEFT OUTER JOIN ORDERS o on i.ORDER_ID=o.id  LEFT OUTER JOIN ENQUIRE"
			+ " e on i.enquire_id=e.id where S.ID=#{id}")
	Stocks findById(Integer id);
	
	@Delete("delete from STOCK where ID=#{id}")
	int remove(Integer id);
	
	@Update("update STOCK set SUBMIT_DATE=sysdate where ID=#{id} ")
	int modify(@Param(value="id")Integer id);

}
