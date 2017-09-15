package com.newer.purchase.enquire.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Enquire implements Serializable{
	private static final long serialVersionUID=1L;
	private Integer id;
	private String enquire_num;
	private String enquire_name;
	private String company;
	private String linkman;
	private String address;
	private String phone;
	private String fax;
	private String zip;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date;
	private String remark;
	public Enquire() {
		
	}
	
	
	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEnquire_num() {
		return enquire_num;
	}
	public void setEnquire_num(String enquire_num) {
		this.enquire_num = enquire_num;
	}
	public String getEnquire_name() {
		return enquire_name;
	}
	public void setEnquire_name(String enquire_name) {
		this.enquire_name = enquire_name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
