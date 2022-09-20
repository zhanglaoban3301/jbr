package com.jbr.mapper;

import com.jbr.domain.entity.Global;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zxw
 */
@Mapper
public interface GlobalMapper {
    /**
     * 获取全局变量
     * @return
     */
    @Select("select * from jbr.global")
    List<Global> getGlobal();
}
