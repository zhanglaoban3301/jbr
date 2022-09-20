package com.jbr.mapper;

import com.jbr.domain.entity.Batch;
import com.jbr.domain.entity.Carpet;
import org.apache.ibatis.annotations.*;

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
    int addcarpet(Carpet carpet);
    @Select("select * from jbr.carpet where 1=1 order by entrytime limit #{arg0},#{arg1}")
    List<Carpet> getcarpet(int page, int pageSize);
    @Select("select count(*) from jbr.carpet")
    Integer total();
    @Delete("delete from jbr.carpet where id = #{id} ")
    int detelecarpet(int id);
    @Update("update jbr.carpet set name = #{name},type=#{type}," +
            "entrytime=#{entrytime},price=#{price},batch=#{batch},length=#{length},width=#{width}" +
            "where id = #{id}")
    Integer updatecarpet(Carpet carpet);


    @Select("<script>" +
            "select * from  jbr.carpet where 1=1" +
            "<if test= 'name!=null'  >" +
            "and name = #{name} "+
            "</if>" +
            "<if test= 'type!=null  '  >" +
            "and type = #{type}"+
            "</if>" +
            "<if test= 'batch!=null  ' >" +
            "and batch = #{batch}"+
            "</if>" +
            "<if test= 'entrytime!=null ' >" +
            "and entrytime = #{entrytime}"+
            "</if>" +
            "</script>"
    )
    List<Carpet> searchcarpet(Carpet carpet);
    @Select("<script>" +
            "select count(*) from  jbr.carpet where 1=1" +
            "<if test= 'name!=null'  >" +
            "and name = #{name} "+
            "</if>" +
            "<if test= 'type!=null  '  >" +
            "and type = #{type}"+
            "</if>" +
            "<if test= 'batch!=null  ' >" +
            "and batch = #{batch}"+
            "</if>" +
            "<if test= 'entrytime!=null ' >" +
            "and entrytime = #{entrytime}"+
            "</if>" +
            "</script>"
    )
    Integer searchcarpetnum(Carpet carpet);
    @Select("select * from jbr.batch where year = #{arg0} order by id")
    List<Batch> getBatch(String year);
}
