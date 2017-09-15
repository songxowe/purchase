package com.newer.purchase.pojo;

import java.util.Date;

/**
 * 合同明细表
 *
 */
public class ContractDetail implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;// 序号
	private Integer contId;// 合同序号
	private String materialCode;// 物资编码
	private String materialName;// 物资名称
	private Integer amount;// 数量
	private Double unitPrice;// 单价(元/含税)
	private String measureUnit;// 计量单位
	private Double sumPrice;// 总价(元/含税)
	private Double mixPrice;// 运杂费(元/含税)
	private Double otherPrice;// 其他(元/含税)
	private Double totalPrice;// 总计(元/含税)
	private Date endDate;// 到货期
	private String address;//交货地点
	private String trans;// 运输方式	Y001-1：铁快，Y001-2：EMS航空，Y001-3：中铁快运，Y001-4：普邮，Y001-5：送货，Y001-6：提货，Y001-7：汽运
	private String wrapRequire;// 包装要求	 B001-1：散装，B001-2：托盘，B001-3：卷带，B001-4：管装，B001-5：防静电，B001-6：防震,防潮,防挤压，B001-7：防摩擦，B001-8：整箱，B001-9：整卷
	private String factory;// 制造厂
	private String otherRequire;// 其他要求

	public ContractDetail() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContId() {
		return contId;
	}

	public void setContId(Integer contId) {
		this.contId = contId;
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

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public String getWrapRequire() {
		return wrapRequire;
	}

	public void setWrapRequire(String wrapRequire) {
		this.wrapRequire = wrapRequire;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getOtherRequire() {
		return otherRequire;
	}

	public void setOtherRequire(String otherRequire) {
		this.otherRequire = otherRequire;
	}

}