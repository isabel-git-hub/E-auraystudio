package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.MouldingDto;

@Mapper
public interface MouldingDao {

	@Select("select * from moulding")
	List<MouldingDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM moulding LIMIT #{size} OFFSET #{offset}")
	List<MouldingDto> selectPagedMouldings(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM moulding")
	int getTotalMouldingCount() throws DataAccessException;

}
