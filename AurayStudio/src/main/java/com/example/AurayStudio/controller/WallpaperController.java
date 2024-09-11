package com.example.AurayStudio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AurayStudio.dto.WallpaperDto;
import com.example.AurayStudio.service.WallpaperService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/wallpaper")
@RequiredArgsConstructor
public class WallpaperController {
	private final WallpaperService wallpaperservice;

	// 실크
	@GetMapping("/silk")
	public String Silk(Model model) {
		List<WallpaperDto>wallpapers = wallpaperservice.getWallpapersByKKind("실크");
		model.addAttribute("wallpapers", wallpapers);
		return "product/wallpaper/silk";
	}
	
	@GetMapping("/silk/{y_no}")
	public String SilkPage(@PathVariable("y_no")String y_no, Model model) {
		model.addAttribute("wallpaperA", wallpaperservice.findByYNo(y_no));
		return "product/wallpaper/silk/WA_product";
	}
	
	// 합지
	@GetMapping("/synthetic")
	public String Synthetic(Model model) {
		List<WallpaperDto>wallpapers = wallpaperservice.getWallpapersByKKind("합지");
		model.addAttribute("wallpapers", wallpapers);
		return "product/wallpaper/synthetic";
	}
	
	@GetMapping("/synthetic/{y_no}")
	public String SyntheticPage(@PathVariable("y_no")String y_no, Model model) {
		model.addAttribute("wallpaperB", wallpaperservice.findByYNo(y_no));
		return "product/wallpaper/synthetic/WB_product";
	}
	
}
