package com.example.AurayStudio.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.AurayStudio.dto.MemberDto;

@Mapper
public interface MemberDao {

	@Select("select * from member where userid=#{userid}")
	MemberDto findByUserid(@Param("userid") String userid) throws DataAccessException;

	@Select("SELECT COUNT(*) FROM member WHERE userid=#{userid} AND birthdate=#{birthdate} AND telnumber=#{telnumber}")
	boolean checkMember(MemberDto dto) throws DataAccessException;
	
	@Insert("INSERT INTO member (userid, userpw, username, birthdate, gender, telnumber, addr, permit) " +
            "VALUES (#{userid}, #{userpw}, #{username}, #{birthdate}, #{gender}, #{telnumber}, #{addr}, #{permit})")
	boolean insertMember(MemberDto memberDto) throws DataAccessException;
	@Select("select count(*) from member where userid=#{userid}")
	int checkId(String userid) throws DataAccessException;


}
