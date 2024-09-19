package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.MouldingDto;

@Service
public interface MouldingService {

	List<MouldingDto> getAllMouldings();

	List<MouldingDto> getMouldingsWithPaging(int page, int size);

	int getTotalMouldingCount();

}
