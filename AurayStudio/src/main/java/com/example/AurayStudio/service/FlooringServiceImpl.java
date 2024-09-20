package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.FlooringDao;
import com.example.AurayStudio.dto.FlooringDto;

@Service
public class FlooringServiceImpl implements FlooringService{
	private final FlooringDao flooringDao ;
	
	public FlooringServiceImpl (FlooringDao flooringDao) {
		this.flooringDao = flooringDao ;
	}

	@Override
	public FlooringDto findByYNo(String yNo) {
		return flooringDao.findByYNo(yNo) ;
	}

	@Override
	public List<FlooringDto> getFlooringsByKKind(String kKind) {
		return flooringDao.getFlooringsByKKind(kKind);
	}

	@Override
	public List<FlooringDto> getAllFloorings() {
		return flooringDao.findAll();
	}
	
	@Override
	public List<FlooringDto> getFlooringsWithPaging(int page, int size) {
		int offset = (page - 1) * size; 
		return flooringDao.selectPagedFloorings(size, offset);
	}
	
	@Override
	public int getTotalFlooringCount() {
		return flooringDao.getTotalFlooringCount();
	}
}
