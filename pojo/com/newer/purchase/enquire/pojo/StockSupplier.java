package com.newer.purchase.enquire.pojo;

import java.io.Serializable;

public class StockSupplier implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer stockID;
	private Integer supplierID;
	
	public StockSupplier() {
	
	}

	public Integer getStockID() {
		return stockID;
	}

	public void setStockID(Integer stockID) {
		this.stockID = stockID;
	}

	public Integer getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}
	
	
	
	
	

}
