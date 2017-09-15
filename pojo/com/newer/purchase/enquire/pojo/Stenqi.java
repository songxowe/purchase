package com.newer.purchase.enquire.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Stenqi implements Serializable {
	private static final long serialVersionUID=1L;
	private Integer id;
	private String sename;
	private String stype;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date edate; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sudate;
	
	private String status;
	public Stenqi() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSename() {
		return sename;
	}
	public void setSename(String sename) {
		this.sename = sename;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSudate() {
		return sudate;
	}
	public void setSudate(Date sudate) {
		this.sudate = sudate;
	}
	
	
	

}
