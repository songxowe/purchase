package com.newer.purchase.pojo.plan;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 需求计划表
 *
 */
public class Orders implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // 序号
	private String orderNum; // 需求计划编号
	private String orderSource; // 需求来源
	private Date buildDate; // 需求计划创建时间
	private String materialCode; // 物资编码
	private String materialName; // 物资名称
	private Integer amount; // 数量
	private String measureUnit; // 计量单位
	private Double unitPrice; // 预计单价(元)
	private Double sumPrice; // 小计
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate; // 开始交货期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate; // 结束交货期
	private String address; // 交货地点
	private Integer authorId; // 编制人员工序号
	private String author; // 编制人员工姓名
	private String phone; // 联系电话
	private String fax; // 传真
	private String email; // 电子邮件
	private String remark; // 备注

	public Orders() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderNum=" + orderNum + ", orderSource=" + orderSource + ", buildDate="
				+ buildDate + ", materialCode=" + materialCode + ", materialName=" + materialName + ", amount=" + amount
				+ ", measureUnit=" + measureUnit + ", unitPrice=" + unitPrice + ", sumPrice=" + sumPrice
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", address=" + address + ", authorId="
				+ authorId + ", author=" + author + ", phone=" + phone + ", fax=" + fax + ", email=" + email
				+ ", remark=" + remark + "]";
	}

}