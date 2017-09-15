package com.newer.purchase.dao.plan;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.plan.Orders;
import com.newer.purchase.pojo.plan.OrdersView;


@Repository("ordersMapperf")
public interface OrdersMapper {
	
	
	/**
	 * 分页+条件  需求计划一览表
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param materialCode
	 * @param materialName
	 * @param status
	 * @return
	 */
	List<OrdersView> findPager(@Param("pageno") Integer pageno, 
			  @Param("pagesize") Integer pagesize,
			  @Param("sort") String sort,
		      @Param("order") String order,
		      @Param("materialCode") String materialCode,
		      @Param("materialName") String materialName,
		      @Param("status") String status);
	
	long findPagerTotal(@Param("materialCode") String materialCode, 
			  @Param("materialName") String materialName, 
			  @Param("status") String status);

	
	@Insert("insert into ORDERS(ID,ORDER_NUM,ORDER_SOURCE,BUILD_DATE,MATERIAL_CODE,MATERIAL_NAME,AMOUNT,MEASURE_UNIT,UNIT_PRICE,SUM_PRICE,START_DATE,END_DATE,ADDRESS,AUTHOR_ID,AUTHOR,PHONE,FAX,EMAIL,REMARK)values(#{id},#{orderNum,jdbcType=VARCHAR},#{orderSource,jdbcType=VARCHAR},#{buildDate,jdbcType=DATE},#{materialCode,jdbcType=VARCHAR},#{materialName,jdbcType=VARCHAR},#{amount,jdbcType=INTEGER},#{measureUnit,jdbcType=VARCHAR},#{unitPrice,jdbcType=DOUBLE},#{sumPrice,jdbcType=DOUBLE},#{startDate,jdbcType=DATE},#{endDate,jdbcType=DATE},#{address,jdbcType=VARCHAR},#{authorId},#{author,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},#{fax,jdbcType=VARCHAR},#{email,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR})")
	@SelectKey(statement="select Seq_ORDERS.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int add(Orders orders);
	
	/**
	 * 查询需求计划最大编号
	 * @return
	 */
	@Select("select max(ORDER_NUM) from ORDERS ")
	String MaxNum();
	
	/**
	 * 根据需求计划编号，查询需求计划序号
	 * @param OrderNum
	 * @return
	 */
	@Select("select ID as id from ORDERS where ORDER_NUM=#{orderNum}")
	int findByOrderNum(String  orderNum);
	
	/**
	 * 根据id，查询需求计划信息
	 * @param id
	 * @return
	 */
	Orders findById(Integer id);
	
	
	
	
	
	/**
	 * 修改需求计划信息
	 * @param orders
	 * @return
	 */
	@Update("update ORDERS set AMOUNT=#{amount,jdbcType=INTEGER},UNIT_PRICE=#{unitPrice,jdbcType=DOUBLE},SUM_PRICE=#{sumPrice,jdbcType=DOUBLE},START_DATE=#{startDate,jdbcType=DATE},END_DATE=#{endDate,jdbcType=DATE},REMARK=#{remark,jdbcType=VARCHAR} where ID=#{id}")
	int modify(Orders orders);
	
	
	/**
	 * 删除需求计划信息
	 * @param id
	 * @return
	 */
	@Delete("delete from ORDERS where ID=#{id}")
	int remove(Integer id);
	
	
	/**
	 * 条件+分页 查询 未编采购计划的需求一览表
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param materialCode
	 * @param materialName
	 * @return
	 */
	List<OrdersView> findPager1(@Param("pageno") Integer pageno, 
			  @Param("pagesize") Integer pagesize,
			  @Param("sort") String sort,
		      @Param("order") String order,
		      @Param("materialCode") String materialCode,
		      @Param("materialName") String materialName);
	
	long findPagerTotal1(@Param("materialCode") String materialCode, 
			  @Param("materialName") String materialName);
	
	
}
