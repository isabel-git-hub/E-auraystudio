package com.example.AurayStudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.AurayStudio.dto.MemberDto;
import com.example.AurayStudio.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	// 로그인 페이지
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("title", "로그인");
		return "login";
	}
	
	// 로그인 처리
	@PostMapping("/login")
    public String login(@RequestParam("userid") String userid,
                        @RequestParam("userpw") String userpw,
                        HttpSession session, Model model) {
        // 로그인 확인
        if (memberService.checkLogin(userid, userpw)) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            session.setAttribute("loggedInUser", userid);
            return "redirect:/index";  // 로그인 성공 시 리다이렉션
        } else {
        	// 로그인 실패 시 에러 메시지 전달
            model.addAttribute("error", "아이디 또는 패스워드가 잘못되었습니다.");
            return "login";  // 로그인 실패 시 로그인 페이지로 리턴
        }
        
    }
	
	// 회원가입 페이지
	@GetMapping("/join")
	public String joinPage(Model model) {
		model.addAttribute("title", "회원가입");
		return "join";
	}
	
	// 회원가입 처리
	@PostMapping("/join")
	public String joinAply(MemberDto memberDto) {
		// 회원가입 시 중복 체크
		if (memberService.checkMember(memberDto)) {
			return "redirect:/join";  // 중복일 경우 회원가입 페이지로 리다이렉션
		}
		// 회원가입 처리
		memberService.putMember(memberDto);
		return "redirect:/login";
	}
	
	// 아이디 중복 체크
    @GetMapping("/checkid")
    @ResponseBody
    public String checkId(@RequestParam(value = "data") String userid) {
        return String.valueOf(memberService.checkId(userid));
    }
    
    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	// 세션 무효화
    	session.invalidate();
    	// 로그아웃 후 로그인 페이지로 리다이렉션
    	return "redirect:/login";
    }
}
