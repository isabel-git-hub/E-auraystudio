package com.example.AurayStudio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.Built_inDto;
import com.example.AurayStudio.dto.DoorDto;
import com.example.AurayStudio.dto.FlooringDto;
import com.example.AurayStudio.dto.KitchenDto;

@Service
public interface FlooringService {
	FlooringDto findByYNo(String yNo);
	List<FlooringDto> getFlooringsByKKind(String kKind);
}
