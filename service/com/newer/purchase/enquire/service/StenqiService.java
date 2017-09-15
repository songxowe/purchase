package com.newer.purchase.enquire.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.enquire.dao.StenqiMapper;
import com.newer.purchase.enquire.pojo.Stenqi;

@Service("stenqiService")
public class StenqiService {

		
			
			@Resource(name = "stenqiMapper")
			  private StenqiMapper stenqiMapper;

			 public Pager<Stenqi> findPager(Integer pageno, Integer pagesize, String sort, String order, String sename,String stype) {
				    Pager<Stenqi> pager = new Pager<Stenqi>();
			
				    pager.setRows(stenqiMapper.findPager(pageno, pagesize, sort, order,sename,stype));
			
				    pager.setTotal(stenqiMapper.findPagerTotal(sename,stype));
				    return pager;
				  }


}
