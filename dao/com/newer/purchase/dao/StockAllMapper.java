package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.pojo.User;
import com.newer.purchase.pojo.Employee;
import com.newer.purchase.pojo.Orders;
import com.newer.purchase.pojo.OrdersMapping;
import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.Supplier;

@Repository("stockAllMapper")
public interface StockAllMapper {

	/**
	 * 未编采购计划的需求一览表(查询所有未采编以及分页，高级查询)
	 * @param pageno 第几页
	 * @param pagesize 每页显示多少条
	 * @param sort 查询条件属性
	 * @param order 排序
	 * @param materialCode 物资编码
	 * @param materialName 物资名称
	 * @return 返回所有未采编的数据
	 */
	List<OrdersMapping> findPager(
		      @Param("pageno")Integer pageno,
		      @Param("pagesize")Integer pagesize,
		      @Param("sort")String sort,
		      @Param("order")String order,
		      @Param("materialCode")String materialCode,
		      @Param("materialName")String materialName);
/**
 * 总条数
 * @param materialCode
 * @param materialName
 * @return
 */
		  long findPagerTotal(
				  @Param("materialCode") String materialCode,
			      @Param("materialName") String materialName);
	
		  /**
		   * 查询单条未采编记录
		   * @param id
		   * @return
		   */
	@Select("select ID,ORDER_NUM orderNum,MATERIAL_CODE materialCode,MATERIAL_NAME materialName,"
			+ "AMOUNT amount,MEASURE_UNIT measureUnit,UNIT_PRICE unitPrice,SUM_PRICE sumPrice,"
			+ "START_DATE startDate,AUTHOR author,EMAIL email,PHONE phone,FAX fax,REMARK remark "
			+ "from ORDERS where ID=#{id}")
	Orders findById(Integer id);
	
	/**
	 * 录入采编信息
	 * @param stock
	 * @return
	 */
	@Insert("insert into STOCK(ID,STOCK_NUM,STOCK_NAME,AUTHOR_ID,AUTHOR,BUDGET,BUILD_DATE,START_DATE,END_DATE,STOCK_TYPE,REMARK) values"
			+ "(#{id},#{stockNum,jdbcType=VARCHAR},#{stockName,jdbcType=VARCHAR},#{authorId,jdbcType=INTEGER},#{author,jdbcType=VARCHAR},#{budget,jdbcType=DOUBLE},"
			+ "#{buildDate},#{startDate,jdbcType=DATE},#{endDate,jdbcType=DATE},#{stockType},#{remark,jdbcType=VARCHAR})")
	@SelectKey(statement = "select SEQ_STOCK.NEXTVAL from DUAL", keyProperty = "id", resultType = int.class, before = true)
	int add(Stock stock);
	
	/**
	 * 查询所有符合物资编码条件的供应商（公开求购）
	 * @param materialNum
	 * @return
	 */
	List<Supplier> findName(String materialNum);
	
	/**
	 * 在添加进采购计划的同时将采购的主键ID以及修改状态码加入编号对照表（关联表）
	 */
	@Update("update ID_MAPPING set STOCK_ID=#{stockId},STATUS='C001-30' where ID=#{id}")
	int modifyIdMapping(
			@Param("stockId") Integer stockId,
		    @Param("id") Integer id
			);
	
	/**
	 * 查询所有供应商公司名（定向询价）
	 * @return
	 */
	@Select("select ID,COMPANY from SUPPLIER")
	List<Supplier> findAllCompany();
	
	/**
	 * 通过供应商表的主键ID查询出单个供应商公司名
	 */
	@Select("select ID,COMPANY from SUPPLIER where ID=#{id}")
	Supplier findBySupplier(Integer id);
	
	/**
	 * 将定向询价的结果（采购计划序号 主键，供应商序号 主键）添加进采购计划已选供应商(STOCK_SUPPLIER)表中
	 */
	@Insert("insert into STOCK_SUPPLIER(STOCK_ID,SUPPLIER_ID) values(#{stockId,jdbcType=INTEGER},#{supplier,jdbcType=INTEGER})")
	int addStockSupplier(
			@Param("stockId") Integer stockId,
		    @Param("supplier") Integer supplier
			);
	
	/*
	 * 查询员工表的员工姓名（已知userid,从登陆的页面session中取出user.getId()）
	 */
	@Select("Select EMP_NAME empName from EMPLOYEE where USER_ID=#{id}")
	String findUser(User user);
	
	/**
	 * 查stockid
	 * 
	 */
	@Select("select id from stock where stock_num=#{stockNum} and stock_name=#{stockName}")
	public int findStockId(@Param(value="stockNum")String stockNum,@Param(value="stockName")String stockName);
}
