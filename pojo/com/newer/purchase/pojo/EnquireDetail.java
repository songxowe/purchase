package com.newer.purchase.pojo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 询价明细表
 *
 */
public class EnquireDetail implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//序号
	private Integer enquireId;//询价书序号
	private Integer orderId;//需求计划序号
	private String materialCode;//物资编码
	private String materialName;//物资名称
	private Integer amount;//数量
	private String measureUnit;//单位
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;//开始到货期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;//结束到货期
	private String standard;//标准	Z000-1：军标，Z000-2：国际标，Z000-3：铁标，Z000-4：国标，Z000-5：需方提供的技术文件标准，Z000-7：其他
	private String factory;//生产厂家
	private String prodYear;//生产年限		S003-1：一年，S003-2：两年，S003-3：三年
	private String wrap;//包装
	private String remark;//备注

	public EnquireDetail() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnquireId() {
		return enquireId;
	}

	public void setEnquireId(Integer enquireId) {
		this.enquireId = enquireId;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}