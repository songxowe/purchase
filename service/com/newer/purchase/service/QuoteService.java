package com.newer.purchase.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.dao.QuoteMapper;
import com.newer.purchase.pojo.Enquire;
import com.newer.purchase.pojo.EnquireDetail;
import com.newer.purchase.pojo.Quote;
import com.newer.purchase.pojo.QuoteDetail;
import com.newer.purchase.pojo.dto.PoEnquire;
import com.newer.purchase.pojo.dto.PoQuote;

@Service("quoteService")
public class QuoteService {

	@Resource(name = "quoteMapper")
	private QuoteMapper quoteMapper;
	
	public Pager<PoEnquire> findEnquire(Integer pageno,Integer pagesize,String sort,
		      String order,String enquireName,Date beginDate,
		      Date endDate,String stockType,Integer userId){
		Pager<PoEnquire> pager=new Pager<PoEnquire>();
		pager.setRows(quoteMapper.findEnquire(pageno, pagesize, sort, order, enquireName, beginDate, endDate, stockType, userId));
		pager.setTotal(quoteMapper.findEnquireTotal(enquireName, beginDate, userId, endDate, stockType));
		return pager;
	}
	
	public Pager<PoQuote> findQuote(Integer pageno,Integer pagesize,String sort,
		      String order,String queTitle,Date beginDate,Date endDate,Integer supplierId,Integer userId){
		Pager<PoQuote> pager = new Pager<PoQuote>();
		pager.setRows(quoteMapper.findQuote(pageno, pagesize, sort, order, queTitle, beginDate, endDate, supplierId, userId));
		pager.setTotal(quoteMapper.findQuoteTotal(queTitle, beginDate, userId, endDate, supplierId));
		return pager;
	}
	
	public int addQuote(Quote quote){
		long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

		String quoteNum="U"+nowLong;
		quote.setQuoteNum(quoteNum);
		return quoteMapper.addQuote(quote);
	}
	
	public int addQuoteDetail(QuoteDetail quoteDetail){
		return quoteMapper.addQuoteDetail(quoteDetail);
	}
	
	public int modifyQuote(Quote quote){
		return quoteMapper.modifyQuote(quote);
	}
	
	public int modifyQuoteDetail(QuoteDetail quoteDetail){
		return quoteMapper.modifyQuoteDetail(quoteDetail);
	}
	
	public EnquireDetail findByEnquire(Integer enquireId){
		return quoteMapper.findByEnquire(enquireId);
	}
	
	public QuoteDetail findByQuote(Integer quoteId){
		return quoteMapper.findByQuote(quoteId);
	}
	
	public Enquire findById(Integer id){
		return quoteMapper.findById(id);
	}
	
	public int modifyStatus(Integer enquireId){
		return quoteMapper.modifyStatus(enquireId);
	}
	
	public int getQuoteId(){
		return quoteMapper.getQuoteId();
	}
}
