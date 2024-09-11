package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.AurayStudio.dto.PaintDto;

@Mapper
public interface PaintDao {

	@Select("select * from paint where y_no = #{y_no}")
	PaintDto findByYNo(String yNo) ;
	
	@Select("SELECT y_no, p_name, pro_kind, y_img FROM paint WHERE pro_kind = #{kKind}")
	List<PaintDto> getPaintsByKKind(String kKind) ;
}
