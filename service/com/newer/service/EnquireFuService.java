package com.newer.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.dao.EnquireMapperF;
import com.newer.enquire.pojo.Enquire;
import com.newer.enquire.pojo.EnquireDetail;


	@Service("enquireFuService")
	public class EnquireFuService {
		
		@Resource(name="enquireMapperf")
		private EnquireMapperF enquireMapperf;
		
		
		/**
		 * 编制询价书
		 * @param enquire
		 * @return
		 */
		public int add(Enquire enquire){
			
			long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

			String orderNum="U"+nowLong;
		
			enquire.setEnquireNum(orderNum);
	
			return enquireMapperf.add(enquire);
		}

		
		/**
		 * 添加询价书明细
		 * @param enquireDetail
		 * @return
		 */
		public int add1(EnquireDetail enquireDetail){
			return enquireMapperf.add1(enquireDetail);
		}
		
		
		/**
		 * 查询当前询价书最大的id
		 * @return
		 */
		public int findMaxID(){
			return enquireMapperf.findMaxID();
		}
		
		
		  public Enquire findById(Integer id) {
			    return enquireMapperf.findById(id);
			  }	
		  
		  
		  public int modify(Enquire enq) {
			    return enquireMapperf.modify(enq);
			  }
}
