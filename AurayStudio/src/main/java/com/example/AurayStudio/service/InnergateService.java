package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.InnergateDto;

@Service
public interface InnergateService {
	InnergateDto findByYNo(String yNo);
	List<InnergateDto> getInnerByKKind(String kKind);
	void saveInnergate (InnergateDto innergateDto) ;
	String findLastYno(int digitCount);
}
