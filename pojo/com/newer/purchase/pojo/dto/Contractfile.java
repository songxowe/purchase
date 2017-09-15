package com.newer.purchase.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Contractfile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//合同序号
	private String contNum;//合同编号
	private String buyer;//买方
	private String seller;//卖方
	private String suppliernum;//供应商编号
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contDate;//签订时间
	private String contType;//合同类型
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
	public Contractfile() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContNum() {
		return contNum;
	}
	public void setContNum(String contNum) {
		this.contNum = contNum;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Date getContDate() {
		return contDate;
	}
	public void setContDate(Date contDate) {
		this.contDate = contDate;
	}
	public String getContType() {
		return contType;
	}
	public void setContType(String contType) {
		this.contType = contType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
