package com.jbr.mapper;

import com.jbr.domain.entity.Carpet;
import org.apache.ibatis.annotations.Delete;
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
    @Select("select *,date_format( now(),'%Y-%m-%d' ) as time from jbr.carpet limit #{arg0},#{arg1}")
    List<Carpet> getcarpet(int page, int pageSize);
    @Select("select count(*) from jbr.carpet")
    Integer total();
    @Delete("delete from jbr.carpet where id = #{id}")
    int detelecarpet(int id);
}
