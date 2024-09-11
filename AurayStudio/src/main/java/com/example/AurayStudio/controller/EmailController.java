package com.example.AurayStudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.AurayStudio.dto.EmailDto;
import com.example.AurayStudio.service.EmailService;

@Controller
public class EmailController {
	private final EmailService email;
	@Autowired
	public EmailController(EmailService email) {
		this.email = email;
	}
	
	@GetMapping("/inquire")
	public String inquireForm() {
		return "inquireForm";
	}
	
//	@PostMapping("/sendMail")
//    public String sendMail(EmailDto emailDto) {
//        boolean result = email.mailSend(emailDto);
//
//        if (result) {
//            System.out.println("Email 전송 성공!!!");
//        } else {
//            System.out.println("Email 전송 실패!!!");
//        }
//
//        return "redirect:/";  // 성공 또는 실패 후 메인 페이지로 리다이렉트
//    }
	
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute EmailDto emailDto) {
	    // emailDto.getTo()에 폼에서 입력한 이메일 주소가 들어옵니다.
	    if (email.mailSend(emailDto)) {
	        System.out.println("Email 전송 성공!");
	    } else {
	        System.out.println("Email 전송 실패!");
	    }
	    return "redirect:/";
	}

}
