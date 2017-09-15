package com.newer.purchase.pojo;

import java.util.Date;

/**
 * 合同申请表
 *
 */
public class ContractApply implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//序号
	private String contAppNum;//合同申请编号
	private String statQuote;//报价份数
	private String topQuote;//最高报价
	private String lowQuote;//最低报价
	private Double allSumPrice;//总金额
	private String remark;//备注
	private Integer authorId;//编制人员工序号
	private String author;//编制人员工姓名
	private Integer planerId;//部长员工序号
	private String planer;//部长员工姓名
	private String planAgree;//部长是否同意		S002-0：不同意		S002-1：同意
	private String planOpinion;//部长审核意见
	private Date planDate;//部长审核时间
	private Integer leaderId;//厂长员工序号
	private String leader;//厂长员工姓名
	private String leadAgree;//厂长是否同意		S002-0：不同意		S002-1：同意
	private String leadOpinion;//厂长审核意见
	private Date leadDate;//厂长审核时间

	public ContractApply() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContAppNum() {
		return contAppNum;
	}

	public void setContAppNum(String contAppNum) {
		this.contAppNum = contAppNum;
	}

	public String getStatQuote() {
		return statQuote;
	}

	public void setStatQuote(String statQuote) {
		this.statQuote = statQuote;
	}

	public String getTopQuote() {
		return topQuote;
	}

	public void setTopQuote(String topQuote) {
		this.topQuote = topQuote;
	}

	public String getLowQuote() {
		return lowQuote;
	}

	public void setLowQuote(String lowQuote) {
		this.lowQuote = lowQuote;
	}

	public Double getAllSumPrice() {
		return allSumPrice;
	}

	public void setAllSumPrice(Double allSumPrice) {
		this.allSumPrice = allSumPrice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getPlanerId() {
		return planerId;
	}

	public void setPlanerId(Integer planerId) {
		this.planerId = planerId;
	}

	public String getPlaner() {
		return planer;
	}

	public void setPlaner(String planer) {
		this.planer = planer;
	}

	public String getPlanAgree() {
		return planAgree;
	}

	public void setPlanAgree(String planAgree) {
		this.planAgree = planAgree;
	}

	public String getPlanOpinion() {
		return planOpinion;
	}

	public void setPlanOpinion(String planOpinion) {
		this.planOpinion = planOpinion;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
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

	@Override
	public String toString() {
		return "ContractApply [id=" + id + ", contAppNum=" + contAppNum + ", statQuote=" + statQuote + ", topQuote="
				+ topQuote + ", lowQuote=" + lowQuote + ", allSumPrice=" + allSumPrice + ", remark=" + remark
				+ ", authorId=" + authorId + ", author=" + author + ", planerId=" + planerId + ", planer=" + planer
				+ ", planAgree=" + planAgree + ", planOpinion=" + planOpinion + ", planDate=" + planDate + ", leaderId="
				+ leaderId + ", leader=" + leader + ", leadAgree=" + leadAgree + ", leadOpinion=" + leadOpinion
				+ ", leadDate=" + leadDate + "]";
	}

}