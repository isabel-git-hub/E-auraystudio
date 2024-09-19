package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.FilmDto;

@Mapper
public interface FilmDao {

	@Select("select * from film")
	List<FilmDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM film LIMIT #{size} OFFSET #{offset}")
	List<FilmDto> selectPagedFilms(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM film")
	int getTotalFilmCount() throws DataAccessException;


}
