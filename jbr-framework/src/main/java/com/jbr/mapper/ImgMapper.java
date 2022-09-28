package com.jbr.mapper;

import com.jbr.domain.entity.Img;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImgMapper {
    @Select("SELECT * FROM jbr.table_img limit 0,15")
    List<Img> getImgs();

    @Delete("delete from jbr.table_img where 1=1")
    Integer deleteimg();

    @Insert("insert into jbr.table_img(id,src) values(null,#{arg0})")
    Integer insertimg(String src);
}
