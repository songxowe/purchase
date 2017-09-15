package com.newer.purchase.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.util.Pager;
import com.newer.purchase.dao.MaterialMapper;
import com.newer.purchase.pojo.Material;

/**
 * 物资管理业务逻辑类
 * 
 * @author SONG
 *
 */
@Service("materialService")
public class MaterialService {
	@Resource(name="materialMapper")
	private MaterialMapper materialMapper;
	
	public Pager<Material> findPager(Integer pageno, Integer pagesize, String sort, String order, String materialNum,
			String materialName) {
		Pager<Material> pager = new Pager<Material>();
		// 设置分页数据
		pager.setRows(materialMapper.findPager(pageno, pagesize, sort, order, materialNum, materialName));
		// 设置数据总数
		pager.setTotal(materialMapper.findPagerTotal(materialNum, materialName));
		return pager;
	}
	
	public int add(Material material){
		return materialMapper.add(material);
	} 
	
	public int modify(Material material){
		return materialMapper.modify(material);
	}
	
	public int remove(Integer id){
		return materialMapper.remove(id);
	}
	
	public Material findById(Integer id){
		return materialMapper.findById(id);
	}
	
}
