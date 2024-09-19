package com.example.AurayStudio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.DoorDto;

@Mapper
public interface DoorDao {
	
	@Select("select * from door where y_no=#{y_no}")
	DoorDto findByYNo(String yNo);
	
	@Select("SELECT y_no, d_name, style, pro_kind, y_img FROM door WHERE pro_kind = #{kKind}")
    List<DoorDto> getDoorsByKKind(String kKind);

	@Select("select * from door")
	List<DoorDto> findAll() throws DataAccessException;

	@Select("SELECT * FROM door LIMIT #{size} OFFSET #{offset}")
	List<DoorDto> selectPagedDoors(@Param("size") int size, @Param("offset") int offset) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM door")
	int getTotalDoorCount() throws DataAccessException;
}
