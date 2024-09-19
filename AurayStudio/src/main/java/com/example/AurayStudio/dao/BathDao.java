package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.BathDto;

@Mapper
public interface BathDao {

	@Select("select * from bath")
	List<BathDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM bath LIMIT #{size} OFFSET #{offset}")
	List<BathDto> selectPagedBaths(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM bath")
	int getTotalBathCount() throws DataAccessException;

}
