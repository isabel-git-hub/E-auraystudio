package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.KitchenDto;

@Service
public interface KitchenService {
	KitchenDto findByYNo(String yNo);
	List<KitchenDto> getKitchensByKKind(String kKind);
	List<KitchenDto> getKitchensByPKind(String PKind);
	List<KitchenDto> getAllKitchens();
	List<KitchenDto> getKitchensWithPaging(int page, int size);
	int getTotalKitchenCount();
}
