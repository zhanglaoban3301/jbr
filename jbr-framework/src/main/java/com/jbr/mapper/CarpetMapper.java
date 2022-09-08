package com.jbr.mapper;

import com.jbr.domain.entity.Carpet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zxw
 * @Date 2022/9/8 21:26
 * @Description:
 * @Version 1.0
 */
@Mapper
public interface CarpetMapper {
    @Insert("insert into jbr.carpet(id,name,type,price,length,width,batch,entrytime,img) values(1,#{name},#{type},#{price},#{length},#{width},#{batch},#{entrytime},#{img}) ")
    public int addcarpet(Carpet carpet);
}
