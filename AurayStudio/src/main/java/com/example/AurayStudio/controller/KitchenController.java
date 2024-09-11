package com.example.AurayStudio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AurayStudio.dto.KitchenDto;
import com.example.AurayStudio.service.KitchenService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/kitchen")
@RequiredArgsConstructor
public class KitchenController {
	private final KitchenService kitchenservice ;
	
	// 키친 (인조대리석)
	@GetMapping("/echo")
    public String kitchenEcho(Model model) {
        List<KitchenDto> kitchens = kitchenservice.getKitchensByKKind("인조대리석");
//        System.out.println("Fetched kitchens: " + kitchens);  // 데이터 출력
        model.addAttribute("kitchens", kitchens);
        return "product/kitchen/echo";
    }
	
	@GetMapping("/echo/{y_no}")
	public String echo(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("echo", kitchenservice.findByYNo(y_no));
	    return "product/kitchen/echo/KA_product"; // 이 경로가 실제 템플릿 위치와 일치하는지 확인하세요
	}

    // 키친 (이스톤)
    @GetMapping("/vista")
    public String kitchenVista(Model model) {
    	List<KitchenDto> kitchens = kitchenservice.getKitchensByKKind("이스톤");
    	model.addAttribute("kitchens", kitchens);
        return "product/kitchen/vista";
    }
    
	@GetMapping("/vista/{y_no}")
	public String vista(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("vista", kitchenservice.findByYNo(y_no));
	    return "product/kitchen/vista/KB_product";
	}
    
    // 키친 (포세린)
    @GetMapping("/signature")
    public String kitchenSignature(Model model) {
    	List<KitchenDto> kitchens = kitchenservice.getKitchensByKKind("포세린");
    	model.addAttribute("kitchens", kitchens);
        return "product/kitchen/signature";
    }
    
	@GetMapping("/signature/{y_no}")
	public String signature(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("signature", kitchenservice.findByYNo(y_no));
	    return "product/kitchen/signature/KC_product";
	}
	
    // 수전
    @GetMapping("/faucet")
    public String kitchenFaucet(Model model) {
    	List<KitchenDto> kitchens = kitchenservice.getKitchensByPKind("수전");
    	model.addAttribute("kitchens", kitchens);
        return "product/kitchen/faucet";
    }
    
	@GetMapping("/faucet/{y_no}")
	public String faucet(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("faucet", kitchenservice.findByYNo(y_no));
	    return "product/kitchen/faucet/KD_product";
	}
	
    // 싱크볼
    @GetMapping("/sink")
    public String kitchenSink(Model model) {
    	List<KitchenDto> kitchens = kitchenservice.getKitchensByPKind("싱크볼");
    	model.addAttribute("kitchens", kitchens);
        return "product/kitchen/sink";
    }
    
	@GetMapping("/sink/{y_no}")
	public String sink(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("sink", kitchenservice.findByYNo(y_no));
	    return "product/kitchen/sink/KE_product";
	}
	
    // 팬트리장, 인출망장
    @GetMapping("/pantry")
    public String kitchenPantry(Model model) {
    	List<KitchenDto> kitchens = kitchenservice.getKitchensByPKind("팬트리장,인출망장");
    	model.addAttribute("kitchens", kitchens);
        return "product/kitchen/pantry";
    }
    
	@GetMapping("/pantry/{y_no}")
	public String pantry(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("pantry", kitchenservice.findByYNo(y_no));
	    return "product/kitchen/pantry/KF_product";
	}
	
    // 후드
    @GetMapping("/hood")
    public String kitchenHood(Model model) {
    	List<KitchenDto> kitchens = kitchenservice.getKitchensByPKind("후드");
    	model.addAttribute("kitchens", kitchens);
        return "product/kitchen/hood";
    }
    
	@GetMapping("/hood/{y_no}")
	public String hood(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("hood", kitchenservice.findByYNo(y_no));
	    return "product/kitchen/hood/KG_product";
	}
	
    // 기타
    @GetMapping("/etc")
    public String kitchenEtc(Model model) {
    	List<KitchenDto> kitchens = kitchenservice.getKitchensByPKind("기타");
    	model.addAttribute("kitchens", kitchens);
        return "product/kitchen/etc";
    }
    
	@GetMapping("/etc/{y_no}")
	public String etc(@PathVariable("y_no") String y_no, Model model) {
	    model.addAttribute("etc", kitchenservice.findByYNo(y_no));
	    return "product/kitchen/etc/KH_product";
	}
}
