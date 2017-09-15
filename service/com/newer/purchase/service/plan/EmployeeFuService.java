package com.newer.purchase.service.plan;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.dao.plan.EmployeeMapper;
import com.newer.purchase.pojo.Employee;


/**
 * 员工信息服务层
 * @author FUQIAN
 *
 */
@Service("employeeServicef")
public class EmployeeFuService {

	@Resource(name="employeeMapperf")
	private EmployeeMapper employeeMapperf;
	
	/**
	 * 根据用户id查询员工信息
	 * @param userID
	 * @return
	 */
	public Employee findById(Integer userID){
		return employeeMapperf.findById(userID);
	}
	
	
	/**
	 * 添加员工信息
	 * @param employee
	 * @return
	 */
	public int add(Employee employee){
		String pid_=employeeMapperf.maxNum();

		try {
			int pid=Integer.parseInt(pid_)+1;
			String empNum=Integer.toString(pid);
			if(empNum.length()<=6){
				for (int i = 0; i <=6-empNum.length(); i++) {
					empNum="0"+empNum;
				}
			}			
			employee.setEmpNum(empNum);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new NumberFormatException("数据类型转换错误!");
		}
		
		
		return employeeMapperf.add(employee);
	}
	
}
