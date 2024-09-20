package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.WallpaperDao;
import com.example.AurayStudio.dto.WallpaperDto;

@Service
public class WallpaperServiceImpl implements WallpaperService{
	private final WallpaperDao wallpaperDao ;
	
	public WallpaperServiceImpl (WallpaperDao wallpaperDao) {
		this.wallpaperDao = wallpaperDao ;
	}

	@Override
	public WallpaperDto findByYNo(String yNo) {
		return wallpaperDao.findByYNo(yNo);
	}

	@Override
	public List<WallpaperDto> getWallpapersByKKind(String kKind) {
		// TODO Auto-generated method stub
		return wallpaperDao.getWallpapersByKKind(kKind);
	}

	@Override
	public List<WallpaperDto> getAllWallpapers() {
		return wallpaperDao.findAll();
	}
	
	@Override
	public List<WallpaperDto> getWallpapersWithPaging(int page, int size) {
		int offset = (page - 1) * size;
		return wallpaperDao.selectPagedWallpapers(size, offset);
	}
	
	@Override
	public int getTotalWallpaperCount() {
		return wallpaperDao.getTotalWallpaperCount();
	}
}
