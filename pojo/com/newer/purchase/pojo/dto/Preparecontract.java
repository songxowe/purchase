package com.newer.purchase.pojo.dto;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Preparecontract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sid;//供应商id
	private Integer quoteId;//报价书ID
	private String snum;//供应商编号
	private String company;//供应商名
	private String materialCode;//物资编码 QUOTE_DETAIL
	private String materialName;//物资名称 QUOTE_DETAIL
	private Integer amount;//数量 QUOTE_DETAIL
	private Double unitPrice;//单价(元/含税) QUOTE_DETAIL
	private String measureUnit;//计量单位 QUOTE_DETAIL
	private Double sumPrice;//总价(元/含税)
	private Double mixPrice;//运杂费(元/含税) QUOTE_DETAIL
	private Double otherPrice;//其他(元/含税) QUOTE_DETAIL
	private Double totalPrice;//总计(元/含税) QUOTE_DETAIL
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;//结束到货期日 QUOTE_DETAIL
	
	public Preparecontract() {
		
	}

	public Integer getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public Double getMixPrice() {
		return mixPrice;
	}

	public void setMixPrice(Double mixPrice) {
		this.mixPrice = mixPrice;
	}

	public Double getOtherPrice() {
		return otherPrice;
	}

	public void setOtherPrice(Double otherPrice) {
		this.otherPrice = otherPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Preparecontract [sid=" + sid + ", quoteId=" + quoteId + ", snum=" + snum + ", company=" + company
				+ ", materialCode=" + materialCode + ", materialName=" + materialName + ", amount=" + amount
				+ ", unitPrice=" + unitPrice + ", measureUnit=" + measureUnit + ", sumPrice=" + sumPrice + ", mixPrice="
				+ mixPrice + ", otherPrice=" + otherPrice + ", totalPrice=" + totalPrice + ", endDate=" + endDate + "]";
	}

		

	
	
}
