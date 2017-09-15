package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Supplier;





@Repository("suppliersMapper")
public interface SuppliersMapper {
	
	
	/**
	 * 条件+分页查询 供应商信息
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param supplierNum
	 * @param company
	 * @param kind
	 * @return
	 */
	List<Supplier> findPager(@Param("pageno") Integer pageno, 
			  @Param("pagesize") Integer pagesize,
			  @Param("sort") String sort,
		      @Param("order") String order,
		      @Param("supplierNum") String supplierNum,
		      @Param("company") String company,
		      @Param("kind") String kind);
	
	long findPagerTotal(@Param("supplierNum") String supplierNum, 
			  @Param("company") String company, 
			  @Param("kind") String kind);
	
	
	/**
	 * 根据id 查询供应商信息
	 * @return
	 */
	@Select("select ID as id,SUPPLIER_NUM as supplierNum,CERTIFICATE as certificate,COMPANY as company,KIND as kind,CONTACT as contact,PHONE as phone,FAX as fax,EMAIL as email,ADDRESS as address,ZIP as zip,REG_FUND as regFund,CORPORATION as corporation,ACHIEVEMENT as achievement,STATUS as status from SUPPLIER where ID=#{id}")
	Supplier findById(Integer id);
	
	
	@Insert("insert into SUPPLIER(ID,SUPPLIER_NUM,CERTIFICATE,COMPANY,KIND,CONTACT,PHONE,FAX,EMAIL,ADDRESS,ZIP,REG_FUND,CORPORATION,ACHIEVEMENT,STATUS) values(SEQ_SUPPLIER.nextval,#{supplierNum,jdbcType=VARCHAR},#{certificate},#{company},#{kind},#{contact},#{phone},#{fax},#{email},#{address},#{zip},#{regFund},#{corporation},#{achievement},'S004-1')")
	int add(Supplier supplier);
	
	@Select("select max(SUPPLIER_NUM) from SUPPLIER")
	String maxNum();
	
	@Select("select max(ID) from SUPPLIER")
	int findMaxId();
	
	/**
	 * 中供应商会员注册时，当用户添加成功和员工信息添加成功后，根据id修改供应商的用户id
	 * @param supplier
	 * @return
	 */
	@Update("update SUPPLIER set USER_ID=#{userID} where ID=#{id}")
	int update(Supplier supplier);

}
