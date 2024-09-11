package com.example.AurayStudio.service;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.InnergateDao;
import com.example.AurayStudio.dto.InnergateDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final InnergateDao innergateDao;

    public void saveInnergate(InnergateDto innergateDto) {
        String lastYno = innergateDao.findLastYno();
        int nextYno = 1;

        if (lastYno != null && !lastYno.isEmpty()) {
            // 숫자 부분만 추출하여 증가시키기
            String numericPart = lastYno.replaceAll("[^0-9]", "");
            nextYno = Integer.parseInt(numericPart) + 1;
        }

        // 2자리 숫자로 제품 코드 생성
        String newYno = "IA-" + String.format("%02d", nextYno);
        innergateDto.setY_no(newYno);
        innergateDao.insertInnergate(innergateDto);
    }
}
