package com.newer.purchase.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.dao.IdMappingMapper;
import com.newer.purchase.pojo.IdMapping;

@Service("idMappingService")
public class IdMappingService {
	@Resource(name="idMappingMapper")
	private IdMappingMapper idMappingMapper;
	
	
	public int modifyIdMapping(String status,Integer stockId){
		return idMappingMapper.modifyIdMapping(status,stockId);
	}
	
	public int remove(Integer id){
		return idMappingMapper.remove(id);
	}
	
	public int add(IdMapping idMapping){
		return idMappingMapper.add(idMapping);
	}
	
	public int modify(IdMapping idMapping){
		return idMappingMapper.modify(idMapping);
	}
}
