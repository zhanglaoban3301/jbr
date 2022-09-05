package com.jbr.service.impl;

import com.jbr.domain.entity.Jbrtest;
import com.jbr.mapper.JbrtestMapper;
import com.jbr.service.JbrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zxw
 * @Date 2022/8/15 21:46
 * @Description:
 * @Version 1.0
 */
@Service
public class JbrtestServiceImpl  implements JbrService {
    @Autowired
    private JbrtestMapper jbrtestMapper;
    @Override
    public List<Jbrtest> findAll() {
        return jbrtestMapper.findAll();
    }
}
