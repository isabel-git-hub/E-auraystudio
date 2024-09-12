package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.ImgmngDto;
import com.example.AurayStudio.dto.PaintDto;

@Service
public interface PaintService {
	PaintDto findByYNo (String YNo) ;
	List<PaintDto> getPaintsByKKind(String kKind);
	List<PaintDto> getAllPaints();
	void addPaint(PaintDto paintDto);
	void deletePaint(String y_no);
	ImgmngDto downloadImg(String y_no);
	List<PaintDto> getPaintList();
	void uploadImg(ImgmngDto imgdto);
}
