package com.newer.purchase.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.dao.QuoteContAppMapper;
import com.newer.purchase.pojo.ContAppList;
import com.newer.purchase.pojo.Employee;
import com.newer.purchase.pojo.Enquire;
import com.newer.purchase.pojo.EnquireList;
import com.newer.purchase.pojo.IdMapping;
import com.newer.purchase.pojo.Quote;
import com.newer.purchase.pojo.QuoteDetail;

@Service("quoteContAppService")
public class QuoteContAppService {
	@Resource(name = "quoteContAppMapper")
	private QuoteContAppMapper quoteContAppMapper;

	public Pager<EnquireList> findEnquirePager(Integer beginPage, Integer endPage, String order, String sort,
			String enquireName, Date beginDate, Date endDate) {
		Pager<EnquireList> p = new Pager<EnquireList>();
		p.setRows(
				quoteContAppMapper.findEnquirePager(beginPage, endPage, order, sort, enquireName, beginDate, endDate));
		p.setTotal(quoteContAppMapper.findTotal(enquireName, beginDate, endDate));
		return p;
	}

	public Enquire findEnquireById(int id) {
		return quoteContAppMapper.findEnquireById(id);
	}

	public QuoteDetail findQuoteDetail(int qid) {
		return quoteContAppMapper.findQuoteDetail(qid);
	}

	public int addContractApply(String contAppNum, int statQuote, double minPrice, double maxPrice, double sumPrice,
			String remark, int authorId, String author) {
		return quoteContAppMapper.addContractApply(contAppNum, statQuote, minPrice, maxPrice, sumPrice, remark,
				authorId, author);
	}

	public Employee findEmpByUserId(int uid) {
		return quoteContAppMapper.findEmpByUserId(uid);
	}

	public IdMapping findIdMapping(int eid) {
		return quoteContAppMapper.findIdMapping(eid);
	}

	public int modifyIdMappingStatus(int mappingId, String status) {
		return quoteContAppMapper.modifyIdMappingStatus(mappingId, status);
	}

	public int findContAppId() {
		return quoteContAppMapper.findContAppId();
	}

	public int modifyIdMappingContApp(@Param("contAppId") int contAppId, @Param("id") int id) {
		return quoteContAppMapper.modifyIdMappingContApp(contAppId, id);
	}

	public String getCode(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String code="AP"+sdf.format(new Date());
		return code;
	}
	
	public int findEnquireByContAppId (Integer contAppId){
		return quoteContAppMapper.findEnquireByContAppId(contAppId);
	}
	
	public Pager<ContAppList> findContAppPager(Integer beginPage,Integer endPage,String order,String sort,String contAppNum){
		Pager<ContAppList> p=new Pager<ContAppList>();
		p.setTotal(quoteContAppMapper.findContAppTotal(contAppNum));
		p.setRows(quoteContAppMapper.findContAppPager(beginPage, endPage, order, sort, contAppNum));
		return p;
	}
	
	
	
	
	
	
}
