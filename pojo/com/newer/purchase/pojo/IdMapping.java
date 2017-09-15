package com.newer.purchase.pojo;
/**
 * 编号对照表
 *
 */
public class IdMapping implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;//序号
	private Integer orderId;//需求计划序号
	private Integer stockId;//采购计划序号
	private Integer enquireId;//询价书序号
	private Integer contAppId;//合同申请序号
	private Integer quoteId;//报价书序号
	private Integer contId;//合同序号
	private String status;//采购状态代码
						//C001-10：需求计划未确认
						//C001-20：未编采购计划
						//C001-30：采购计划未报批
						//C001-40：采购计划未审批
						//C001-50：采购计划未下达
						//C001-51：采购计划审批不通过
						//C001-60：未编询价书
						//C001-70：询价书未发出
						//C001-80：询价书已发出
						//C001-90：询价已截止
						//C001-100：已揭示报价
						//C001-110：合同申请未报批
						//C001-120：合同申请未审核
						//C001-130：合同申请部长审批已审批
						//C001-131：合同申请部长审批不通过
						//C001-140：合同申请厂长审批已审批
						//C001-141：合同申请厂长审批不通过
						//C001-150：合同已签订
						//C001-160：合同已归档

	public IdMapping() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getEnquireId() {
		return this.enquireId;
	}

	public void setEnquireId(Integer enquireId) {
		this.enquireId = enquireId;
	}

	public Integer getContAppId() {
		return this.contAppId;
	}

	public void setContAppId(Integer contAppId) {
		this.contAppId = contAppId;
	}

	public Integer getQuoteId() {
		return this.quoteId;
	}

	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}

	public Integer getContId() {
		return this.contId;
	}

	public void setContId(Integer contId) {
		this.contId = contId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}