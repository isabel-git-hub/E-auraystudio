package com.example.AurayStudio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AurayStudio.dao.ShopDao;
import com.example.AurayStudio.dto.ShopDto;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public List<ShopDto> getAllShops() {
        return shopDao.getAllShop();
    }
}
