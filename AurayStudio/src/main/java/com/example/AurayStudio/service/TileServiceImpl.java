package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.TileDao;
import com.example.AurayStudio.dto.TileDto;

@Service
public class TileServiceImpl implements TileService {
	private final TileDao tiledao;
	
	public TileServiceImpl (TileDao tiledao) {
		this.tiledao = tiledao;
	}
	
	@Override
	public List<TileDto> getAllTiles() {
		return tiledao.findAll();
	}
	
	@Override
	public List<TileDto> getTilesWithPaging(int page, int size) {
		int offset = (page - 1) * size;
		return tiledao.selectPagedTiles(size, offset);
	}

	@Override
	public int getTotalTileCount() {
		return tiledao.getTotalTileCount();
	}
}
