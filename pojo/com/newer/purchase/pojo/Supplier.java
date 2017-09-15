package com.newer.purchase.pojo;

import java.util.List;

import com.newer.pojo.User;

/**
 * 供应商信息表
 *
 */
public class Supplier implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//序号
	private String supplierNum;//供应商编号
	private String certificate;//供应商证书编号
	private String company;//公司名称
	private String kind;//公司性质		G000-1：国有企业，G000-2：集体企业，G000-3：股份合作企业，G000-4：有限责任公司，G000-5：股份有限公司，G000-6：私营独资企业，G000-7：中外合资经营企业
	private String contact;//联系人
	private String phone;//电话
	private String fax;//传真
	private String email;//电子邮件
	private String address;//地址
	private String zip;//邮编
	private String regFund;//注册资金
	private String corporation;//法人代表
	private Integer achievement;//业绩
	private String status;//是否可用		S004-0：不可用		S004-1：可用
	private User user;//用户账户信息
	private List<Material> materials;//一对多，一个供应商提供多种商品，通过SuppMaterial对应关系三表连接查询

	public Supplier() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSupplierNum() {
		return supplierNum;
	}

	public void setSupplierNum(String supplierNum) {
		this.supplierNum = supplierNum;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getRegFund() {
		return regFund;
	}

	public void setRegFund(String regFund) {
		this.regFund = regFund;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public Integer getAchievement() {
		return achievement;
	}

	public void setAchievement(Integer achievement) {
		this.achievement = achievement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierNum=" + supplierNum + ", certificate=" + certificate + ", company="
				+ company + ", kind=" + kind + ", contact=" + contact + ", phone=" + phone + ", fax=" + fax + ", email="
				+ email + ", address=" + address + ", zip=" + zip + ", regFund=" + regFund + ", corporation="
				+ corporation + ", achievement=" + achievement + ", status=" + status + "]";
	}

	

}