package com.newer.purchase.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newer.core.util.Pager;
import com.newer.core.util.StockRandom16;
import com.newer.purchase.pojo.Orders;
import com.newer.purchase.pojo.OrdersMapping;
import com.newer.purchase.pojo.Stock;
import com.newer.purchase.pojo.Supplier;
import com.newer.purchase.service.QuoteService;
import com.newer.purchase.service.StockAllService;

public class StockAllTest {

	private StockAllService stockAllService;
	
	private QuoteService service;

	@Test
	public void list() {
		// easyui 必需参数
		Integer page = 1;
		Integer rows = 3;
		String sort = "materialCode";
		String order = "asc";

		// 条件参数 (可选)
		String materialCode = null;
		String materialName = null;

		// 处理起始页和结束页
		Integer pageno = (page - 1) * rows;
		Integer pagesize = page * rows;

		Pager<OrdersMapping> pager = stockAllService.findPager(pageno, pagesize, sort, order, materialCode, materialName);
		System.out.println("分页总数: " + pager.getTotal());
		for (OrdersMapping orders : pager.getRows()) {
			System.out.println(orders.getMappingId()+" "+orders.getMaterialCode() + " " + orders.getMaterialName()+" "+orders.getAmount()+" "+orders.getSumPrice());
		}
	}
	
	@Test
	public void findById(){
		Orders orders=stockAllService.findById(3);
		System.out.println(orders.getMaterialCode()+" "+orders.getMaterialName());
	}
	
	@Test
	public void addStock(){
		int mappingId=2;
		
		Stock stock=new Stock();
		Orders orders=stockAllService.findById(4);
		stock.setStockNum((StockRandom16.random16()).toString());
		stock.setStockName("20020055100129");
		stock.setAuthor("杨春1");
		stock.setBudget(orders.getSumPrice());
		stock.setBuildDate(new Date());
		stock.setStockType("C000-2");
		int count=stockAllService.add(stock,mappingId);
		if(count>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void findName(){
		List<Supplier> suppliers  = stockAllService.findName("WZ0001");
		for(int i=0;i<6;i++){
			System.out.println(suppliers.get(i).getCompany());
		}
		
	}
	
	@Test
	public void findAllCompany(){
		List<Supplier> supplier=stockAllService.findAllCompany();
		for(int i=0;i<6;i++){
			System.out.println(supplier.get(i).getCompany());
		}
	}
	
	@Test
	public void findBySupplier(){
		Supplier s=stockAllService.findBySupplier(1);
		System.out.println(s.getCompany()+" "+s.getId());
	}
	
	@Test
	public void test5(){
		int id=stockAllService.findStockId("786433395115187", "呵呵");
		System.out.println(id);
	}
	
	
	
	@Test
	public void test11(){
		int a=service.getQuoteId();
		System.out.println(a);
	}
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("resource")
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("quoteService", QuoteService.class);
	}
	

	
}
