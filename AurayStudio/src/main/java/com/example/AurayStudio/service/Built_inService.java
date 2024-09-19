package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.Built_inDto;

@Service
public interface Built_inService {
	Built_inDto findByYNo(String yNo);
	List<Built_inDto> getBuilt_insByKKind(String kKind);
	List<Built_inDto> getAllBuilt_ins();
	List<Built_inDto> getBuilt_insWithPaging(int page, int size);
	int getTotalBuilt_inCount();
}
