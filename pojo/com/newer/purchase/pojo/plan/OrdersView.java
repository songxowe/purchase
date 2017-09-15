package com.newer.purchase.pojo.plan;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 封装v_orders_idMapping视图
 */
public class OrdersView implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer id;//序号
	private String materialCode;//物资编码
	private String materialName;//物资名称
	private Integer amount;//数量
	private Double unitPrice;//预算单价
	private Double sumPrice;//小计
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;//开始交货日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;//结束日期
	private String orderSource;//需求来源
	
	private String status;//采购进度状态码

	public OrdersView() {
		
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

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
