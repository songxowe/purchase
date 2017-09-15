package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Orders;

@Repository("ordersMapper")
public interface OrdersMapper {
	
	//添加需求计划
	@Insert("insert into ORDERS (ID,ORDER_NUM,ORDER_SOURCE,BUILD_DATE,MATERIAL_CODE,MATERIAL_NAME,AMOUNT,MEASURE_UNIT,UNIT_PRICE,SUM_PRICE,START_DATE,END_DATE,ADDRESS,AUTHOR_ID,AUTHOR,PHONE,FAX,EMAIL,REMARK)values(#{id},#{orderNum,jdbcType=VARCHAR},#{orderSource,jdbcType=VARCHAR},#{buildDate,jdbcType=DATE},#{materialCode,jdbcType=VARCHAR},#{materialName,jdbcType=VARCHAR},#{amount,jdbcType=INTEGER},#{measureUnit,jdbcType=VARCHAR},#{unitPrice,jdbcType=DOUBLE},#{sumPrice,jdbcType=DOUBLE},#{startDate,jdbcType=DATE},#{endDate,jdbcType=DATE},#{address,jdbcType=VARCHAR},#{authorId},#{author,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},#{fax,jdbcType=VARCHAR},#{email,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR})")
	@SelectKey(statement="select seq_orders.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int add(Orders orders);
	
	//修改需求计划
	@Update("Update ORDERS set ORDER_NUM=#{orderNum,jdbcType=VARCHAR},ORDER_SOURCE=#{orderSource,jdbcType=VARCHAR},BUILD_DATE=#{buildDate,jdbcType=DATE},MATERIAL_CODE=#{materialCode,jdbcType=VARCHAR},MATERIAL_NAME=#{materialName,jdbcType=VARCHAR},AMOUNT=#{amount,jdbcType=INTEGER},MEASURE_UNIT=#{measureUnit,jdbcType=VARCHAR},UNIT_PRICE=#{unitPrice,jdbcType=DOUBLE},SUM_PRICE=#{sumPrice,jdbcType=DOUBLE},START_DATE=#{startDate,jdbcType=DATE},END_DATE=#{endDate,jdbcType=DATE},ADDRESS=#{address,jdbcType=VARCHAR},AUTHOR_ID=#{authorId},AUTHOR=#{author,jdbcType=VARCHAR},PHONE=#{phone,jdbcType=VARCHAR},FAX=#{fax,jdbcType=VARCHAR},EMAIL=#{email,jdbcType=VARCHAR},REMARK=#{remark,jdbcType=VARCHAR} where ID=#{id}")
	int modify(Orders orders);
	
	//删除计划
	@Delete("delete from ORDERS where ID=#{id}")
	int remove(Integer id);
	
	/**
	 * 根据id查询计划
	 */
	@Select("select ID id,ORDER_NUM orderNum,ORDER_SOURCE orderSource,BUILD_DATE buildDate,MATERIAL_CODE materialCode,MATERIAL_NAME materialName,"
			+ "AMOUNT amount,MEASURE_UNIT measureUnit,UNIT_PRICE unitPrice,SUM_PRICE sumPrice,START_DATE startDate,END_DATE endDate,ADDRESS address,"
			+ "AUTHOR_ID authorId,AUTHOR author,PHONE phone,FAX fax,EMAIL email,REMARK remark from ORDERS where ID=#{id}")
	Orders findById(Integer id);
	
	@Select("select ID id,ORDER_NUM orderNum,ORDER_SOURCE orderSource,BUILD_DATE buildDate,MATERIAL_CODE materialCode,MATERIAL_NAME materialName,"
			+ "AMOUNT amount,MEASURE_UNIT measureUnit,UNIT_PRICE unitPrice,SUM_PRICE sumPrice,START_DATE startDate,END_DATE endDate,ADDRESS address,"
			+ "AUTHOR_ID authorId,AUTHOR author,PHONE phone,FAX fax,EMAIL email,REMARK remark from ORDERS")
	List<Orders> find();
	/**
	 * 分页查询
	 */
	List<Orders> findPager(
			@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize,
			@Param("sort") String sort,
		    @Param("order") String order,
		    @Param("orderNum") String orderNum,
		    @Param("author") String author
			);
		
	/**
	 * 查询分页记录总数+条件查询
	 */
	long findPagerTotal(@Param("orderNum") String orderNum,@Param("author") String author);

	/**
	 * 报价用方法
	 * @param id
	 * @return
	 */
	Orders findByOrders(Integer id);
}
