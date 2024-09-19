package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.FilmDao;
import com.example.AurayStudio.dto.FilmDto;

@Service
public class FilmServiceImpl implements FilmService {
	private final FilmDao filmdao;
	
	public FilmServiceImpl (FilmDao filmdao) {
		this.filmdao = filmdao;
	}
	
	@Override
	public List<FilmDto> getAllFilms() {
		return filmdao.findAll();
	}
	
	@Override
	public List<FilmDto> getFilmsWithPaging(int page, int size) {
		int offset = (page - 1) * size;
		return filmdao.selectPagedFilms(size, offset);
	}
	
	@Override
	public int getTotalFilmCount() {
		return filmdao.getTotalFilmCount();
	}
}
