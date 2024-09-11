package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.DoorDao;
import com.example.AurayStudio.dto.DoorDto;

@Service
public class DoorServiceImpl implements DoorService{
	private final DoorDao doordao ;
	
	public DoorServiceImpl (DoorDao doordao) {
		this.doordao = doordao ;
	}

	@Override
	public DoorDto findByYNo(String yNo) {
		return doordao.findByYNo(yNo) ;
	}

	@Override
	public List<DoorDto> getDoorsByKKind(String kKind) {
		return doordao.getDoorsByKKind(kKind);
	}

}
