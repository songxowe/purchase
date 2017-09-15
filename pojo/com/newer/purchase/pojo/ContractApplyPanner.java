package com.newer.purchase.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ContractApplyPanner implements Serializable{
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
	@DateTimeFormat(pattern ="yyyy-MM-dd hh:mm:ss")
	private Date planDate;//部长审核时间
	private Integer leaderId;//厂长员工序号
	private String leader;//厂长员工姓名
	private String leadAgree;//厂长是否同意		S002-0：不同意		S002-1：同意
	private String leadOpinion;//厂长审核意见
	@DateTimeFormat(pattern ="yyyy-MM-dd hh:mm:ss")
	private Date leadDate;//厂长审核时间
	private Integer inmappingId;//关联表ID
	private String status;//状态码
	private String supplierNum;//供应商编号
	private String materialCode;//物质编码
	private String materialName;//物质名称
	private Integer amount;//数量
	private Double unitPrice;// 单价(元/含税)
	private String measureUnit;// 计量单位
	private Double sumPrice;// 总价(元/含税)
	private Double mixPrice;// 运杂费(元/含税)
	private Double otherPrice;// 其他(元/含税)
	private Double totalPrice;// 总计(元/含税)
	private Date endDate;// 到货期
	private String address;//交货地点
	private String factory;// 制造厂
	private String  stockname;
	private Date startDate;
	private String stockType;
	
	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public String getSupplierNum() {
		return supplierNum;
	}

	public void setSupplierNum(String supplierNum) {
		this.supplierNum = supplierNum;
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

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Double getMixPrice() {
		return mixPrice;
	}

	public void setMixPrice(Double mixPrice) {
		this.mixPrice = mixPrice;
	}

	public Double getOtherPrice() {
		return otherPrice;
	}

	public void setOtherPrice(Double otherPrice) {
		this.otherPrice = otherPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getInmappingId() {
		return inmappingId;
	}

	public void setInmappingId(Integer inmappingId) {
		this.inmappingId = inmappingId;
	}

	public ContractApplyPanner() {
		
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

}
