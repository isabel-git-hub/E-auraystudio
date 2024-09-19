package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.MouldingDao;
import com.example.AurayStudio.dto.MouldingDto;

@Service
public class MouldingServiceImpl implements MouldingService {
	private final MouldingDao mouldingdao;
	
	public MouldingServiceImpl (MouldingDao mouldingdao) {
		this.mouldingdao = mouldingdao;
	}
	
	@Override
	public List<MouldingDto> getAllMouldings() {
		return mouldingdao.findAll();
	}
	
	@Override
	public List<MouldingDto> getMouldingsWithPaging(int page, int size) {
		int offset = (page - 1) * size;  
		return mouldingdao.selectPagedMouldings(size, offset);
	}
	
	@Override
	public int getTotalMouldingCount() {
		return mouldingdao.getTotalMouldingCount();
	}
}
