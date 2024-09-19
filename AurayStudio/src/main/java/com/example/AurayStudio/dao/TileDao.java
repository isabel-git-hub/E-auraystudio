package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.TileDto;

@Mapper
public interface TileDao {

	@Select("select * from tile")
	List<TileDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM tile LIMIT #{size} OFFSET #{offset}")
	List<TileDto> selectPagedTiles(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM tile")
	int getTotalTileCount() throws DataAccessException;


}
