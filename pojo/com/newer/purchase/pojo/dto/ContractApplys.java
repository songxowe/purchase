package com.newer.purchase.pojo.dto;

import java.io.Serializable;

public class  ContractApplys implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//序号
	private String contAppNum;//合同申请编号
	private String statQuote;//报价份数
	private String topQuote;//最高报价
	private String lowQuote;//最低报价
	private Double allSumPrice;//总金额
	private String leadAgree;//厂长是否同意
	private Integer enquireid; //询价书序号
	public ContractApplys() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContAppNum() {
		return contAppNum;
	}
	public void setContAppNum(String contAppNum) {
		this.contAppNum = contAppNum;
	}
	public String getStatQuote() {
		return statQuote;
	}
	public void setStatQuote(String statQuote) {
		this.statQuote = statQuote;
	}
	public String getTopQuote() {
		return topQuote;
	}
	public void setTopQuote(String topQuote) {
		this.topQuote = topQuote;
	}
	public String getLowQuote() {
		return lowQuote;
	}
	public void setLowQuote(String lowQuote) {
		this.lowQuote = lowQuote;
	}
	public Double getAllSumPrice() {
		return allSumPrice;
	}
	public void setAllSumPrice(Double allSumPrice) {
		this.allSumPrice = allSumPrice;
	}
	public String getLeadAgree() {
		return leadAgree;
	}
	public void setLeadAgree(String leadAgree) {
		this.leadAgree = leadAgree;
	}
	public Integer getEnquireid() {
		return enquireid;
	}
	public void setEnquireid(Integer enquireid) {
		this.enquireid = enquireid;
	}
	
	
	

}
