package com.newer.purchase.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.dao.SuMaSupViewMapper;
import com.newer.purchase.pojo.SuMaSupView;



@Service("suMaSupViewServicef")
public class SuMaSupViewService {
	
	@Resource(name="suMaSupViewMapperf")
	private SuMaSupViewMapper suMaSupViewMapperf;
	
	
	/**
	 * 条件+分页查询
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param company
	 * @param materialName
	 * @return
	 */
	public Pager<SuMaSupView> findPager(Integer pageno, Integer pagesize, String sort, String order, String company,
			String materialName) {
		Pager<SuMaSupView> pager = new Pager<SuMaSupView>();
		pager.setRows(suMaSupViewMapperf.findPager(pageno, pagesize, sort, order, company, materialName));
		pager.setTotal(suMaSupViewMapperf.findPagerTotal(company, materialName));
		return pager;
	}

}
