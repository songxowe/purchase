package com.newer.purchase.pojo;

import java.io.Serializable;

/**
 * 视图类 供应商基本信息+物资信息+供应商选择的物资
 * @author FUQIAN
 *
 */
public class SuMaSupView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String supplierNum;
	private String certificate;
	private String company;
	private String kind;
	private String materialNum;//物资编码
	private String materialName;//物资名称
	private String materialType;//物资类别
	
	
	public SuMaSupView() {
		
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


	public String getMaterialNum() {
		return materialNum;
	}


	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}


	public String getMaterialName() {
		return materialName;
	}


	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}


	public String getMaterialType() {
		return materialType;
	}


	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	
	
	
	

}
