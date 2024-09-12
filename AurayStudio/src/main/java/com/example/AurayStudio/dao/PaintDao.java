package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.ImgmngDto;
import com.example.AurayStudio.dto.PaintDto;

@Mapper
public interface PaintDao {

	@Select("select * from paint where y_no = #{y_no}")
	PaintDto findByYNo(String yNo) ;
	
	@Select("SELECT y_no, p_name, pro_kind, y_img FROM paint WHERE pro_kind = #{kKind}")
	List<PaintDto> getPaintsByKKind(String kKind) throws DataAccessException;
	
	@Select("select * from paint")
	List<PaintDto> findAll() throws DataAccessException;
	
	@Insert("insert into paint ( y_no, p_name, pro_kind, y_img) values (#{y_no}, #{p_name}, #{pro_kind}, #{y_img})")
	int insertPaint(PaintDto paintDto) throws DataAccessException;

	@Delete("delete from paint where y_no = #{y_no}")
	int deletePaint(@Param("y_no") String y_no) throws DataAccessException;
	
	@Insert("insert into item_img values(null, #{file_name}, #{file_path}, #{y_no})")
	public void insertImg(ImgmngDto dto) throws DataAccessException;

	@Select("select * from item_img where y_no=#{y_no}")
	public ImgmngDto selectImgByY_no(@Param("y_no")String y_no) throws DataAccessException;
	
	@Select("select * from item_img where y_no=#{y_no}")
	public ImgmngDto selectImgById(@Param("y_no")String y_no) throws DataAccessException;
	
	@Select("select i.y_no, p.p_name, p.pro_kind, p.y_img from paint p "
			+ "join item_img i on p.y_no = i.y_no")
	List<PaintDto> selectPaintList() throws DataAccessException;
}
