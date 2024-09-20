package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.FlooringDto;

@Mapper
public interface FlooringDao {
	
	@Select("select * from flooring where y_no=#{y_no}")
	FlooringDto findByYNo(String yNo);
	
	@Select("SELECT y_no, f_name, pro_kind, y_img, content FROM flooring WHERE pro_kind = #{kKind}")
    List<FlooringDto> getFlooringsByKKind(String kKind);

	@Select("select * from flooring")
	List<FlooringDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM flooring LIMIT #{size} OFFSET #{offset}")
	List<FlooringDto> selectPagedFloorings(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM flooring")
	int getTotalFlooringCount() throws DataAccessException;
}
