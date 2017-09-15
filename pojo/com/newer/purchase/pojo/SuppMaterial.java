package com.newer.purchase.pojo;
import java.io.Serializable;
/**
 * 供应商对应产品表
 *
 */
public class SuppMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer supplierId;//供应商序号
	private Integer materialId;//物资序号

	public SuppMaterial() {
	}


	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}


}