package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.BathDao;
import com.example.AurayStudio.dto.BathDto;

@Service
public class BathServiceImpl implements BathService {
	private final BathDao bathdao;
	
	public BathServiceImpl (BathDao bathdao) {
		this.bathdao = bathdao;
	}
	
	@Override
	public List<BathDto> getAllBaths() {
		return bathdao.findAll();
	}
	
	@Override
	public List<BathDto> getBathsWithPaging(int page, int size) {
		int offset = (page - 1) * size;
		return bathdao.selectPagedBaths(size, offset);
	}
	
	@Override
	public int getTotalBathCount() {
		return bathdao.getTotalBathCount();
	}
}
