package com.newer.enquire.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 采购计划表
 * @author 
 *
 */
public class Stock implements Serializable{

	
	private static final long serialVersionUID = 3147792547669190914L;

	private Integer id;//序号
	private String stockNum;//采购计划编号
	private String stockName;//采购计划名称
	private String authorId;//编制人序号
	private String author;//编制人
	private String stockType;//采购类型
	private Double budget;//预算金额
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;//计划询价开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;//计划报价截止时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date submitDate;//下达时间
	private String remark;//备注
	private String leaderId;//部长序号
	private String leader;//部长
	private String leadAgree;//部长是否同意
	private String leadOpinion;//部长审核意见
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date leadDate;//部长审核时间
	
	
	public Stock() {
		
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


	public String getAuthorId() {
		return authorId;
	}


	public void setAuthorId(String authorId) {
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


	public String getLeaderId() {
		return leaderId;
	}


	public void setLeaderId(String leaderId) {
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
	
	
	
	
	
}
