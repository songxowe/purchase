package com.newer.purchase.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 * 询价表
 *
 */
public class EnquireList implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//序号
	private String enquireNum;//询价书编号
	private String enquireName;//询价书名称
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date buildDate;//询价书创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date endDate;//截止时间
	@NumberFormat(pattern="#,###.00")
	private Double maxPrice;	//最高报价
	@NumberFormat(pattern="#,###.00")
	private Double minPrice;	//最低报价
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEnquireNum() {
		return enquireNum;
	}
	public void setEnquireNum(String enquireNum) {
		this.enquireNum = enquireNum;
	}
	public String getEnquireName() {
		return enquireName;
	}
	public void setEnquireName(String enquireName) {
		this.enquireName = enquireName;
	}
	public Date getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	@Override
	public String toString() {
		return "EnquireList [id=" + id + ", enquireNum=" + enquireNum + ", enquireName=" + enquireName + ", buildDate="
				+ buildDate + ", endDate=" + endDate + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice + "]";
	}
		
}