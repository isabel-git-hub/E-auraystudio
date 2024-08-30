package com.example.AurayStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/film") 
@RequiredArgsConstructor
public class FilmController {
	
	@GetMapping("/film")
	public String film (Model model) {
		model.addAttribute("film", "필름") ;
		return "product/film/film" ;
	}
	
	// 필름 - 솔리드
    @GetMapping("/solid")
    public String filmSolid(Model model) {
        model.addAttribute("title", "솔리드");
        return "product/film/solid";
    }
    
    @GetMapping("/solid/1")
    public String filmSolidProduct1(Model model) {
        model.addAttribute("title", "솔리드 제품 상세");
        return "product/film/solid_product1";
    }
    
    @GetMapping("/solid/2")
    public String filmSolidProduct2(Model model) {
        model.addAttribute("title", "솔리드 제품 상세");
        return "product/film/solid_product2";
    }
    
    @GetMapping("/solid/3")
    public String filmSolidProduct3(Model model) {
        model.addAttribute("title", "솔리드 제품 상세");
        return "product/film/solid_product3";
    }
    
    @GetMapping("/solid/4")
    public String filmSolidProduct4(Model model) {
        model.addAttribute("title", "솔리드 제품 상세");
        return "product/film/solid_product4";
    }
    
    @GetMapping("/solid/5")
    public String filmSolidProduct5(Model model) {
        model.addAttribute("title", "솔리드 제품 상세");
        return "product/film/solid_product5";
    }
    
    @GetMapping("/solid/6")
    public String filmSolidProduct6(Model model) {
        model.addAttribute("title", "솔리드 제품 상세");
        return "product/film/solid_product6";
    }
    
    @GetMapping("/solid/7")
    public String filmSolidProduct7(Model model) {
        model.addAttribute("title", "솔리드 제품 상세");
        return "product/film/solid_product7";
    }
    
    @GetMapping("/solid/8")
    public String filmSolidProduct8(Model model) {
        model.addAttribute("title", "솔리드 제품 상세");
        return "product/film/solid_product8";
    }

    // 필름 - 메탈
    @GetMapping("/metal")
    public String filmMetal(Model model) {
        model.addAttribute("title", "메탈");
        return "product/film/metal";
    }
    
    @GetMapping("/metal/1")
    public String filmMetalProduct1(Model model) {
        model.addAttribute("title", "메탈 제품 상세");
        return "product/film/metal_product1";
    }

    @GetMapping("/metal/2")
    public String filmMetalProduct2(Model model) {
        model.addAttribute("title", "메탈 제품 상세");
        return "product/film/metal_product2";
    }
    
    @GetMapping("/metal/3")
    public String filmMetalProduct3(Model model) {
        model.addAttribute("title", "메탈 제품 상세");
        return "product/film/metal_product3";
    }
    
    @GetMapping("/metal/4")
    public String filmMetalProduct4(Model model) {
        model.addAttribute("title", "메탈 제품 상세");
        return "product/film/metal_product4";
    }
    
    
    @GetMapping("/metal/5")
    public String filmMetalProduct5(Model model) {
        model.addAttribute("title", "메탈 제품 상세");
        return "product/film/metal_product5";
    }
    
    @GetMapping("/metal/6")
    public String filmMetalProduct6(Model model) {
        model.addAttribute("title", "메탈 제품 상세");
        return "product/film/metal_product6";
    }
    
    @GetMapping("/metal/7")
    public String filmMetalProduct7(Model model) {
        model.addAttribute("title", "메탈 제품 상세");
        return "product/film/metal_product7";
    }
    
    @GetMapping("/metal/8")
    public String filmMetalProduct8(Model model) {
        model.addAttribute("title", "메탈 제품 상세");
        return "product/film/metal_product8";
    }
    
    // 필름 - 우드
    @GetMapping("/wood")
    public String filmWood(Model model) {
        model.addAttribute("title", "우드");
        return "product/film/wood";
    }
    
    @GetMapping("/wood/1")
    public String filmWoodProduct1(Model model) {
        model.addAttribute("title", "우드 제품 상세");
        return "product/film/wood_product1";
    }
    
    @GetMapping("/wood/2")
    public String filmWoodProduct2(Model model) {
        model.addAttribute("title", "우드 제품 상세");
        return "product/film/wood_product2";
    }
    
    @GetMapping("/wood/3")
    public String filmWoodProduct3(Model model) {
        model.addAttribute("title", "우드 제품 상세");
        return "product/film/wood_product3";
    }
    
    @GetMapping("/wood/4")
    public String filmWoodProduct4(Model model) {
        model.addAttribute("title", "우드 제품 상세");
        return "product/film/wood_product4";
    }
    
    @GetMapping("/wood/5")
    public String filmWoodProduct5(Model model) {
        model.addAttribute("title", "우드 제품 상세");
        return "product/film/wood_product5";
    }
    
    @GetMapping("/wood/6")
    public String filmWoodProduct6(Model model) {
        model.addAttribute("title", "우드 제품 상세");
        return "product/film/wood_product6";
    }
    
    @GetMapping("/wood/7")
    public String filmWoodProduct7(Model model) {
        model.addAttribute("title", "우드 제품 상세");
        return "product/film/wood_product7";
    }
    
    @GetMapping("/wood/8")
    public String filmWoodProduct8(Model model) {
        model.addAttribute("title", "우드 제품 상세");
        return "product/film/wood_product8";
    }

    
    // 필름 - 스톤
    @GetMapping("/stone")
    public String filmStone(Model model) {
        model.addAttribute("title", "스톤");
        return "product/film/stone";
    }
    
    @GetMapping("/stone/1")
    public String filmStoneProduct1(Model model) {
        model.addAttribute("title", "스톤 제품 상세");
        return "product/film/stone_product1";
    }
    
    @GetMapping("/stone/2")
    public String filmStoneProduct2(Model model) {
        model.addAttribute("title", "스톤 제품 상세");
        return "product/film/stone_product2";
    }
    
    @GetMapping("/stone/3")
    public String filmStoneProduct3(Model model) {
        model.addAttribute("title", "스톤 제품 상세");
        return "product/film/stone_product3";
    }
    
    @GetMapping("/stone/4")
    public String filmStoneProduct4(Model model) {
        model.addAttribute("title", "스톤 제품 상세");
        return "product/film/stone_product4";
    }
    
    @GetMapping("/stone/5")
    public String filmStoneProduct5(Model model) {
        model.addAttribute("title", "스톤 제품 상세");
        return "product/film/stone_product5";
    }
    
    @GetMapping("/stone/6")
    public String filmStoneProduct6(Model model) {
        model.addAttribute("title", "스톤 제품 상세");
        return "product/film/stone_product6";
    }
    
    @GetMapping("/stone/7")
    public String filmStoneProduct7(Model model) {
        model.addAttribute("title", "스톤 제품 상세");
        return "product/film/stone_product7";
    }
    
    @GetMapping("/stone/8")
    public String filmStoneProduct8(Model model) {
        model.addAttribute("title", "스톤 제품 상세");
        return "product/film/stone_product8";
    }

    // 필름 - 텍스타일
    @GetMapping("/textile")
    public String filmTextile(Model model) {
        model.addAttribute("title", "텍스타일");
        return "product/film/textile";
    }
    
    @GetMapping("/textile/1")
    public String filmTextileProduct1(Model model) {
        model.addAttribute("title", "텍스타일 제품 상세");
        return "product/film/textile_product1";
    }
    
    @GetMapping("/textile/2")
    public String filmTextileProduct2(Model model) {
        model.addAttribute("title", "텍스타일 제품 상세");
        return "product/film/textile_product2";
    }
    
    @GetMapping("/textile/3")
    public String filmTextileProduct3(Model model) {
        model.addAttribute("title", "텍스타일 제품 상세");
        return "product/film/textile_product3";
    }
    
    @GetMapping("/textile/4")
    public String filmTextileProduct4(Model model) {
        model.addAttribute("title", "텍스타일 제품 상세");
        return "product/film/textile_product4";
    }

    @GetMapping("/textile/5")
    public String filmTextileProduct5(Model model) {
        model.addAttribute("title", "텍스타일 제품 상세");
        return "product/film/textile_product5";
    }
    
    @GetMapping("/textile/6")
    public String filmTextileProduct6(Model model) {
        model.addAttribute("title", "텍스타일 제품 상세");
        return "product/film/textile_product6";
    }
    
    @GetMapping("/textile/7")
    public String filmTextileProduct7(Model model) {
        model.addAttribute("title", "텍스타일 제품 상세");
        return "product/film/textile_product7";
    }
    
    @GetMapping("/textile/8")
    public String filmTextileProduct8(Model model) {
        model.addAttribute("title", "텍스타일 제품 상세");
        return "product/film/textile_product8";
    }
    
    // 필름 - 레더
    @GetMapping("/leather")
    public String filmLeather(Model model) {
        model.addAttribute("title", "레더");
        return "product/film/leather";
    }
    
    @GetMapping("/leather/1")
    public String filmLeatherProduct1(Model model) {
        model.addAttribute("title", "레더 제품 상세");
        return "product/film/leather_product1";
    }
    
    @GetMapping("/leather/2")
    public String filmLeatherProduct2(Model model) {
        model.addAttribute("title", "레더 제품 상세");
        return "product/film/leather_product2";
    }
    
    @GetMapping("/leather/3")
    public String filmLeatherProduct3(Model model) {
        model.addAttribute("title", "레더 제품 상세");
        return "product/film/leather_product3";
    }
    
    @GetMapping("/leather/4")
    public String filmLeatherProduct4(Model model) {
        model.addAttribute("title", "레더 제품 상세");
        return "product/film/leather_product4";
    }
    
    @GetMapping("/leather/5")
    public String filmLeatherProduct5(Model model) {
        model.addAttribute("title", "레더 제품 상세");
        return "product/film/leather_product5";
    }
    
    @GetMapping("/leather/6")
    public String filmLeatherProduct6(Model model) {
        model.addAttribute("title", "레더 제품 상세");
        return "product/film/leather_product6";
    }
    
    @GetMapping("/leather/7")
    public String filmLeatherProduct7(Model model) {
        model.addAttribute("title", "레더 제품 상세");
        return "product/film/leather_product7";
    }
    
    @GetMapping("/leather/8")
    public String filmLeatherProduct8(Model model) {
        model.addAttribute("title", "레더 제품 상세");
        return "product/film/leather_product8";
    }

    // 필름 - 인테리어 보드
    @GetMapping("/interior-board")
    public String filmInteriorBoard(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board";
    }
    
    @GetMapping("/interior-board/1")
    public String filmInteriorBoardProduct1(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board_product1";
    }
    
    @GetMapping("/interior-board/2")
    public String filmInteriorBoardProduct2(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board_product2";
    }
    
    @GetMapping("/interior-board/3")
    public String filmInteriorBoardProduct3(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board_product3";
    }
    
    @GetMapping("/interior-board/4")
    public String filmInteriorBoardProduct4(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board_product4";
    }
    
    @GetMapping("/interior-board/5")
    public String filmInteriorBoardProduct5(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board_product5";
    }
    
    @GetMapping("/interior-board/6")
    public String filmInteriorBoardProduct6(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board_product6";
    }
    
    @GetMapping("/interior-board/7")
    public String filmInteriorBoardProduct7(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board_product7";
    }
    
    @GetMapping("/interior-board/8")
    public String filmInteriorBoardProduct8(Model model) {
        model.addAttribute("title", "인테리어 보드");
        return "product/film/interior-board_product8";
    }
}
