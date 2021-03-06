package com.newer.purchase.pojo;

/**
 * 报价表
 *
 */
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Quote implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//序号
	private String quoteNum;//报价书编号
	private Integer enquireId;//询价书序号
	private String quoCompany;//报价单位
	private String quoAddress;//报价单位地址
	private String quoLinkman;//报价单位联系人
	private String quoPhone;//报价单位联系电话
	private String quoFax;//报价单位传真
	private String quoEmail;//报价单位电子邮件
	private String queTitle;//报价书标题
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date queDate;//报价时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;//询价截止时间
	private Double sumAmount;//数量
	private Double overallPrice;//金额
	private String quoRemark;//说明
	private String status;//状态	B001-1：结果未发，	B001-2：中标，	B001-3：未中
	private Supplier supplier;//供应商信息
	private QuoteDetail quoteDetail;//报价详细信息

	public Quote() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuoteNum() {
		return quoteNum;
	}

	public void setQuoteNum(String quoteNum) {
		this.quoteNum = quoteNum;
	}

	public Integer getEnquireId() {
		return enquireId;
	}

	public void setEnquireId(Integer enquireId) {
		this.enquireId = enquireId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getQuoCompany() {
		return quoCompany;
	}

	public void setQuoCompany(String quoCompany) {
		this.quoCompany = quoCompany;
	}

	public String getQuoAddress() {
		return quoAddress;
	}

	public void setQuoAddress(String quoAddress) {
		this.quoAddress = quoAddress;
	}

	public String getQuoLinkman() {
		return quoLinkman;
	}

	public void setQuoLinkman(String quoLinkman) {
		this.quoLinkman = quoLinkman;
	}

	public String getQuoPhone() {
		return quoPhone;
	}

	public void setQuoPhone(String quoPhone) {
		this.quoPhone = quoPhone;
	}

	public String getQuoFax() {
		return quoFax;
	}

	public void setQuoFax(String quoFax) {
		this.quoFax = quoFax;
	}

	public String getQuoEmail() {
		return quoEmail;
	}

	public void setQuoEmail(String quoEmail) {
		this.quoEmail = quoEmail;
	}

	public String getQueTitle() {
		return queTitle;
	}

	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}

	public Date getQueDate() {
		return queDate;
	}

	public void setQueDate(Date queDate) {
		this.queDate = queDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(Double sumAmount) {
		this.sumAmount = sumAmount;
	}

	public Double getOverallPrice() {
		return overallPrice;
	}

	public void setOverallPrice(Double overallPrice) {
		this.overallPrice = overallPrice;
	}

	public String getQuoRemark() {
		return quoRemark;
	}

	public void setQuoRemark(String quoRemark) {
		this.quoRemark = quoRemark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public QuoteDetail getQuoteDetail() {
		return quoteDetail;
	}

	public void setQuoteDetail(QuoteDetail quoteDetail) {
		this.quoteDetail = quoteDetail;
	}

}