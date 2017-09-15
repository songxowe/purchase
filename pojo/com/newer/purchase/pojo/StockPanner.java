package com.newer.purchase.pojo;

import java.io.Serializable;
import java.util.Date;

public class StockPanner implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;//序号
	private String stockNum;//采购计划编号
	private String stockName;//采购计划名称
	private Date buildDate;//采购计划创建时间
	private Integer authorId;//编制人员工序号
	private String author;//编制人员工姓名
	private String stockType;//采购类型  C000-1：公开求购		C000-2：定向询价
	private Double budget;//预算金额(元)
	private Date startDate;//询价开始时间
	private Date endDate;//报价截止时间
	private Date submitDate;//下达时间
	private String remark;//备注
	private Integer leaderId;//部长员工序号
	private String leader;//部长员工名字
	private String leadAgree;//部长是否同意		S002-0：不同意		S002-1：同意
	private String leadOpinion;//部长审核意见
	private Date leadDate;//部长审核时间
	private String status;//采购状态代码4	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private Integer inmappingId;
	
	
	public StockPanner() {
	
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
	public Date getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
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
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
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
	public Date getLeadDate() {
		return leadDate;
	}
	public void setLeadDate(Date leadDate) {
		this.leadDate = leadDate;
	}
	public Integer getInmappingId() {
		return inmappingId;
	}
	public void setInmappingId(Integer inmappingId) {
		this.inmappingId = inmappingId;
	}
	
	
}
