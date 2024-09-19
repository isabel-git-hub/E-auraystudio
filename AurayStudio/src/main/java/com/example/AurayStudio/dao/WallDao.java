package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.WallDto;

@Mapper
public interface WallDao {

	@Select("select * from wall")
	List<WallDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM wall LIMIT #{size} OFFSET #{offset}")
	List<WallDto> selectPagedWalls(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM wall")
	int getTotalWallCount() throws DataAccessException;

}
