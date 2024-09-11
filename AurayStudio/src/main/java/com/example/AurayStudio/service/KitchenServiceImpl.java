package com.example.AurayStudio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AurayStudio.dao.KitchenDao;
import com.example.AurayStudio.dto.KitchenDto;

@Service
public class KitchenServiceImpl implements KitchenService{
	private final KitchenDao kitchendao ;
	
	public KitchenServiceImpl (KitchenDao kitchendao) {
		this.kitchendao = kitchendao ;
	}

	@Override
	public KitchenDto findByYNo(String yNo) {
		return kitchendao.findByYNo(yNo) ;
	}

	@Override
	public List<KitchenDto> getKitchensByKKind(String kKind) {
		return kitchendao.getKitchensByKKind(kKind);
	}

	@Override
	public List<KitchenDto> getKitchensByPKind(String PKind) {
		return kitchendao.getKitchensByPKind(PKind);
	}

}
