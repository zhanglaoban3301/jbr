package com.jbr.service.impl;

import com.jbr.domain.entity.Carpet;
import com.jbr.mapper.CarpetMapper;
import com.jbr.service.CarpetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zxw
 * @Date 2022/9/8 21:25
 * @Description:
 * @Version 1.0
 */
@Service
public class CarpetServiceImpl implements CarpetService {
    @Autowired
    private CarpetMapper carpetMapper;
    @Override
    public int addcarpet(Carpet carpet) {
        return carpetMapper.addcarpet(carpet);
    }

    @Override
    public int updatecarpet(Integer id) {
        return 0;
    }

    @Override
    public int deletecarpet(Integer id) {
        return 0;
    }
}
