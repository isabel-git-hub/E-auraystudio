package com.example.AurayStudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.MemberDao;
import com.example.AurayStudio.dto.MemberDto;

@Service
// @RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
//    private final PasswordEncoder passwordEncoder;
	@Override
	public boolean checkLogin(String userid, String userpw) {
		MemberDto memberDto = memberDao.findByUserid(userid);
		return memberDto != null && memberDto.getUserpw().equals(userpw);
	}
	
	@Override
	public boolean checkMember(MemberDto dto) {
		return memberDao.checkMember(dto);
	}
	
	@Override
	public boolean putMember(MemberDto memberDto) {
		return memberDao.insertMember(memberDto);
	}
	
	@Override
	public boolean checkId(String userid) {
		return memberDao.checkId(userid) == 0;
	}
	

}
