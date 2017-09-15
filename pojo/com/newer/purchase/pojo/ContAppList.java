package com.newer.purchase.pojo;

import java.io.Serializable;

public class ContAppList implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//序号
	private Integer mid;
	private String status;//状态
	private String contAppNumber;//合同申请编号
	private String statQuote;//报价份数
	private Double allSumPrice;//总金额
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContAppNumber() {
		return contAppNumber;
	}
	public void setContAppNumber(String contAppNumber) {
		this.contAppNumber = contAppNumber;
	}
	public String getStatQuote() {
		return statQuote;
	}
	public void setStatQuote(String statQuote) {
		this.statQuote = statQuote;
	}
	public Double getAllSumPrice() {
		return allSumPrice;
	}
	public void setAllSumPrice(Double allSumPrice) {
		this.allSumPrice = allSumPrice;
	}
	@Override
	public String toString() {
		return "ContAppList [id=" + id + ", mid=" + mid + ", status=" + status + ", contAppNumber=" + contAppNumber
				+ ", statQuote=" + statQuote + ", allSumPrice=" + allSumPrice + "]";
	}
	

		
	

}
