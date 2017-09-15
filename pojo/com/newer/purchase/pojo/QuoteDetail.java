package com.newer.purchase.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 报价明细表
 *
 */
public class QuoteDetail implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;// 序号
	private Integer quoteId;// 报价书序号
	private Integer orderId;// 需求计划序号
	private String materialCode;//物资编码
	private String materialName;//物资名称
	private String measureUnit;//计量单位
	private String standard;//标准	Z000-1：军标,Z000-2：国际标,Z000-3：铁标,Z000-4：国标,Z000-5：需方提供的技术文件标准,Z000-7：其他
	private String factory;//生产厂家
	private String prodYear;//生产年限		S003-1：一年	S003-2：两年	S003-3：三年
	private String wrap;//包装
	private Integer amount;//数量
	private Double unitPrice;//单价(元/含税)
	private Double sumPrice;//总价(元/含税)
	private Double mixPrice;//运杂费(元/含税)
	private Double otherPrice;//其他(元/含税)
	private Double totalPrice;//总计(元/含税)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;//开始到货日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;//结束到货期日

	public QuoteDetail() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getProdYear() {
		return prodYear;
	}

	public void setProdYear(String prodYear) {
		this.prodYear = prodYear;
	}

	public String getWrap() {
		return wrap;
	}

	public void setWrap(String wrap) {
		this.wrap = wrap;
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

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
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

	@Override
	public String toString() {
		return "QuoteDetail [id=" + id + ", quoteId=" + quoteId + ", orderId=" + orderId + ", materialCode="
				+ materialCode + ", materialName=" + materialName + ", measureUnit=" + measureUnit + ", standard="
				+ standard + ", factory=" + factory + ", prodYear=" + prodYear + ", wrap=" + wrap + ", amount=" + amount
				+ ", unitPrice=" + unitPrice + ", sumPrice=" + sumPrice + ", mixPrice=" + mixPrice + ", otherPrice="
				+ otherPrice + ", totalPrice=" + totalPrice + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	

}