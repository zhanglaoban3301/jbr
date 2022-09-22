package com.jbr.service.impl;

import com.jbr.domain.entity.Batch;
import com.jbr.domain.entity.Carpet;
import com.jbr.mapper.CarpetMapper;
import com.jbr.service.CarpetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Value("${pageSize}")
    private int pageSize;
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
    public List<Carpet> getcarpet(int page) {
        return carpetMapper.getcarpet((page-1)*pageSize,pageSize*page);
    }

    @Override
    public Integer total() {
        return carpetMapper.total();
    }

    @Override
    public int detelecarpet(int id) {
        return carpetMapper.detelecarpet(id);
    }

    @Override
    public List<Carpet> searchcarpet(Carpet carpet) {
        return carpetMapper.searchcarpet(carpet);
    }

    @Override
    public Integer searchcarpetnum(Carpet carpet) {
        return carpetMapper.searchcarpetnum(carpet);
    }

    @Override
    public Integer updatecarpet(Carpet carpet) {
        return carpetMapper.updatecarpet(carpet);
    }

    @Override
    public List<Batch> getbatch(String year) {
        return carpetMapper.getBatch(year);
    }

    @Override
    public List<Carpet> getcarpetbybatch(int page, String batch) {
        return carpetMapper.getcarpetBybatch((page-1)*pageSize,pageSize*page,batch);
    }

    @Override
    public Integer getcarpetnumbybatch(String batch) {
        return carpetMapper.getcarpetnumBybatch(batch);
    }

    @Override
    public Integer sellCarpet(int id) {
        return carpetMapper.sellCarpet(id);
    }

    @Override
    public List<Carpet> getWsCarpet(int page) {
        return carpetMapper.getWsCarpet((page-1)*pageSize,pageSize*page);
    }

    @Override
    public Integer getWsCarpetNum() {
        return carpetMapper.getWsCarpetNum();
    }

    @Override
    public List<Carpet> getYsCarpet(int page) {
        return carpetMapper.getYsCarpet((page-1)*pageSize,pageSize*page);
    }

    @Override
    public Integer getYsCarpetNum() {
        return carpetMapper.getYsCarpetNum();
    }
}
