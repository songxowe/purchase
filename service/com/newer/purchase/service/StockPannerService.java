package com.newer.purchase.service;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.dao.StockPannerMapper;
import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.StockPanner;

@Service("stockPannerService")
public class StockPannerService {
	
	@Resource(name="stockPannerMapper")
	private StockPannerMapper stockPannerMapper;
	
	
	public Pager<StockPanner> findPager(Integer pageno, Integer pagesize, String sort,
			String order,Date endDate,String stockName){
		 Pager<StockPanner> pager = new Pager<StockPanner>();
		    // 设置分页数据
		    pager.setRows(stockPannerMapper.findPager(pageno, pagesize, sort, order, endDate, stockName));
		    // 设置数据总数
		    pager.setTotal(stockPannerMapper.findPagerTotal(endDate,stockName));
		   return pager;
	}
	
	public int modifyStock(Stock stock){
		return stockPannerMapper.modifyStock(stock);

	}
	
	public int modifyStatus(String leadAgree,Integer inmappingId){
		return stockPannerMapper.modifyStatus(leadAgree, inmappingId);
	}
	

	public Stock findById(Integer id){
		return stockPannerMapper.findById(id);
	}
	

	
	
}
