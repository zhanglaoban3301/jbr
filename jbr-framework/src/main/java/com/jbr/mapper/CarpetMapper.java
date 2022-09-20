package com.jbr.mapper;

import com.jbr.domain.entity.Carpet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author zxw
 * @Date 2022/9/8 21:26
 * @Description:
 * @Version 1.0
 */
@Mapper
public interface CarpetMapper {
    @Insert("insert into jbr.carpet(id,name,type,price,length,width,batch,entrytime,img) values(null,#{name},#{type},#{price},#{length},#{width},#{batch},#{entrytime},#{img}) ")
    public int addcarpet(Carpet carpet);

    @Select("select * from jbr.carpet limit #{page},#{pageSize}")
    public List<Carpet> getCarpetByPage(int page, int pageSize);
}
