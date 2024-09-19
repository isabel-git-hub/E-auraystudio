package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.WindowDao;
import com.example.AurayStudio.dto.WindowDto;

@Service
public class WindowServiceImpl implements WindowService {
	private final WindowDao windowdao;
	
	public WindowServiceImpl (WindowDao windowdao) {
		this.windowdao = windowdao;
	}
	
	@Override
	public List<WindowDto> getAllWindows() {
		return windowdao.findAll();
	}
	
	@Override
	public List<WindowDto> getWindowsWithPaging(int page, int size) {
		int offset = (page - 1) * size; 
		return windowdao.selectPagedWindows(size, offset);
	}
	
	@Override
	public int getTotalWindowCount() {
		return windowdao.getTotalWindowCount();
	}
}
