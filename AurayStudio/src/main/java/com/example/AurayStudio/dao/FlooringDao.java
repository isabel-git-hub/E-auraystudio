package com.example.AurayStudio.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.AurayStudio.dto.DoorDto;
import com.example.AurayStudio.dto.FlooringDto;
import com.example.AurayStudio.dto.KitchenDto;
import com.example.AurayStudio.dto.WallpaperDto;

@Mapper
public interface FlooringDao {
	
	@Select("select * from flooring where y_no=#{y_no}")
	FlooringDto findByYNo(String yNo);
	
	@Select("SELECT y_no, f_name, pro_kind, y_img, content FROM flooring WHERE pro_kind = #{kKind}")
    List<FlooringDto> getFlooringsByKKind(String kKind);
}
