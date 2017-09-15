package com.newer.purchase.enquire.pojo;

import java.io.Serializable;
import java.util.Date;

public class Stock implements Serializable{
	private static final long serialVersionUID=1L;
	private Integer id;
	private String stock_name;
	private String stock_type;
	private Date submit_date;
	private Date end_date;
	
	public Stock() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public String getStock_type() {
		return stock_type;
	}
	public void setStock_type(String stock_type) {
		this.stock_type = stock_type;
	}
	public Date getSubmit_date() {
		return submit_date;
	}
	public void setSubmit_date(Date submit_date) {
		this.submit_date = submit_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

}
