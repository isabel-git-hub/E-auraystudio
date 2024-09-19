package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.BathDto;

@Service
public interface BathService {

	List<BathDto> getAllBaths();

	List<BathDto> getBathsWithPaging(int page, int size);

	int getTotalBathCount();

}
