package com.example.AurayStudio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AurayStudio.dto.DoorDto;
import com.example.AurayStudio.service.DoorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/door")
@RequiredArgsConstructor
public class DoorController {
	private final DoorService doorservice ;
	
	// 도어 (ABS 도어)
	 @GetMapping("/doorabs")
	    public String DoorABS(Model model) {
	    	List<DoorDto> doors = doorservice.getDoorsByKKind("ABS 도어");
	    	model.addAttribute("doors", doors);
	        return "product/door/doorabs";
	    } 
	 
		 @GetMapping("/absdoor/{y_no}")
		 public String DoorABSA(@PathVariable("y_no") String y_no ,  Model model) {
			 model.addAttribute("doorA", doorservice.findByYNo(y_no)) ;
			 return "product/door/absdoor/DA_product" ;
		 }

    // 도어 (기능성 도어)
	 @GetMapping("/craftinesse")
	    public String DoorCraftinesse(Model model) {
	    	List<DoorDto> doors = doorservice.getDoorsByKKind("기능성 도어");
	    	model.addAttribute("doors", doors);
	        return "product/door/craftinesse";
	    }
	 
	 @GetMapping("/craftinesse/{y_no}")
	 public String DoorCraftinesseA(@PathVariable("y_no") String y_no ,  Model model) {
//		 DoorDto doors = doorservice.findByYNo(y_no) ;
//		 model.addAttribute("y_no", builtIn) ;
		 model.addAttribute("doorB", doorservice.findByYNo(y_no)) ;
		 return "product/door/craftinesse/DB_product" ;
	 }
    
    // 도어 (도어 하드웨어)
    @GetMapping("/hardware")
    public String DoorHardware(Model model) {
    	List<DoorDto> doors = doorservice.getDoorsByKKind("도어 하드웨어");
    	model.addAttribute("doors", doors);
        return "product/door/hardware";
    }
    
	 @GetMapping("/hardware/{y_no}")
	 public String DoorHardwareA(@PathVariable("y_no") String y_no ,  Model model) {
//		 DoorDto doors = doorservice.findByYNo(y_no) ;
//		 model.addAttribute("y_no", builtIn) ;
		 model.addAttribute("doorC", doorservice.findByYNo(y_no)) ;
		 return "product/door/hardware/DC_product" ;
	 }
    // 도어 (도어 시스템)
    @GetMapping("/system")
    public String DoorSystem(Model model) {
    	List<DoorDto> doors = doorservice.getDoorsByKKind("도어 시스템");
    	model.addAttribute("doors", doors);
        return "product/door/system";
    }
    
	 @GetMapping("/system/{y_no}")
	 public String DoorSystemA(@PathVariable("y_no") String y_no ,  Model model) {
//		 DoorDto doors = doorservice.findByYNo(y_no) ;
//		 model.addAttribute("y_no", builtIn) ;
		 model.addAttribute("doorD", doorservice.findByYNo(y_no)) ;
		 return "product/door/system/DD_product" ;
	 }
}
