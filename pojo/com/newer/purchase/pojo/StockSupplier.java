package com.newer.purchase.pojo;

import java.io.Serializable;

/**
 * 采购计划已选供应商
 *
 */
public class StockSupplier implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer stockId;//采购计划序号
	private Integer supplier;//供应商信息

	public StockSupplier() {

	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getSupplier() {
		return supplier;
	}

	public void setSupplier(Integer supplier) {
		this.supplier = supplier;
	}
}