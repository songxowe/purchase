package com.newer.purchase.enquire.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.purchase.enquire.dao.VodstenMapper;
import com.newer.purchase.enquire.pojo.Vodsten;


@Service("vodstenService")
public class VodstenService {
	
		@Resource(name = "vodstenMapper")
		  private VodstenMapper vodstenMapper;


		  public List<Vodsten> findAll() {
		    return vodstenMapper.findAll();
		  }
}
