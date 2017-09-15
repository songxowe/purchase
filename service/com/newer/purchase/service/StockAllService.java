package com.newer.purchase.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.pojo.User;
import com.newer.purchase.dao.StockAllMapper;
import com.newer.purchase.pojo.Orders;
import com.newer.purchase.pojo.OrdersMapping;
import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.Supplier;

@Service("stockAllService")
public class StockAllService {

	@Resource(name = "stockAllMapper")
	  private StockAllMapper stockAllMapper;
	
	  public Pager<OrdersMapping> findPager(Integer pageno, Integer pagesize, String sort, String order, String materialCode,
	      String materialName) {
	    Pager<OrdersMapping> pager = new Pager<OrdersMapping>();
	    // 设置分页数据
	    pager.setRows(stockAllMapper.findPager(pageno, pagesize, sort, order, materialCode, materialName));
	    // 设置数据总数
	    pager.setTotal(stockAllMapper.findPagerTotal(materialCode, materialName));
	    return pager;
	  }
	  
	  public Orders findById(Integer id){
		  return stockAllMapper.findById(id);
	  }
	  
	  public int add(Stock stock,Integer mappingId){
		  int resouce= 0;
		  resouce=stockAllMapper.add(stock);
		  //查询出刚刚保存进去的stock的id
		  String sort = "materialCode";
		  String order = "asc";
		  //高级查询，通过采购编号和采购名称查询出刚刚保存的那条记录，通过那条记录得到主键Id
		  //Pager<OrdersMapping> pager=findPager(1, 1, sort, order, stock.getStockNum(),stock.getStockName());
		  //OrdersMapping om=pager.getRows().get(0);
		  //mappingId是通过查询未编采购计划的单条记录传到编制采购页面去的ID（关联关系表的ID主键）
		 // modifyIdMapping(om.getId(), mappingId);
		 // if(stock.getStockType()=="C000-2"){
			//id,是通过查询单个供应商表得到的主键ID
			 // addStockSupplier(om.getId(),id);
		 // }
		  return resouce;
	  }
	  
	  public void addStockSupplier1(Stock stock,Integer mappingId,Integer id){
		  String sort = "materialCode";
		  String order = "asc";
		  //高级查询，通过采购编号和采购名称查询出刚刚保存的那条记录，通过那条记录得到主键Id
		  Pager<OrdersMapping> pager=findPager(1, 1, sort, order, stock.getStockNum(),stock.getStockName());
		  OrdersMapping om=pager.getRows().get(0);
		  //mappingId是通过查询未编采购计划的单条记录传到编制采购页面去的ID（关联关系表的ID主键）
		  modifyIdMapping(om.getId(), mappingId);
		  if(stock.getStockType()=="C000-2"){
			//id,是通过查询单个供应商表得到的主键ID
			  addStockSupplier(om.getId(),id);
		  }
	  }
	  
	  public int findStockId(String stockNum,String stockName){		  
		  return stockAllMapper.findStockId(stockNum, stockName);
	  }
	  
	  public List<Supplier> findName(String materialNum){
		  return stockAllMapper.findName(materialNum);
	  }
	  
	  public int modifyIdMapping(Integer stockId,Integer id){
		  return stockAllMapper.modifyIdMapping(stockId, id);
	  }
	  
	  public List<Supplier> findAllCompany(){
		  return stockAllMapper.findAllCompany();
	  }
	  public Supplier findBySupplier(Integer id){
		  return stockAllMapper.findBySupplier(id);
	  }
	  
	  public int addStockSupplier(Integer stockId,Integer supplier){
		  return stockAllMapper.addStockSupplier(stockId, supplier);
	  }
	  
	  public String findUser(User user){
		  return stockAllMapper.findUser(user);
	  }
}
