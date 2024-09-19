package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.TileDto;

@Service
public interface TileService {

	List<TileDto> getAllTiles();

	List<TileDto> getTilesWithPaging(int page, int size);

	int getTotalTileCount();

}
