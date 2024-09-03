package com.example.AurayStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/tile") 
@RequiredArgsConstructor
public class TileController {
	
	@GetMapping("/tile")
	public String tile (Model model) {
		model.addAttribute("tile", "타일") ;
		return "product/tile/tile" ;
	}
	
	// 타일 - 내추럴
    @GetMapping("/natural")
    public String tileNatural(Model model) {
        model.addAttribute("title", "내추럴");
        return "product/tile/natural";
    }
    
    @GetMapping("/natural/1")
    public String tileNaturalProduct1(Model model) {
        model.addAttribute("title", "내추럴 제품 상세");
        return "product/tile/natural_1";
    }
 
    @GetMapping("/natural/2")
    public String tileNaturalProduct2(Model model) {
        model.addAttribute("title", "내추럴 제품 상세");
        return "product/tile/natural_2";
    }
    
    @GetMapping("/natural/3")
    public String tileNaturalProduct3(Model model) {
        model.addAttribute("title", "내추럴 제품 상세");
        return "product/tile/natural_3";
    }
    
    @GetMapping("/natural/4")
    public String tileNaturalProduct4(Model model) {
        model.addAttribute("title", "내추럴 제품 상세");
        return "product/tile/natural_4";
    }
    
	// 타일 - 모던
    @GetMapping("/modern")
    public String tileModern(Model model) {
        model.addAttribute("title", "모던");
        return "product/tile/modern";
    }

    @GetMapping("/modern/1")
    public String tileModernProduct1(Model model) {
        model.addAttribute("title", "모던 제품 상세");
        return "product/tile/modern_1";
    }
    
    @GetMapping("/modern/2")
    public String tileModernProduct2(Model model) {
        model.addAttribute("title", "모던 제품 상세");
        return "product/tile/modern_2";
    }
    
    @GetMapping("/modern/3")
    public String tileModernProduct3(Model model) {
        model.addAttribute("title", "모던 제품 상세");
        return "product/tile/modern_3";
    }
    
    @GetMapping("/modern/4")
    public String tileModernProduct4(Model model) {
        model.addAttribute("title", "모던 제품 상세");
        return "product/tile/modern_4";
    }
    
    @GetMapping("/modern/5")
    public String tileModernProduct5(Model model) {
        model.addAttribute("title", "모던 제품 상세");
        return "product/tile/modern_5";
    }
    
	// 타일 - 유니크
    @GetMapping("/unique")
    public String tileUnique(Model model) {
        model.addAttribute("title", "유니크");
        return "product/tile/unique";
    }
    
    @GetMapping("/unique/1")
    public String tileUniqueProduct1(Model model) {
        model.addAttribute("title", "유니크 제품 상세");
        return "product/tile/unique_1";
    }
    
    @GetMapping("/unique/2")
    public String tileUniqueProduct2(Model model) {
        model.addAttribute("title", "유니크 제품 상세");
        return "product/tile/unique_2";
    }
    
    @GetMapping("/unique/3")
    public String tileUniqueProduct3(Model model) {
        model.addAttribute("title", "유니크 제품 상세");
        return "product/tile/unique_3";
    }
    
    @GetMapping("/unique/4")
    public String tileUniqueProduct4(Model model) {
        model.addAttribute("title", "유니크 제품 상세");
        return "product/tile/unique_4";
    }
}
