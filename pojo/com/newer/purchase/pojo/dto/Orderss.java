package com.newer.purchase.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class Orderss implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id; // 序号
	private String materialCode; // 物资编码
	private String materialName; // 物资名称
	private Integer amount; // 数量
	private String measureUnit; // 计量单位
	private Date startDate; // 开始交货期
	private Double unitPrice; // 预计单价(元)
	private Double sumprice; //预算总金额
	
	public Orderss() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getSumprice() {
		return sumprice;
	}
	public void setSumprice(Double sumprice) {
		this.sumprice = sumprice;
	}
	
}
