package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.WallDto;

@Service
public interface WallService {

	List<WallDto> getAllWalls();

	List<WallDto> getWallsWithPaging(int page, int size);

	int getTotalWallCount();

}
