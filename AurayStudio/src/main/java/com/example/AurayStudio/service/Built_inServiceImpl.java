package com.example.AurayStudio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.Built_inDao;
import com.example.AurayStudio.dao.DoorDao;
import com.example.AurayStudio.dto.Built_inDto;
import com.example.AurayStudio.dto.DoorDto;

@Service
public class Built_inServiceImpl implements Built_inService{
	private final Built_inDao built_inDao ;
	
	public Built_inServiceImpl (Built_inDao built_inDao) {
		this.built_inDao = built_inDao ;
	}

	@Override
	public Built_inDto findByYNo(String yNo) {
		return built_inDao.findByYNo(yNo) ;
	}

	@Override
	public List<Built_inDto> getBuilt_insByKKind(String kKind) {
		return built_inDao.getBuilt_insByKKind(kKind);
	}

}
