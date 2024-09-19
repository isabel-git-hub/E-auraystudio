package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.WindowDto;

@Service
public interface WindowService {

	List<WindowDto> getAllWindows();

	List<WindowDto> getWindowsWithPaging(int page, int size);

	int getTotalWindowCount();

}
