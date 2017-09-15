package com.newer.purchase.dao;



import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.dto.Orderss;
@Repository("orderssMapper")
public interface OrderssMapper {
	@Select("SELECT O.ID id,O.MATERIAL_CODE materialCode,O.MATERIAL_NAME materialName,O.AMOUNT amount,O.MEASURE_UNIT measureUnit,"
			+ "O.START_DATE startDate,O.UNIT_PRICE unitPrice,O.SUM_PRICE sumprice FROM ID_MAPPING I LEFT OUTER JOIN STOCK S ON I.STOCK_ID=S.ID "
			+ "LEFT OUTER JOIN ORDERS O ON I.ORDER_ID=O.ID where O.ID=#{id}")
	Orderss findById(Integer id);

}
