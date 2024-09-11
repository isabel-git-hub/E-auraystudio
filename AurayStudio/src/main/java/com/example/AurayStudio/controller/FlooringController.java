package com.example.AurayStudio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AurayStudio.dto.FlooringDto;
import com.example.AurayStudio.service.FlooringService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/flooring")
@RequiredArgsConstructor
public class FlooringController {
	private final FlooringService flooringservice;

	// 원목마루
		@GetMapping("/wood")
		public String Wood(Model model) {
			List<FlooringDto> floorings = flooringservice.getFlooringsByKKind("원목마루");
			model.addAttribute("floorings", floorings);
			return "product/flooring/wood";
		}

		@GetMapping("/wood/{y_no}")
		public String Woodpage(@PathVariable("y_no") String y_no, Model model) {
		    model.addAttribute("flooringA", flooringservice.findByYNo(y_no));
		    return "product/flooring/wood/FA_product";
		}


		// 강마루
		@GetMapping("/gang")
		public String Gang(Model model) {
			List<FlooringDto> floorings = flooringservice.getFlooringsByKKind("강마루");
			model.addAttribute("floorings", floorings);
			return "product/flooring/gang";
		}
		
		@GetMapping("/gang/{y_no}")
		public String GangPage(@PathVariable("y_no") String y_no, Model model) {
			model.addAttribute("flooringB", flooringservice.findByYNo(y_no));
			return "product/flooring/gang/FB_product";
		}

		// 시트
		@GetMapping("/sheet")
		public String Sheet(Model model) {
			List<FlooringDto> floorings = flooringservice.getFlooringsByKKind("시트");
			model.addAttribute("floorings", floorings);
			return "product/flooring/sheet";
		}
		
		@GetMapping("/sheet/{y_no}")
		public String SheetPage(@PathVariable("y_no") String y_no, Model model) {
			model.addAttribute("flooringC", flooringservice.findByYNo(y_no));
			return "product/flooring/sheet/FC_product";
		}
}
