package com.jbr.mapper;

import com.jbr.domain.entity.Jbrtest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author zxw
 * @Date 2022/8/15 21:45
 * @Description:
 * @Version 1.0
 */
@Mapper
public interface JbrtestMapper  {
    @Select("select * from jbrtest")
    public List<Jbrtest> findAll();
}
