package com.newer.purchase.enquire.pojo;

import java.io.Serializable;
import java.util.Date;

public class Vodsten implements Serializable{
	private static final long serialVersionUID=1L;
	private Integer vid;
	private String vname;
	private String vcode;
	private String vamount;
	private String vmea;
	private Double vuprice;
	private Double vsprice;
	private Date vldate;
	private Date vedate;
	public Vodsten() {
	
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	public String getVamount() {
		return vamount;
	}
	public void setVamount(String vamount) {
		this.vamount = vamount;
	}
	public String getVmea() {
		return vmea;
	}
	public void setVmea(String vmea) {
		this.vmea = vmea;
	}
	public Double getVuprice() {
		return vuprice;
	}
	public void setVuprice(Double vuprice) {
		this.vuprice = vuprice;
	}
	public Double getVsprice() {
		return vsprice;
	}
	public void setVsprice(Double vsprice) {
		this.vsprice = vsprice;
	}
	public Date getVldate() {
		return vldate;
	}
	public void setVldate(Date vldate) {
		this.vldate = vldate;
	}
	public Date getVedate() {
		return vedate;
	}
	public void setVedate(Date vedate) {
		this.vedate = vedate;
	}
	
	
	

}
