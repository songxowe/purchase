package com.newer.purchase.pojo;

import java.util.Date;

/**
 * 合同表
 *
 */
public class Contract implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//序号
	private String contNum;//合同编号
	private String buyer;//买方
	private String seller;//卖方
	private String suppliernum;
	private Date contDate;//签订时间
	private String contType;//合同类型
	private String stockType;//采购类型
	private String contItem;//合同标的物
	private String money;//币别
	private String taxRate;//税率		S000-1：0%，S000-2：4%，S000-3：6%，S000-4：17%
	private String wrapBack;//包装物是否回收	B000-0：包装物不回收		B000-1：包装物回收
	private String verifyStand;//验收标准		Y000-1：国际（国家）标准		Y000-2：行业标准	Y000-3：企业标准
	private String tran;//运输方式		Y001-1：铁快，Y001-2：EMS航空，Y001-3：中铁快运，Y001-4：普邮，Y001-5：送货，Y001-6：提货，Y001-7：汽运
	private String payCond;//付款条件		F000-1：货到验收合格、自收到有效发票后90天付款，F000-2：货到验收合格、自收到有效发票后付款，F000-3：现场考核后付款，F000-4：货到验收合格、自收到有效发票后30天付款，F000-5：款到发货，F000-6：其它约定，
	private Date verifyDate;//验收时间
	private String qualityStand;//质量要求及技术标准		Z000-1：军标，Z000-2：国际标，Z000-3：铁标，Z000-4：国标，Z000-5：需方提供的技术文件标准，Z000-6：供方企业标准，Z000-7：其他，
	private String standardNo;//标准号
	private String place;//交(提)货地点		J000-1：供方所在地		J000-2：需方工厂
	private Double contPrice;//合同总金额
	private String transport;//运输费用负担		Y002-1：供方		Y002-2：需方
	private String payWay;//付款方式		F001-1：汇兑（电汇、信汇），F001-2：托收承付，F001-3：银行支票，F001-4：银行本票，F001-5：银行汇票，F001-6：委托收款，F001-7：商业票据
	private String outPerm;//逾期千分比
	private String outDay;//逾期天数
	private String wrapRequire;//包装要求	B001-1：散装，B001-2：托盘，B001-3：卷带，B001-4：管装，B001-5：防静电，B001-6：防震,防潮,防挤压，B001-7：防摩擦，B001-8：整箱，B001-9：整卷
	private String remark;//备注
	private Supplier supplier;// 供应商信息
	private ContractDetail contractDetail;// 合同表明细

	public Contract() {
	}

	public String getSuppliernum() {
		return suppliernum;
	}

	public void setSuppliernum(String suppliernum) {
		this.suppliernum = suppliernum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContNum() {
		return contNum;
	}

	public void setContNum(String contNum) {
		this.contNum = contNum;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getContDate() {
		return contDate;
	}

	public void setContDate(Date contDate) {
		this.contDate = contDate;
	}

	public String getContType() {
		return contType;
	}

	public void setContType(String contType) {
		this.contType = contType;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getContItem() {
		return contItem;
	}

	public void setContItem(String contItem) {
		this.contItem = contItem;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getWrapBack() {
		return wrapBack;
	}

	public void setWrapBack(String wrapBack) {
		this.wrapBack = wrapBack;
	}

	public String getVerifyStand() {
		return verifyStand;
	}

	public void setVerifyStand(String verifyStand) {
		this.verifyStand = verifyStand;
	}

	public String getTran() {
		return tran;
	}

	public void setTran(String tran) {
		this.tran = tran;
	}

	public String getPayCond() {
		return payCond;
	}

	public void setPayCond(String payCond) {
		this.payCond = payCond;
	}

	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getQualityStand() {
		return qualityStand;
	}

	public void setQualityStand(String qualityStand) {
		this.qualityStand = qualityStand;
	}

	public String getStandardNo() {
		return standardNo;
	}

	public void setStandardNo(String standardNo) {
		this.standardNo = standardNo;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Double getContPrice() {
		return contPrice;
	}

	public void setContPrice(Double contPrice) {
		this.contPrice = contPrice;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getOutPerm() {
		return outPerm;
	}

	public void setOutPerm(String outPerm) {
		this.outPerm = outPerm;
	}

	public String getOutDay() {
		return outDay;
	}

	public void setOutDay(String outDay) {
		this.outDay = outDay;
	}

	public String getWrapRequire() {
		return wrapRequire;
	}

	public void setWrapRequire(String wrapRequire) {
		this.wrapRequire = wrapRequire;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ContractDetail getContractDetail() {
		return contractDetail;
	}

	public void setContractDetail(ContractDetail contractDetail) {
		this.contractDetail = contractDetail;
	}

}