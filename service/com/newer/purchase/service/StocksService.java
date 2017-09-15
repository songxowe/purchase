package com.newer.purchase.service;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.newer.core.util.Pager;
import com.newer.purchase.dao.StocksMapper;
import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.dto.Stocks;


@Service("stocksService")
public class StocksService {
	@Resource(name="stocksMapper")
	private StocksMapper stocksMapper;
	
	public Pager<Stocks> findPager(Integer pageno, Integer pagesize, String sort,
			String order, String stockName,String status,String stockType){
		 Pager<Stocks> pager = new Pager<Stocks>();
		    // 设置分页数据
		    pager.setRows(stocksMapper.findPager(pageno, pagesize, sort, order, stockName, status, stockType));
		    // 设置数据总数
		    pager.setTotal(stocksMapper.findTotal(stockName,status,stockType));
		    return pager;
	}
	
	public Stocks findById(Integer id){
		return stocksMapper.findById(id);
	}
	
	public int remove(Integer id){
		return stocksMapper.remove(id);
	}
	
	public int modify(Integer id){
		return stocksMapper.modify(id);
	}
	
}
