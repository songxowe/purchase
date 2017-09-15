package com.newer.purchase.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 * 询价表
 *
 */
public class Enquire implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//序号
	private String enquireNum;//询价书编号
	private String enquireName;//询价书名称
	private Date buildDate;//询价书创建时间
	private String company;//单位
	private String linkman;//联系人
	private String address;//地址
	private String phone;//电话
	private String fax;//传真
	private String zip;//邮编
	private String email;//电子邮箱
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date endDate;//截止时间
	private String remark;//备注
	private EnquireDetail enquDetail;// 询价表明细
	@NumberFormat(pattern="#,###.00")
	private Double maxPrice;	//最高报价
	@NumberFormat(pattern="#,###.00")
	private Double minPrice;	//最低报价
	private List<Quote> quotes;
	private Orders order;
	
	public Enquire() {
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<Quote> getQuotes() {		
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public Integer getId() {
		return this.id;
	}

	public Double getMaxPrice() {
		if(quotes!=null){
			double max=0;
			for(Quote p:quotes){
				double price=p.getOverallPrice();
				max=max>price?max:price;
			}
			this.maxPrice=max;
		}				
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Double getMinPrice() {
		if(quotes!=null){
			double min=getMaxPrice();
			for(Quote p:quotes){
				double price=p.getOverallPrice();
				min=min<price?min:price;
			}
			this.minPrice=min;
		}
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnquireNum() {
		return this.enquireNum;
	}

	public void setEnquireNum(String enquireNum) {
		this.enquireNum = enquireNum;
	}

	public String getEnquireName() {
		return this.enquireName;
	}

	public void setEnquireName(String enquireName) {
		this.enquireName = enquireName;
	}

	public Date getBuildDate() {
		return this.buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public EnquireDetail getEnquDetail() {
		return enquDetail;
	}

	public void setEnquDetail(EnquireDetail enquDetail) {
		this.enquDetail = enquDetail;
	}

	@Override
	public String toString() {
		return "Enquire [id=" + id + ", enquireNum=" + enquireNum + ", enquireName=" + enquireName + ", buildDate="
				+ buildDate + ", company=" + company + ", linkman=" + linkman + ", address=" + address + ", phone="
				+ phone + ", fax=" + fax + ", zip=" + zip + ", email=" + email + ", endDate=" + endDate + ", remark="
				+ remark + ", enquDetail=" + enquDetail + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice
				+ ", quotes=" + quotes + ", order=" + order + "]";
	}



}