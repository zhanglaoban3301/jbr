package com.jbr.service.impl;

import com.jbr.domain.entity.Carpet;
import com.jbr.mapper.CarpetMapper;
import com.jbr.service.CarpetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Carpet> getCarpetByPage(int page) {
        int pageSize = 10;
        return carpetMapper.getCarpetByPage((page - 1) * pageSize + 1, page * pageSize);

    }
}
