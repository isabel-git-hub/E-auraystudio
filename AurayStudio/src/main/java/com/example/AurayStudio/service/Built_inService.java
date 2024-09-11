package com.example.AurayStudio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.Built_inDto;
import com.example.AurayStudio.dto.DoorDto;
import com.example.AurayStudio.dto.KitchenDto;

@Service
public interface Built_inService {
	Built_inDto findByYNo(String yNo);
	List<Built_inDto> getBuilt_insByKKind(String kKind);
}
