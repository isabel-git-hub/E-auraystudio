package com.example.AurayStudio.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.AurayStudio.dto.DoorDto;
import com.example.AurayStudio.dto.KitchenDto;
import com.example.AurayStudio.dto.WallpaperDto;

@Mapper
public interface WallpaperDao {
	
	@Select("select * from wallpaper where y_no=#{y_no}")
	WallpaperDto findByYNo(String yNo);
	
	@Select("SELECT y_no, w_name, pro_kind, y_img, content FROM wallpaper WHERE pro_kind = #{kKind}")
    List<WallpaperDto> getWallpapersByKKind(String kKind);
}
