package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.InnergateDao;
import com.example.AurayStudio.dto.InnergateDto;

@Service
public class InnergateServiceImpl implements InnergateService {
    private final InnergateDao innergateDao;

    public InnergateServiceImpl(InnergateDao innergateDao) {
        this.innergateDao = innergateDao;
    }

    @Override
    public InnergateDto findByYNo(String yNo) {
        return innergateDao.findByYNo(yNo);
    }

    @Override
    public List<InnergateDto> getInnerByKKind(String kKind) {
        return innergateDao.getInnerByKKind(kKind);
    }

    @Override
    public void saveInnergate(InnergateDto innergateDto) {
        innergateDao.insertInnergate(innergateDto);
    }

    @Override
    public String findLastYno(int digitCount) {
        // 데이터베이스에서 가장 마지막 y_no 값을 가져오기
        String lastYno = innergateDao.findLastYno();

        if (lastYno == null || lastYno.isEmpty()) {
            // 데이터가 없는 경우 기본 값 설정 (예: "IA-01")
            return "IA-" + String.format("%0" + digitCount + "d", 1);
        }

        // 숫자 부분만 추출하여 증가시키기
        String numericPart = lastYno.replaceAll("[^0-9]", ""); // 숫자 부분만 추출
        int nextYno = Integer.parseInt(numericPart) + 01; // 숫자를 1 증가시킴

        // 접두사 부분 추출
        String prefix = lastYno.replaceAll("[0-9]", ""); // 예: "IA-"

        // 새로운 y_no 생성 (예: "IA-02")
        return prefix + String.format("%0" + digitCount + "d", nextYno);
    }
}
