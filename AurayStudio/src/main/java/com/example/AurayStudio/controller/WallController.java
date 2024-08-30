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

	// 스타일월 - Acacia
	@GetMapping("/style/acacia")
	public String wallStyleAcacia(Model model) {
		model.addAttribute("title", "acacia");
		return "product/wall/style/acacia";
	}

	// 스타일월 - Soft Oak
	@GetMapping("/style/softoak")
	public String wallStyleSoftOak(Model model) {
		model.addAttribute("title", "softoak");
		return "product/wall/style/softoak";
	}

	// 스타일월 - Wood Noir
	@GetMapping("/style/woodnoir")
	public String wallStyleWoodNoir(Model model) {
		model.addAttribute("title", "woodnoir");
		return "product/wall/style/woodnoir";
	}

	// 스타일월 - Ekaterina
	@GetMapping("/style/ekaterina")
	public String wallStyleEkaterina(Model model) {
		model.addAttribute("title", "ekaterina");
		return "product/wall/style/ekaterina";
	}
	
	// 스타일월 - Milky Breeze
	@GetMapping("/style/milkybreeze")
	public String wallStyleMilkyBreeze(Model model) {
		model.addAttribute("title", "milkybreeze");
		return "product/wall/style/milkybreeze";
	}
	
	// 스타일월 - Rone Light
	@GetMapping("/style/ronelight")
	public String wallStyleRoneLight(Model model) {
		model.addAttribute("title", "ronelight");
		return "product/wall/style/ronelight";
	}
	
	// 스타일월 - Charcoal Stone
	@GetMapping("/style/charcoalstone")
	public String wallStyleCharcoalStone(Model model) {
		model.addAttribute("title", "charcoalstone");
		return "product/wall/style/charcoalstone";
	}

	// 스타일월 - Colosseo Brown
	@GetMapping("/style/colosseobrown")
	public String wallStyleColosseoBrown(Model model) {
		model.addAttribute("title", "colosseobrown");
		return "product/wall/style/colosseobrown";
	}
	
	// 스타일월 - Matte Marmo
	@GetMapping("/style/mattemarmo")
	public String wallStyleMatteMarmo(Model model) {
		model.addAttribute("title", "mattemarmo");
		return "product/wall/style/mattemarmo";
	}

	// 스타일월 - Urban Grey
	@GetMapping("/style/urbangrey")
	public String wallStyleUrbanGrey(Model model) {
		model.addAttribute("title", "urbangrey");
		return "product/wall/style/urbangrey";
	}
	
	// 스타일월 - Sugar Marble
	@GetMapping("/style/sugarmarble")
	public String wallStyleSugarMarble(Model model) {
		model.addAttribute("title", "sugarmarble");
		return "product/wall/style/sugarmarble";
	}

	// wall - 월판넬
	@GetMapping("/panel")
	public String wallpanel(Model model) {
		model.addAttribute("title", "일반창");
		return "product/wall/panel";
	}

}
