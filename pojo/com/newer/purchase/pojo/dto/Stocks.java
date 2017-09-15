package com.newer.purchase.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Stocks implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;//序号1
	private String stockNum;//采购计划编号11
	private String stockName;//采购计划名称2 12
	private String company;//公司名称 13
	private String author;//编制人员工姓名 14
	private Double budget;//预算金额(元) 15
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sstartDate;//询价开始时间 16
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;//报价截止时间 17
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date submitDate;//下达时间5
	private String stockType;//采购类型  C000-1：公开求购		C000-2：定向询价3 115
	private String remark;//备注说明 118 
	private String leadAgree;//部长是否同意		S002-0：不同意 119
	private String leadOpinion;//部长审核意见 120
	private String enquireName;//询价书名称6
	private String materialCode; // 物资编码 18
	private String materialName; // 物资名称 19
	private Integer amount; // 数量 110
	private String measureUnit; // 计量单位 111
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ostartDate; // 开始交货期 112
	private Double sumPrice; // 小计 113
	private Double unitPrice; // 预计单价(元) 114
	private Integer orderId;//需求计划序号
	private Integer stockId;//采购计划序号
	private Integer enquireId;//询价书序号
	private Integer contAppId;//合同申请序号
	private Integer quoteId;//报价书序号
	private Integer contId;//合同序号
	private String status;//采购状态代码4	
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
	
	public Stocks() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStockNum() {
		return stockNum;
	}
	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Date getSstartDate() {
		return sstartDate;
	}
	public void setSstartDate(Date sstartDate) {
		this.sstartDate = sstartDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLeadAgree() {
		return leadAgree;
	}
	public void setLeadAgree(String leadAgree) {
		this.leadAgree = leadAgree;
	}
	public String getLeadOpinion() {
		return leadOpinion;
	}
	public void setLeadOpinion(String leadOpinion) {
		this.leadOpinion = leadOpinion;
	}
	public String getEnquireName() {
		return enquireName;
	}
	public void setEnquireName(String enquireName) {
		this.enquireName = enquireName;
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
	public Date getOstartDate() {
		return ostartDate;
	}
	public void setOstartDate(Date ostartDate) {
		this.ostartDate = ostartDate;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getEnquireId() {
		return enquireId;
	}

	public void setEnquireId(Integer enquireId) {
		this.enquireId = enquireId;
	}

	public Integer getContAppId() {
		return contAppId;
	}

	public void setContAppId(Integer contAppId) {
		this.contAppId = contAppId;
	}

	public Integer getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}

	public Integer getContId() {
		return contId;
	}

	public void setContId(Integer contId) {
		this.contId = contId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	


}
