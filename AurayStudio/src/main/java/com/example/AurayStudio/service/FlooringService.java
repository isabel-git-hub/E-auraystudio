package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.FlooringDto;

@Service
public interface FlooringService {
	FlooringDto findByYNo(String yNo);
	List<FlooringDto> getFlooringsByKKind(String kKind);
	List<FlooringDto> getAllFloorings();
	List<FlooringDto> getFlooringsWithPaging(int page, int size);
	int getTotalFlooringCount();
}
