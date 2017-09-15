package com.newer.enquire.pojo;

import java.io.Serializable;

/**
 * 编码对应表实体类
 * @author FUQIAN
 *
 */
public class IdMapping implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;//序号
	private Integer orderID;//需求计划序号
	private Integer stockID;//采购计划序号
	private Integer enquireID;//询价书序号
	private Integer contAppID;//合同申请序号
	private Integer quoteID;//报价书序号
	private Integer contID;//合同序号
	private String status;//采购状态代码
	
	public IdMapping() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getStockID() {
		return stockID;
	}
	public void setStockID(Integer stockID) {
		this.stockID = stockID;
	}
	public Integer getEnquireID() {
		return enquireID;
	}
	public void setEnquireID(Integer enquireID) {
		this.enquireID = enquireID;
	}
	public Integer getContAppID() {
		return contAppID;
	}
	public void setContAppID(Integer contAppID) {
		this.contAppID = contAppID;
	}
	public Integer getQuoteID() {
		return quoteID;
	}
	public void setQuoteID(Integer quoteID) {
		this.quoteID = quoteID;
	}
	public Integer getContID() {
		return contID;
	}
	public void setContID(Integer contID) {
		this.contID = contID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
