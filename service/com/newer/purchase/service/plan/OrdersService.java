package com.newer.purchase.service.plan;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.dao.plan.IdMappingMapper;
import com.newer.purchase.dao.plan.OrdersMapper;
import com.newer.purchase.pojo.IdMapping;
import com.newer.purchase.pojo.plan.Orders;
import com.newer.purchase.pojo.plan.OrdersView;


@Service("ordersServicef")
public class OrdersService {

	@Resource(name = "ordersMapperf")
	private OrdersMapper ordersMapperf;
	
	@Resource(name="idMappingMapperf")
	private IdMappingMapper idMappingMapperf;

	/**
	 * 分页+高级查询  需求计划一览表
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param materialCode
	 * @param materialName
	 * @param status
	 * @return
	 */
	public Pager<OrdersView> findPager(Integer pageno, Integer pagesize, String sort, String order, String materialCode,
			String materialName, String status) {
		Pager<OrdersView> pager = new Pager<OrdersView>();
		pager.setRows(ordersMapperf.findPager(pageno, pagesize, sort, order, materialCode, materialName, status));
		pager.setTotal(ordersMapperf.findPagerTotal(materialCode, materialName, status));
		return pager;
	}
	
	
	
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
	public Pager<OrdersView> findPager1(Integer pageno, Integer pagesize, String sort, String order, String materialCode,
			String materialName) {
		Pager<OrdersView> pager = new Pager<OrdersView>();
		pager.setRows(ordersMapperf.findPager1(pageno, pagesize, sort, order, materialCode, materialName));
		pager.setTotal(ordersMapperf.findPagerTotal1(materialCode, materialName));
		return pager;
	}
	
	

	/**
	 * 录入需求计划
	 * 
	 * @param orders
	 * @return
	 */
	public int add(Orders orders) {
	
		long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String num="X"+nowLong;
		orders.setOrderNum(num);
	
		return ordersMapperf.add(orders);
	}
	
	/**
	 * 根据需求计划编号，查询需求计划序号
	 * @param OrderNum
	 * @return
	 */
	public int findByOrderNum(String  orderNum){
		return ordersMapperf.findByOrderNum(orderNum);
	}
	
	
	/**
	 * 根据id，查询需求详情
	 * @param id
	 * @return
	 */
	public Orders findById(Integer id){
		return ordersMapperf.findById(id);
	}
	
	/**
	 * 修改需求计划信息
	 * @param orders
	 * @return
	 */
	public int modify(Orders orders){
		return ordersMapperf.modify(orders);
	}
	
	/**
	 * 删除需求计划信息
	 * @param id
	 * @return
	 */
	public int remove(Integer id){
		int count=0;
		IdMapping idMapping=new IdMapping();
		idMapping.setOrderId(id);
		idMapping.setStatus("C001-10");
		int count1=idMappingMapperf.remove(idMapping);
		if(count1>0){
			count=ordersMapperf.remove(id);
		}
				
		return count;
	}
	
	


}
