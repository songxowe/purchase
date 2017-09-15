package com.newer.purchase.dao;




import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.purchase.pojo.Material;


@Repository("materialMapper")
public interface MaterialMapper {
	  /**
	   * 新增物资
	   * @param material
	   * @return
	   */
		@Insert("insert into MATERIAL(ID,MATERIAL_NUM,MATERIAL_NAME,MATERIAL_UNIT,MATERIAL_TYPE) values(#{id},#{materialNum,jdbcType=VARCHAR},#{materialName,jdbcType=VARCHAR},#{materialUnit,jdbcType=VARCHAR},#{materialType,jdbcType=VARCHAR})")
		@SelectKey(statement="select seq_materrial.nextval from dual",keyProperty="id",resultType=int.class,before=true)
		int add(Material material);
		
		  /**
		   * 修改物资
		   * @param material
		   * @return
		   */
		@Update("update MATERIAL set ID=#{id },MATERIAL_NUM=#{materialNum ,jdbcType=VARCHAR},MATERIAL_NAME=#{materialName, jdbcType=VARCHAR},MATERIAL_UNIT=#{materialUnit ,jdbcType=VARCHAR},MATERIAL_TYPE=#{materialType ,jdbcType=VARCHAR} where ID=#{id}")
		int modify(Material material);
		
		  /**
		   * 根据主键id删除物资
		   * @param id
		   * @return
		   */
		@Delete("delete from MATERIAL where ID=#{id}")
		int remove(Integer id);
		
		/**
		   * 根据主键id查询物资
		   * @param id
		   * @return
		   */
		//@Select("select ID,MATERIAL_NUM,MATERIAL_NAME,MATERIAL_UNIT,MATERIAL_TYPE from MATERIAL where ID=#{id}")
		Material findById(Integer id);
		
		  /**
		   * 分页查询 + 条件查询
		   * @param pageno
		   * @param pagesize
		   * @param sort
		   * @param order
		   * @param materialName
		   * @return
		   */
		List<Material> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize,
				@Param("sort") String sort, @Param("order") String order, @Param("materialNum") String materialNum,
				@Param("materialName") String materialName);

		/**
		 * 查询分页记录总数 + 条件查询
		 */
		long findPagerTotal(@Param("materialNum") String materialNum, @Param("materialName") String materialName);
}
