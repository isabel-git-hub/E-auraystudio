package com.example.AurayStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/window") 
@RequiredArgsConstructor
public class WindowController {
	
	@GetMapping("/window")
	public String window (Model model) {
		model.addAttribute("window", "창호") ;
		return "product/window/window" ;
	}
	
	// 창호 - 시스템창
	@GetMapping("/system")
	public String windowSystem(Model model) {
	    model.addAttribute("title", "시스템창");
	    return "product/window/system";
	}

	// 시스템창 - Tilt-turn
    @GetMapping("/system/tilt-turn")
    public String windowSystemTitTurn(Model model) {
        model.addAttribute("title", "Tilt-turn");
        return "product/window/system/tilt-turn";
    }

    // 시스템창 - Lift&Slide
    @GetMapping("/system/lift-slide")
    public String windowSystemLiftSlide(Model model) {
        model.addAttribute("title", "Lift&Slide");
        return "product/window/system/lift-slide";
    }

    // 시스템창 - Door
    @GetMapping("/system/door")
    public String windowSystemDoor(Model model) {
        model.addAttribute("title", "Door");
        return "product/window/system/door";
    }
    
	// 창호 - 일반창
	@GetMapping("/general")
	public String windowGeneral(Model model) {
	    model.addAttribute("title", "일반창");
	    return "product/window/general";
	}


}
