package com.newer.enquire.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 询价表 实体类
 * @author Jeana Yi
 * 2016年10月25日
 */
public class Enquire implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;//序号
	private String enquireNum;//询价书编号
	private String enquireName;//询价书名称
	private String company;//询价公司名字
	private String linkman;//联系人
	private String address;//地址
	private String phone;//电话
	private String fax;//传真
	private String zip;//邮编
	private String email;//邮箱
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date buildDate;//创建日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;//询价截止日期
	private String remark;//备注
	
	public Enquire() {
		
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
	public Date getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	

}
