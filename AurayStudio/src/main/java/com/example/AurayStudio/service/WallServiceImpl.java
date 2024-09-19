package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.WallDao;
import com.example.AurayStudio.dto.WallDto;

@Service
public class WallServiceImpl implements WallService {
	private final WallDao walldao;
	
	public WallServiceImpl (WallDao walldao) {
		this.walldao = walldao;
	}
	
	@Override
	public List<WallDto> getAllWalls() {
		return walldao.findAll();
	}
	
	@Override
	public List<WallDto> getWallsWithPaging(int page, int size) {
		int offset = (page - 1) * size;  
		return walldao.selectPagedWalls(size, offset);
	}
	
	@Override
	public int getTotalWallCount() {
		return walldao.getTotalWallCount();
	}

}
