package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.InnergateDto;

@Mapper
public interface InnergateDao {
	
	@Select("select * from innergate where y_no=#{y_no}")
	InnergateDto findByYNo(String yNo);
	
	@Select("SELECT y_no, i_name, content,  style, pro_kind, y_img FROM innergate WHERE pro_kind = #{kKind}")
	List<InnergateDto> getInnerByKKind(String kKind);
	
	@Insert("INSERT INTO innergate (y_no, pro_kind, content, i_name, style, y_img) " +
	        "VALUES (#{y_no}, #{pro_kind}, #{content}, #{i_name}, #{style}, #{y_img})")
	void insertInnergate(InnergateDto innergateDto);

	
	@Select("SELECT y_no FROM innergate ORDER BY CAST(SUBSTRING(y_no, 4) AS UNSIGNED) DESC LIMIT 1")
	String findLastYno();

	@Select("select * from innergate")
	List<InnergateDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM innergate LIMIT #{size} OFFSET #{offset}")
	List<InnergateDto> selectPagedInnergates(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM innergate")
	int getTotalInnergateCount() throws DataAccessException;

}
