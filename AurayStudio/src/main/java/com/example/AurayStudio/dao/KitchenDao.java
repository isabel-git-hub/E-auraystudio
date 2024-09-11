package com.example.AurayStudio.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.AurayStudio.dto.KitchenDto;

@Mapper
public interface KitchenDao {
	
	@Select("select * from kitchen where y_no=#{y_no}")
	KitchenDto findByYNo(String yNo);
	
	@Select("SELECT y_no, k_name, pro_kind, k_kind, y_img FROM kitchen WHERE k_kind = #{kKind}")
    List<KitchenDto> getKitchensByKKind(String kKind);

	@Select("SELECT y_no, k_name, pro_kind, k_kind, y_img FROM kitchen WHERE pro_kind = #{kKind}")
	List<KitchenDto> getKitchensByPKind(String pKind);
}
