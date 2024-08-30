package com.example.AurayStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	@GetMapping({"/", "/index"})
	public String indexPage(HttpSession session, Model model) {
		// 세션에서 사용자 정보 가져오기
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("greeting", "안녕하세요, " + loggedInUser + "님");
        }
		return "index";
	}
}
