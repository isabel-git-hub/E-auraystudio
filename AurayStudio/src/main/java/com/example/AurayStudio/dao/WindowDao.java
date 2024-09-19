package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.WindowDto;

@Mapper
public interface WindowDao {

	@Select("select * from `window`")
	List<WindowDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM `window` LIMIT #{size} OFFSET #{offset}")
	List<WindowDto> selectPagedWindows(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM `window`")
	int getTotalWindowCount() throws DataAccessException;

}
