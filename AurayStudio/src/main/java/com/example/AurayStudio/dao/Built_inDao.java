package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.Built_inDto;

@Mapper
public interface Built_inDao {
	
	@Select("select * from built_in where y_no=#{y_no}")
	Built_inDto findByYNo(String yNo) throws DataAccessException;
	
	@Select("SELECT y_no, b_name, style, pro_kind, y_img, content FROM built_in WHERE pro_kind = #{kKind}")
	List<Built_inDto> getBuilt_insByKKind(String kKind) throws DataAccessException;

	@Select("select * from built_in")
	List<Built_inDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM built_in LIMIT #{size} OFFSET #{offset}")
	List<Built_inDto> selectPagedBuilt_ins(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM built_in")
	int getTotalBuilt_inCount() throws DataAccessException;
}
