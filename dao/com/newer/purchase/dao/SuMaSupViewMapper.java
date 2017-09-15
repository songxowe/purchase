package com.newer.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.SuMaSupView;



/**
 * 供应商材料类别查询  映射器
 * @author FUQIAN
 *
 */
@Repository("suMaSupViewMapperf")
public interface SuMaSupViewMapper {
	
	/**
	 * 条件 + 分页查询
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param company
	 * @param materialName
	 * @return
	 */
	List<SuMaSupView> findPager(@Param("pageno") Integer pageno, 
			  @Param("pagesize") Integer pagesize,
			  @Param("sort") String sort,
		      @Param("order") String order,
		      @Param("company") String company,
		      @Param("materialName") String materialName);
	
	long findPagerTotal(@Param("company") String company, 
			  @Param("materialName") String materialName);
}
