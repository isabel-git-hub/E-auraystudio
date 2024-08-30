package com.example.AurayStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/wall")
@RequiredArgsConstructor
public class WallController {

	@GetMapping("/wall")
	public String wall(Model model) {
		model.addAttribute("wall", "월");
		return "product/wall/wall";
	}

	// wall - 스타일월
	@GetMapping("/style")
	public String wallstyle(Model model) {
		model.addAttribute("title", "스타일월");
		return "product/wall/style";
	}
	
	// 스타일월 - Marble
	@GetMapping("/style/marble/1")
	public String wallStyleMarble1(Model model) {
		model.addAttribute("title", "마블 제품 상세");
		return "product/wall/style/marble_1";
	}

	// 스타일월 - Marble
	@GetMapping("/style/marble/2")
	public String wallStyleMarble2(Model model) {
		model.addAttribute("title", "마블 제품 상세");
		return "product/wall/style/marble_2";
	}

	// 스타일월 - Marble
	@GetMapping("/style/marble/3")
	public String wallStyleMarble3(Model model) {
		model.addAttribute("title", "마블 제품 상세");
		return "product/wall/style/marble_3";
	}

	// 스타일월 - Wood
	@GetMapping("/style/wood/1")
	public String wallStyleWood1(Model model) {
		model.addAttribute("title", "우드 제품 상세");
		return "product/wall/style/wood_1";
	}
	
	// 스타일월 - Wood
	@GetMapping("/style/wood/2")
	public String wallStyleWood2(Model model) {
		model.addAttribute("title", "우드 제품 상세");
		return "product/wall/style/wood_2";
	}

	// 스타일월 - Wood
	@GetMapping("/style/wood/3")
	public String wallStyleWood3(Model model) {
		model.addAttribute("title", "우드 제품 상세");
		return "product/wall/style/wood_3";
	}
	
	// 스타일월 - Etc
	@GetMapping("/style/etc/1")
	public String wallStyleEtc1(Model model) {
		model.addAttribute("title", "기타 제품 상세");
		return "product/wall/style/etc_1";
	}

	// 스타일월 - Etc
	@GetMapping("/style/etc/2")
	public String wallStyleEtc2(Model model) {
		model.addAttribute("title", "기타 제품 상세");
		return "product/wall/style/etc_2";
	}
	
	// wall - 월판넬
	@GetMapping("/panel")
	public String wallpanel(Model model) {
		model.addAttribute("title", "월판넬");
		return "product/wall/panel";
	}

	// 스타일월 - Wall-system
	@GetMapping("/panel/wall-system/1")
	public String wallPanelWallsystem1(Model model) {
		model.addAttribute("title", "월시스템 제품 상세");
		return "product/wall/panel/wall-system_1";
	}
	
	// 스타일월 - Wall-system
	@GetMapping("/panel/wall-system/2")
	public String wallPanelWallsystem2(Model model) {
		model.addAttribute("title", "월시스템 제품 상세");
		return "product/wall/panel/wall-system_2";
	}
	
	// 스타일월 - Wall-system
	@GetMapping("/panel/wall-system/3")
	public String wallPanelWallsystem3(Model model) {
		model.addAttribute("title", "월시스템 제품 상세");
		return "product/wall/panel/wall-system_3";
	}
	
	// 스타일월 - Tamba
	@GetMapping("/panel/tamba/1")
	public String wallPanelTamba1(Model model) {
		model.addAttribute("title", "템바 제품 상세");
		return "product/wall/panel/tamba_1";
	}
	
	// 스타일월 - Tamba
	@GetMapping("/panel/tamba/2")
	public String wallPanelTamba2(Model model) {
		model.addAttribute("title", "템바 제품 상세");
		return "product/wall/panel/tamba_2";
	}	
	
	// 스타일월 - Board
	@GetMapping("/panel/board/1")
	public String wallPanelBoard1(Model model) {
		model.addAttribute("title", "디자인보드 제품 상세");
		return "product/wall/panel/board_1";
	}	
	
	// 스타일월 - Classic
	@GetMapping("/panel/classic/1")
	public String wallPanelClassic1(Model model) {
		model.addAttribute("title", "클래식월 제품 상세");
		return "product/wall/panel/classic_1";
	}	
	
	// 스타일월 - Shelf
	@GetMapping("/panel/shelf/1")
	public String wallPanelShelf1(Model model) {
		model.addAttribute("title", "벽선반 제품 상세");
		return "product/wall/panel/shelf_1";
	}	
	
	// 스타일월 - Shelf
	@GetMapping("/panel/shelf/2")
	public String wallPanelShelf2(Model model) {
		model.addAttribute("title", "벽선반 제품 상세");
		return "product/wall/panel/shelf_2";
	}
	
	// 스타일월 - Shelf
	@GetMapping("/panel/shelf/3")
	public String wallPanelShelf3(Model model) {
		model.addAttribute("title", "벽선반 제품 상세");
		return "product/wall/panel/shelf_3";
	}	
	
	// 스타일월 - Shelf
	@GetMapping("/panel/shelf/4")
	public String wallPanelShelf4(Model model) {
		model.addAttribute("title", "벽선반 제품 상세");
		return "product/wall/panel/shelf_4";
	}		
	
	// 스타일월 - Art
	@GetMapping("/panel/art/1")
	public String wallPanelArt1(Model model) {
		model.addAttribute("title", "아트월 제품 상세");
		return "product/wall/panel/art_1";
	}
	
}
