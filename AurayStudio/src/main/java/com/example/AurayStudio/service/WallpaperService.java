package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.WallpaperDto;

@Service
public interface WallpaperService {
	WallpaperDto findByYNo(String yNo);
	List<WallpaperDto> getWallpapersByKKind(String kKind);
}
