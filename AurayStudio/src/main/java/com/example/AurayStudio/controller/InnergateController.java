package com.example.AurayStudio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AurayStudio.dto.InnergateDto;
import com.example.AurayStudio.service.InnergateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/innergate")
@RequiredArgsConstructor
public class InnergateController {
	private final InnergateService innergateservice ;
	
	// 3연동중문
	 @GetMapping("/jungmun3")
	    public String Inner3jungmun(Model model) {
	    	List<InnergateDto> innergates = innergateservice.getInnerByKKind("3연동 중문");
	    	model.addAttribute("innergates", innergates);
	        return "product/innergate/jungmun3";
	    }

    @GetMapping("/jungmun3/{y_no}")
    public String innerGateJ(@PathVariable("y_no") String y_no, Model model) {
        model.addAttribute("innergateJ", innergateservice.findByYNo(y_no)) ;
        return "product/innergate/jungmun3/IA_product";
    }
 
    // 양개중문
	 @GetMapping("/double_sided")
	    public String InnerDouble_sided(Model model) {
	    	List<InnergateDto> innergates = innergateservice.getInnerByKKind("양개중문");
	    	model.addAttribute("innergates", innergates);
	        return "product/innergate/double_sided";
	    }
	 
	 @GetMapping("/double_sided/{y_no}")
	    public String InnerDouble_sidedB(@PathVariable("y_no") String y_no, Model model) {
	        model.addAttribute("innergateB", innergateservice.findByYNo(y_no)) ;
	        return "product/innergate/double_sided/IB_product";
	    }
    
    // 슬림 알루미늄 중문
    @GetMapping("/aluminum")
    public String InnerAaluminum(Model model) {
    	List<InnergateDto> innergates = innergateservice.getInnerByKKind("슬림 알루미늄 중문");
    	model.addAttribute("innergates", innergates);
        return "product/innergate/aluminum";
    }
    
    @GetMapping("/aluminum/{y_no}")
    public String InnerDouble_sidedC(@PathVariable("y_no") String y_no, Model model) {
        model.addAttribute("innergateC", innergateservice.findByYNo(y_no)) ;
        return "product/innergate/aluminum/IC_product";
    }
    
 // 폴딩도어
    @GetMapping("/folding")
    public String InnerCabinet(Model model) {
    	List<InnergateDto> innergates = innergateservice.getInnerByKKind("폴딩도어");
    	model.addAttribute("innergates", innergates);
        return "product/innergate/folding";
    }
    
    @GetMapping("/folding/{y_no}")
    public String InnerDouble_sidedD(@PathVariable("y_no") String y_no, Model model) {
        model.addAttribute("innergateD", innergateservice.findByYNo(y_no)) ;
        return "product/innergate/folding/ID_product";
    }
    
    // 파티션
    @GetMapping("/partition")
    public String InnerSliding(Model model) {
    	List<InnergateDto> innergates = innergateservice.getInnerByKKind("파티션");
    	model.addAttribute("innergates", innergates);
        return "product/innergate/partition";
    }
    
    @GetMapping("/partition/{y_no}")
    public String InnerDouble_sidedE(@PathVariable("y_no") String y_no, Model model) {
        model.addAttribute("innergateE", innergateservice.findByYNo(y_no)) ;
        return "product/innergate/partition/IE_product";
    }
}
