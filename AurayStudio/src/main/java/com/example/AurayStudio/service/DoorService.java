package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.DoorDto;

@Service
public interface DoorService {
	DoorDto findByYNo(String yNo);
	List<DoorDto> getDoorsByKKind(String kKind);
}
