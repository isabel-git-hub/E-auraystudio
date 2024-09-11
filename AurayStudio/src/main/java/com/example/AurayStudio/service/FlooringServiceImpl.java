package com.example.AurayStudio.service;

import java.util.List;
import java.util.Optional;

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

}
