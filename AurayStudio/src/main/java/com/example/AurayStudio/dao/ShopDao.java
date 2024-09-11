package com.example.AurayStudio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.AurayStudio.dto.ShopDto;

@Mapper
public interface ShopDao {

	@Select("SELECT id, shop, lat, lng, description FROM shop")
    List<ShopDto> getAllShop();
}
