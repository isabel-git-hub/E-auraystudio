package com.example.AurayStudio.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.AurayStudio.dto.Built_inDto;
import com.example.AurayStudio.dto.DoorDto;
import com.example.AurayStudio.dto.KitchenDto;

@Mapper
public interface Built_inDao {
	
	@Select("select * from built_in where y_no=#{y_no}")
	Built_inDto findByYNo(String yNo);
	
	@Select("SELECT y_no, b_name, style, pro_kind, y_img, content FROM built_in WHERE pro_kind = #{kKind}")
	List<Built_inDto> getBuilt_insByKKind(String kKind);
}
