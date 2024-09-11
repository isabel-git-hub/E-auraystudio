package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.PaintDao;
import com.example.AurayStudio.dao.WallpaperDao;
import com.example.AurayStudio.dto.PaintDto;
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

}
