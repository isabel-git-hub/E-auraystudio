package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.KitchenDto;

@Mapper
public interface KitchenDao {
	
	@Select("select * from kitchen where y_no=#{y_no}")
	KitchenDto findByYNo(String yNo) throws DataAccessException;
	
	@Select("SELECT y_no, k_name, pro_kind, k_kind, y_img FROM kitchen WHERE k_kind = #{kKind}")
    List<KitchenDto> getKitchensByKKind(String kKind) throws DataAccessException;

	@Select("SELECT y_no, k_name, pro_kind, k_kind, y_img FROM kitchen WHERE pro_kind = #{kKind}")
	List<KitchenDto> getKitchensByPKind(String pKind) throws DataAccessException;

	@Select("select * from kitchen")
	List<KitchenDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM kitchen LIMIT #{size} OFFSET #{offset}")
	List<KitchenDto> selectPagedKitchens(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM kitchen")
	int getTotalKitchenCount() throws DataAccessException;
}
