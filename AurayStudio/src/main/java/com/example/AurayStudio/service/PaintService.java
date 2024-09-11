package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.PaintDto;

@Service
public interface PaintService {
	PaintDto findByYNo (String YNo) ;
	List<PaintDto> getPaintsByKKind(String kKind);
}
