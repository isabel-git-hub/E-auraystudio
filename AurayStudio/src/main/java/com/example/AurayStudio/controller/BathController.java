package com.example.AurayStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/bath") 
@RequiredArgsConstructor
public class BathController {
	
	@GetMapping("/bath")
	public String bath (Model model) {
		model.addAttribute("bath", "바스") ;
		return "product/bath/bath" ;
	}
	
	// 바스 - 에센셜
	@GetMapping("/essential")
	public String bathEssential(Model model) {
	    model.addAttribute("title", "에센셜");
	    return "product/bath/essential";
	}
	
	@GetMapping("/essential/1")
	public String bathEssentialProduct1(Model model) {
		model.addAttribute("title", "에센셜 제품 상세");
		return "product/bath/essential_1";
	}

	@GetMapping("/essential/2")
	public String bathEssentialProduct2(Model model) {
		model.addAttribute("title", "에센셜 제품 상세");
		return "product/bath/essential_2";
	}

	@GetMapping("/essential/3")
	public String bathEssentialProduct3(Model model) {
		model.addAttribute("title", "에센셜 제품 상세");
		return "product/bath/essential_3";
	}
	
	@GetMapping("/essential/4")
	public String bathEssentialProduct4(Model model) {
		model.addAttribute("title", "에센셜 제품 상세");
		return "product/bath/essential_4";
	}
	
	@GetMapping("/essential/5")
	public String bathEssentialProduct5(Model model) {
		model.addAttribute("title", "에센셜 제품 상세");
		return "product/bath/essential_5";
	}
	
	@GetMapping("/essential/6")
	public String bathEssentialProduct6(Model model) {
		model.addAttribute("title", "에센셜 제품 상세");
		return "product/bath/essential_6";
	}
	
	@GetMapping("/essential/7")
	public String bathEssentialProduct7(Model model) {
		model.addAttribute("title", "에센셜 제품 상세");
		return "product/bath/essential_7";
	}
	
	@GetMapping("/essential/8")
	public String bathEssentialProduct8(Model model) {
		model.addAttribute("title", "에센셜 제품 상세");
		return "product/bath/essential_8";
	}

	// 바스 - 타임리스
	@GetMapping("/timeless")
	public String bathTimeless(Model model) {
	    model.addAttribute("title", "타임리스");
	    return "product/bath/timeless";
	}
	
	@GetMapping("/timeless/1")
	public String bathTimelessProduct1(Model model) {
		model.addAttribute("title", "타임리스 제품 상세");
		return "product/bath/timeless_1";
	}
	
	@GetMapping("/timeless/2")
	public String bathTimelessProduct2(Model model) {
		model.addAttribute("title", "타임리스 제품 상세");
		return "product/bath/timeless_2";
	}
	
	@GetMapping("/timeless/3")
	public String bathTimelessProduct3(Model model) {
		model.addAttribute("title", "타임리스 제품 상세");
		return "product/bath/timeless_3";
	}
	
	// 바스 - 구성기기
	@GetMapping("/fixtures")
	public String bathFixtures(Model model) {
	    model.addAttribute("title", "구성기기");
	    return "product/bath/fixtures";
	}

	@GetMapping("/fixtures/1")
	public String bathFixturesProduct1(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_1";
	}
	
	@GetMapping("/fixtures/2")
	public String bathFixturesProduct2(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_2";
	}
	
	@GetMapping("/fixtures/3")
	public String bathFixturesProduct3(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_3";
	}
	
	@GetMapping("/fixtures/4")
	public String bathFixturesProduct4(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_4";
	}
	
	@GetMapping("/fixtures/5")
	public String bathFixturesProduct5(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_5";
	}

	@GetMapping("/fixtures/6")
	public String bathFixturesProduct6(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_6";
	}
	
	@GetMapping("/fixtures/7")
	public String bathFixturesProduct7(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_7";
	}
	
	@GetMapping("/fixtures/8")
	public String bathFixturesProduct8(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_8";
	}
	
	@GetMapping("/fixtures/9")
	public String bathFixturesProduct9(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_9";
	}
	
	@GetMapping("/fixtures/10")
	public String bathFixturesProduct10(Model model) {
		model.addAttribute("title", "구성기기 제품 상세");
		return "product/bath/fixtures_10";
	}
}
