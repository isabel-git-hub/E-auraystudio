package com.example.AurayStudio.service;

import com.example.AurayStudio.dto.MemberDto;

public interface MemberService {
	boolean checkLogin(String userid, String userpw);

	boolean checkMember(MemberDto memberDto);

	boolean putMember(MemberDto memberDto);
	
	boolean checkId(String userid);


}
