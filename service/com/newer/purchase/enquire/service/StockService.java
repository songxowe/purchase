package com.newer.purchase.enquire.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.enquire.dao.StockMapper;
import com.newer.purchase.enquire.pojo.Stock;

@Service("stockService")
public class StockService {
	
		
		@Resource(name = "stockMapper")
		  private StockMapper stockMapper;

		 public Pager<Stock> findPager(Integer pageno, Integer pagesize, String sort, String order, String stock_name,String stock_type) {
			    Pager<Stock> pager = new Pager<Stock>();
			    pager.setRows(stockMapper.findPager(pageno, pagesize, sort, order, stock_name,stock_type));
			    pager.setTotal(stockMapper.findPagerTotal(stock_name,stock_type));
			    return pager;
			  }
		 public int remove(Integer id){
			 return stockMapper.remove(id);
		 }

}
