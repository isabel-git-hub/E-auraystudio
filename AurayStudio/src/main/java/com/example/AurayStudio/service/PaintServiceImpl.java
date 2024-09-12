package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.PaintDao;
import com.example.AurayStudio.dto.ImgmngDto;
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

	@Override
	public List<PaintDto> getAllPaints(){
		return paintdao.findAll();
	}

	@Override
	public void addPaint(PaintDto paintDto) {
		paintdao.insertPaint(paintDto);
	}

	@Override
	public void deletePaint(String y_no) {
	    paintdao.deletePaint(y_no);
	}

	@Override
	public ImgmngDto downloadImg(String y_no) {
		return paintdao.selectImgByY_no(y_no);
	}

	@Override
	public List<PaintDto> getPaintList() {
		return paintdao.selectPaintList();
	}

	@Override
	public void uploadImg(ImgmngDto imgdto) {
		paintdao.insertImg(imgdto);
	}
}
