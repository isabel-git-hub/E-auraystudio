package com.example.AurayStudio.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.AurayStudio.dto.DoorDto;
import com.example.AurayStudio.dto.KitchenDto;

@Mapper
public interface DoorDao {
	
	@Select("select * from door where y_no=#{y_no}")
	DoorDto findByYNo(String yNo);
	
	@Select("SELECT y_no, d_name, style, pro_kind, y_img FROM door WHERE pro_kind = #{kKind}")
    List<DoorDto> getDoorsByKKind(String kKind);
}
