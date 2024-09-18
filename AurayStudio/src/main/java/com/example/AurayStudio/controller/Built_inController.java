package com.example.AurayStudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AurayStudio.dto.Built_inDto;
import com.example.AurayStudio.service.Built_inService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/built_in")
@RequiredArgsConstructor
public class Built_inController {
	@Autowired
	private Built_inService built_inservice;

	// 여닫이
	@GetMapping("/casement")
	public String BuiltCasement(Model model) {
		List<Built_inDto> built_ins = built_inservice.getBuilt_insByKKind("여닫이");
		model.addAttribute("built_ins", built_ins);
		return "product/built_in/casement";
	}

	@GetMapping("/casement/{y_no}")
	public String BuiltCasement(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("builtInC", built_inservice.findByYNo(y_no));
	    return "product/built_in/casement/BC_product";
	}


	// 드레스룸
	@GetMapping("/dressing")
	public String BuiltCraftinesse(Model model) {
		List<Built_inDto> built_ins = built_inservice.getBuilt_insByKKind("드레스룸");
		model.addAttribute("built_ins", built_ins);
		return "product/built_in/dressing";
	}
	
	@GetMapping("/dressing/{y_no}")
	public String BuiltCasementD(@PathVariable("y_no") String y_no, Model model) {
		model.addAttribute("builtInD", built_inservice.findByYNo(y_no));
		return "product/built_in/dressing/BD_product";
	}

	// 현관장
	@GetMapping("/entrancehall")
	public String BuiltEntrancehall(Model model) {
		List<Built_inDto> built_ins = built_inservice.getBuilt_insByKKind("현관장");
		model.addAttribute("built_ins", built_ins);
		return "product/built_in/entrancehall";
	}
	
	@GetMapping("/entrancehall/{y_no}")
	public String BuiltEntrancehall(@PathVariable("y_no") String y_no, Model model) {
		model.addAttribute("builtInE", built_inservice.findByYNo(y_no));
		return "product/built_in/entrancehall/BE_product";
	}

	// 수납장
	@GetMapping("/cabinet")
	public String BuiltCabinet(Model model) {
		List<Built_inDto> built_ins = built_inservice.getBuilt_insByKKind("수납장");
		model.addAttribute("built_ins", built_ins);
		return "product/built_in/cabinet";
	}
	
	@GetMapping("/cabinet/{y_no}")
	public String BuiltCabinet(@PathVariable("y_no") String y_no, Model model) {
		model.addAttribute("builtInM", built_inservice.findByYNo(y_no));
		return "product/built_in/cabinet/BM_product";
	}

	// 슬라이딩
	@GetMapping("/sliding")
	public String BuiltSliding(Model model) {
		List<Built_inDto> built_ins = built_inservice.getBuilt_insByKKind("슬라이딩");
		model.addAttribute("built_ins", built_ins);
		return "product/built_in/sliding";
	}
	
	@GetMapping("/sliding/{y_no}")
	public String BuiltSliding(@PathVariable("y_no") String y_no, Model model) {
		model.addAttribute("builtInS", built_inservice.findByYNo(y_no));
		return "product/built_in/sliding/BS_product";
	}
}
