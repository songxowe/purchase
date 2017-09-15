package com.newer.purchase.dao.plan;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Employee;


/**
 * 员工信息映射器接口
 * @author FUQIAN
 *
 */
@Repository("employeeMapperf")
public interface EmployeeMapper {
	
	/**
	 * 通过userID查询员工信息
	 * @param userID
	 * @return
	 */
	@Select("select ID as id,EMP_NUM as empNum,EMP_NAME as empName,SEX as sex,PHONE as phone,FAX as fax,EMAIL as email,ZIP as zip,ADDRESS as address,USER_ID as userID from EMPLOYEE where USER_ID=#{userID}")
	Employee findById(Integer userID);
	
	
	/**
	 * 添加员工信息
	 * @param employee
	 * @return
	 */
	@Insert("insert into EMPLOYEE(ID,EMP_NUM,EMP_NAME,SEX,PHONE,FAX,EMAIL,ZIP,ADDRESS,USER_ID) values(#{id},#{empNum},#{empName},#{sex},#{phone},#{fax},#{email},#{zip},#{address},#{userID})")
	@SelectKey(statement="select Seq_EMPLOYEE.nextval from dual",keyProperty="id",resultType=int.class,before=true)
	int add(Employee employee);
	
	@Select("select max(EMP_NUM) from EMPLOYEE")
	String maxNum();

}
