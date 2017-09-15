package com.newer.purchase.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class PoEnquire implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//序号
	private String enquireNum;//询价书编号
	private String enquireName;//询价书名称
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date buildDate;//询价书创建时间
	private String company;//单位
	private String linkman;//联系人
	private String address;//地址
	private String phone;//电话
	private String fax;//传真
	private String zip;//邮编
	private String email;//电子邮箱
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;//截止时间
	private String remark;//备注
	private String status;//编号对照表中状态
	private String stockType;//采购类型 
	private Integer supplierId;//采购商编号
	private Integer userId;
	
	public PoEnquire() {
		// TODO Auto-generated constructor stub
	}

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PoEnquire [id=" + id + ", enquireNum=" + enquireNum + ", enquireName=" + enquireName + ", buildDate="
				+ buildDate + ", company=" + company + ", linkman=" + linkman + ", address=" + address + ", phone="
				+ phone + ", fax=" + fax + ", zip=" + zip + ", email=" + email + ", endDate=" + endDate + ", remark="
				+ remark + ", status=" + status + ", stockType=" + stockType + ", supplierId=" + supplierId + "]";
	}
	
	
	
}
