package com.newer.enquire.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 询价书明细 实体类
 * @author Jeana Yi
 * 2016年10月25日
 */
public class EnquireDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;//序号
	private Integer enquireId;//询价书序号
	private Integer orderId;//需求计划序号
	private String materialCode;//物资编码
	private String materialName;//物资名称
	private Integer amount;//数量
	private String measureUnit;//单位
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;//开始询价时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;//询价截止时间
	private String standard;//标准
	private String factory;//生产厂家
	private String prodYear;//生产年限
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
