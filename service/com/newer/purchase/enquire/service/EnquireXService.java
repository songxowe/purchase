package com.newer.purchase.enquire.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.enquire.dao.EnquireXMapper;
import com.newer.purchase.enquire.pojo.EnquireX;

/**
 * 业务层:查询分页数据
 * @author Administrator
 *
 */
@Service("enquireXService")
public class EnquireXService {
	@Resource(name="enquireXMapper")
	private EnquireXMapper enquireXMapper;
	
	/**
	 * 分页数据封装
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param status
	 * @param enquireName
	 * @return
	 */
	public Pager<EnquireX> findPager(Integer pageno,Integer pagesize,String sort,String order,
			String status,String enquireName){
		Pager<EnquireX> pager=new Pager<EnquireX>();
		pager.setRows(enquireXMapper.findPager(pageno, pagesize, sort, order, status, enquireName));
		pager.setTotal(enquireXMapper.findPagerTotal(pageno, pagesize, sort, order, status, enquireName));
		return pager;
	}
	
}
