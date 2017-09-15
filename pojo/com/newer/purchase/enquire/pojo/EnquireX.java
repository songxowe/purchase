package com.newer.purchase.enquire.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EnquireX implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; //询价书id
	private String enquireName;//询价书名称
	private String stockType;//采购类型
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mi:ss")
	private Date startDate;//询价提交时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mi:ss")
	private Date endDate;//询价截止时间
	private String status;//询价书状态
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEnquireName() {
		return enquireName;
	}
	public void setEnquireName(String enquireName) {
		this.enquireName = enquireName;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
