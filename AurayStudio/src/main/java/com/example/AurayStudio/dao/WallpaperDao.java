package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.WallpaperDto;

@Mapper
public interface WallpaperDao {
	
	@Select("select * from wallpaper where y_no=#{y_no}")
	WallpaperDto findByYNo(String yNo);
	
	@Select("SELECT y_no, w_name, pro_kind, y_img, content FROM wallpaper WHERE pro_kind = #{kKind}")
    List<WallpaperDto> getWallpapersByKKind(String kKind);

	@Select("select * from wallpaper")
	List<WallpaperDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM wallpaper LIMIT #{size} OFFSET #{offset}")
	List<WallpaperDto> selectPagedWallpapers(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM wallpaper")
	int getTotalWallpaperCount() throws DataAccessException;
}
