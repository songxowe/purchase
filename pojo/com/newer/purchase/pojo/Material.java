package com.newer.purchase.pojo;

import java.util.List;

/**
 * 物资信息表
 *
 */
public class Material implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;//序号
	private String materialNum;//物资编码
	private String materialName;//物资名称
	private String materialUnit;//计量单位
	private String materialType;//物资类别
	private List<Supplier> suppliers;//一对多，一个商品可以有多个供应商提供，通过SuppMaterial对应关系三表连接查询

	public Material() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaterialNum() {
		return this.materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialUnit() {
		return this.materialUnit;
	}

	public void setMaterialUnit(String materialUnit) {
		this.materialUnit = materialUnit;
	}

	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

}