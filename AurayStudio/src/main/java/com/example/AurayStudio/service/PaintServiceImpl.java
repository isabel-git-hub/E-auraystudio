package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.AurayStudio.dao.PaintDao;
import com.example.AurayStudio.dto.PaintDto;

@Service
public class PaintServiceImpl implements PaintService{
	private final PaintDao paintdao ;
	
	public PaintServiceImpl (PaintDao paintdao) {
		this.paintdao = paintdao ;
	}
	
	public PaintDto findByYNo(String yNo) {
		return paintdao.findByYNo(yNo) ;
	}

	public List<PaintDto> getPaintsByKKind(String kKind) {
		return paintdao.getPaintsByKKind(kKind);
	}

}
