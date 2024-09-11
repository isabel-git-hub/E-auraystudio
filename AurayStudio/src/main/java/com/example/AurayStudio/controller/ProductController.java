package com.example.AurayStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product") 
@RequiredArgsConstructor
public class ProductController {
	
//	@Autowired
//	private ProductService Productservice ;
	
	// 제품보기
	@GetMapping("")
	public String product (Model model) {
		model.addAttribute("product", "제품보기") ;
		return "product" ;
	}
	
	// 키친
	@GetMapping("/kitchen")
	public String kitchen (Model model) {
		model.addAttribute("kitchen", "키친") ;
		return "product/kitchen" ;
	}
	
	// 붙박이장
	@GetMapping("/built_in")
	public String built_in (Model model) {
		model.addAttribute("built_in", "붙박이장") ;
		return "product/built_in" ;
	}
	
	// 바스
	@GetMapping("/bath")
	public String bath (Model model) {
		model.addAttribute("bath", "바스") ;
		return "product/bath" ;
	}
	
	// 타일
	@GetMapping("/tile")
	public String tile (Model model) {
		model.addAttribute("tile", "타일") ;
		return "product/tile" ;
	}
	
	// 도어
	@GetMapping("/door")
	public String door (Model model) {
		model.addAttribute("door", "도어") ;
		return "product/door" ;
	}
	
	// 중문
	@GetMapping("/innergate")
	public String innergate (Model model) {
		model.addAttribute("innergate", "중문") ;
		return "product/innergate" ;
	}
	
	// 창호
	@GetMapping("/window")
	public String window (Model model) {
		model.addAttribute("window", "창호") ;
		return "product/window" ;
	}
	
	// 몰딩
	@GetMapping("/moulding")
	public String moulding (Model model) {
		model.addAttribute("moulding", "몰딩") ;
		return "product/moulding" ;
	}
	
	// wall
	@GetMapping("/wall")
	public String wall (Model model) {
		model.addAttribute("wall", "wall") ;
		return "product/wall" ;
	}
	
	// 바닥재
	@GetMapping("/flooring")
	public String flooring (Model model) {
		model.addAttribute("flooring", "바닥재") ;
		return "product/flooring" ;
	}
	
	// 필름
	@GetMapping("/film")
	public String film (Model model) {
		model.addAttribute("film", "필름") ;
		return "product/film" ;
	}
	
	// 벽지
	@GetMapping("/wallpaper")
	public String wallpaper (Model model) {
		model.addAttribute("wallpaper", "벽지") ;
		return "product/wallpaper" ;
	}
	
	// 페인트
	@GetMapping("/paint")
	public String paint (Model model) {
		model.addAttribute("paint", "페인트") ;
		return "product/paint" ;
	}
	
	// 단열재
	@GetMapping("/insulation")
	public String insulation (Model model) {
		model.addAttribute("insulation", "단열재") ;
		return "product/insulation" ;
	}
	
}
