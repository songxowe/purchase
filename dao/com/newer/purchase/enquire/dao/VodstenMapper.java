package com.newer.purchase.enquire.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.purchase.enquire.pojo.Vodsten;

@Repository("vodstenMapper")
public interface VodstenMapper {  


	  @Select("select * from V_OD_ST_EN")
	  List<Vodsten>findAll();

}
