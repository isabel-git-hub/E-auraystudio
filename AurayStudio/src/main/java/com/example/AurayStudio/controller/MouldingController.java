package com.example.AurayStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/moulding") 
@RequiredArgsConstructor
public class MouldingController {
	
	@GetMapping("/moulding")
	public String moulding (Model model) {
		model.addAttribute("moulding", "몰딩") ;
		return "product/moulding/moulding" ;
	}
	
	// 몰딩 - 히든 몰딩
    @GetMapping("/hidden")
    public String mouldingHidden(Model model) {
        model.addAttribute("title", "히든 몰딩");
        return "product/moulding/hidden";
    }
    
    @GetMapping("/hidden/1")
    public String mouldingHiddenProduct1(Model model) {
        model.addAttribute("title", "히든 몰딩 제품 상세");
        return "product/moulding/hidden_1";
    }
    
    // 몰딩 - 평몰딩
    @GetMapping("/flat")
    public String mouldingFlat(Model model) {
        model.addAttribute("title", "평몰딩");
        return "product/moulding/flat";
    }
    
    // 몰딩 - 평몰딩
    @GetMapping("/flat/1")
    public String mouldingFlatProduct1(Model model) {
        model.addAttribute("title", "평몰딩 제품 상세");
        return "product/moulding/flat_1";
    }    

    // 몰딩 - 마이너스 몰딩
    @GetMapping("/minus")
    public String mouldingMinus(Model model) {
        model.addAttribute("title", "마이너스 몰딩");
        return "product/moulding/minus";
    }
    
    // 몰딩 - 마이너스 몰딩
    @GetMapping("/minus/1")
    public String mouldingMinusProduct1(Model model) {
        model.addAttribute("title", "마이너스 몰딩 제품 상세");
        return "product/moulding/minus_1";
    }    

    // 몰딩 - 천장 몰딩
    @GetMapping("/ceiling")
    public String mouldingCeiling(Model model) {
        model.addAttribute("title", "천장 몰딩");
        return "product/moulding/ceiling";
    }
    
    // 몰딩 - 천장 몰딩
    @GetMapping("/ceiling/1")
    public String mouldingCeilingProduct1(Model model) {
        model.addAttribute("title", "천장 몰딩 제품 상세");
        return "product/moulding/ceiling_1";
    }

    // 몰딩 - 걸레받이
    @GetMapping("/baseboard")
    public String mouldingBaseboard(Model model) {
        model.addAttribute("title", "걸레받이");
        return "product/moulding/baseboard";
    }

	// 몰딩 - 걸레받이
	@GetMapping("/baseboard/1")
	public String mouldingBaseboardProduct1(Model model) {
		model.addAttribute("title", "걸레받이 제품 상세");
		return "product/moulding/baseboard_1";
	}

    // 몰딩 - 계단 몰딩
    @GetMapping("/stair")
    public String mouldingStair(Model model) {
        model.addAttribute("title", "계단 몰딩");
        return "product/moulding/stair";
    }

    // 몰딩 - 계단 몰딩
    @GetMapping("/stair/1")
    public String mouldingStairProduct1(Model model) {
        model.addAttribute("title", "계단 몰딩 제품 상세 ");
        return "product/moulding/stair_1";
    }    
}
