package com.example.AurayStudio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AurayStudio.dto.PaintDto;
import com.example.AurayStudio.service.PaintService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product/paint")
public class PaintController {
	private final PaintService paintservice ;
	
	// 페인트
	@GetMapping("/paint")
	public String Paint (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("페인트") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/paint" ;
	}
	
	@GetMapping ("/paint/{y_no}")
	public String PaintA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("paintA", paintservice.findByYNo(y_no)) ;
		return "product/paint/paint/PA_product" ;
	}
	
	// 방수 페인트
	@GetMapping("/waterproof")
	public String PaintWaterproof (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("방수페인트") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/waterproof" ;
	}
	
	@GetMapping ("/waterproof/{y_no}")
	public String PaintWaterproofA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("waterproofA", paintservice.findByYNo(y_no)) ;
		return "product/paint/waterproof/PB_product" ;
	}
	
	// 프라이머
	@GetMapping("/primer")
	public String PaintPrimer (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("프라이머") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/primer" ;
	}
	
	@GetMapping ("/primer/{y_no}")
	public String PaintPrimerA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("primerA", paintservice.findByYNo(y_no)) ;
		return "product/paint/primer/PC_product" ;
	}
	
	// 에폭시
	@GetMapping("/epoxy")
	public String PaintEpoxy (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("에폭시") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/epoxy" ;
	}
	
	@GetMapping ("/epoxy/{y_no}")
	public String PaintEpoxyA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("epoxyA", paintservice.findByYNo(y_no)) ;
		return "product/paint/epoxy/PD_product" ;
	}
	
	// 신나
	@GetMapping("/thinner")
	public String PaintThinner (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("신나") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/thinner" ;
	}
	
	@GetMapping ("/thinner/{y_no}")
	public String PaintThinnerA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("thinnerA", paintservice.findByYNo(y_no)) ;
		return "product/paint/thinner/PE_product" ;
	}
	
	// 탄성코트
	@GetMapping("/elastic")
	public String PaintElastic (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("탄성코트") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/elastic" ;
	}
	
	@GetMapping ("/elastic/{y_no}")
	public String PaintElasticA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("elasticA", paintservice.findByYNo(y_no)) ;
		return "product/paint/elastic/PF_product" ;
	}
}
