package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.FilmDto;

@Service
public interface FilmService {

	List<FilmDto> getAllFilms();

	List<FilmDto> getFilmsWithPaging(int page, int size);

	int getTotalFilmCount();


}
