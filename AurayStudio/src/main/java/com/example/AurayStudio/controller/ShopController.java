//package com.example.AurayStudio.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.AurayStudio.dto.ShopDto;
//import com.example.AurayStudio.service.ShopService;
//
//@RestController
//public class ShopController {
//
//    @Autowired
//    private ShopService shopService;
//
//	@GetMapping("/api/shops")  // 이 엔드포인트는 JSON 데이터를 반환
//    public List<ShopDto> getAllShops() {
//        return shopService.getAllShops();  // 데이터를 JSON으로 반환
//    }
//}
