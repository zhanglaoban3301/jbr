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
    /**
     * 录入地毯
     * @param carpet
     * @return
     */
    @Insert("insert into jbr.carpet(id,name,type,price,length,width,batch,entrytime,img) values(null,#{name},#{type},#{price},#{length},#{width},#{batch},#{entrytime},#{img}) ")
    int addcarpet(Carpet carpet);

    /**
     * 分页查询地毯
     * @param page
     * @param pageSize
     * @return
     */
    @Select("select * from jbr.carpet where 1=1 order by entrytime limit #{arg0},#{arg1}")
    List<Carpet> getcarpet(int page, int pageSize);

    /**
     * 查询地毯总数
     * @return
     */
    @Select("select count(*) from jbr.carpet")
    Integer total();

    /**
     * 根据id删除地毯
     * @param id
     * @return
     */
    @Delete("delete from jbr.carpet where id = #{id} ")
    int detelecarpet(int id);

    /**
     * 根据id更新地毯信息
     * @param carpet
     * @return
     */
    @Update("update jbr.carpet set name = #{name},type=#{type}," +
            "entrytime=#{entrytime},price=#{price},batch=#{batch},length=#{length},width=#{width}" +
            "where id = #{id}")
    Integer updatecarpet(Carpet carpet);

    /**
     * 根据id售卖地毯
     * @param id
     * @return
     */
    @Update("update jbr.carpet set state ='1' where id = #{arg0} ")
    Integer sellCarpet(int id);

    /**
     * 根据批次查询地毯
     * @param page
     * @param pageSize
     * @param batch
     * @return
     */
    @Select("select * from jbr.carpet where 1=1 and batch = #{arg2} order by entrytime limit #{arg0},#{arg1}")
    List<Carpet> getcarpetBybatch(int page, int pageSize,String batch);

    /**
     * 根据批次查询地毯总数
     * @param batch
     * @return
     */
    @Select("select count(*) from jbr.carpet where 1=1 and batch = #{batch} ")
    Integer getcarpetnumBybatch(String batch);

    /**
     * 根据查询条件动态查询地毯信息
     * @param carpet
     * @return
     */
    @Select("<script>" +
            "select * from  jbr.carpet where 1=1" +
            "<if test= 'name!=null  '  >" +
            "and name = #{name} "+
            "</if>" +
            "<if test= 'type!=null  '  >" +
            "and type = #{type}"+
            "</if>" +
            "<if test= 'batch!=null  ' >" +
            "and batch = #{batch}"+
            "</if>" +
            "<if test= 'state!=null  ' >" +
            "and state = #{state}"+
            "</if>" +
            "<if test= 'entrytime!=null  ' >" +
            "and entrytime = #{entrytime}"+
            "</if>" +
            "</script>"
    )
    List<Carpet> searchcarpet(Carpet carpet);

    /**
     * 根据搜索条件动态查询地毯总数
     * @param carpet
     * @return
     */
    @Select("<script>" +
            "select count(*) from  jbr.carpet where 1=1" +
            "<if test= 'name!=null '  >" +
            "and name = #{name} "+
            "</if>" +
            "<if test= 'type!=null  '  >" +
            "and type = #{type}"+
            "</if>" +
            "<if test= 'batch!=null  ' >" +
            "and batch = #{batch}"+
            "</if>" +
            "<if test= 'state!=null  ' >" +
            "and state = #{state}"+
            "</if>" +
            "<if test= 'entrytime!=null  ' >" +
            "and entrytime = #{entrytime}"+
            "</if>" +
            "</script>"
    )
    Integer searchcarpetnum(Carpet carpet);

    /**
     * 查询批次 by year
     * @param year
     * @return
     */
    @Select("select * from jbr.batch where year = #{arg0} order by id")
    List<Batch> getBatch(String year);

    /**
     * 分页查询未售出地毯
     * @param page
     * @param pageSize
     * @return
     */
    @Select("select * from jbr.carpet where state = '0' limit #{arg0},#{arg1} ")
    List<Carpet> getWsCarpet(int page,int pageSize);
    /**
     * 查询未售出地毯数量
     * @return
     */
    @Select("select count(*) from jbr.carpet where state = '0' ")
    Integer getWsCarpetNum();
    /**
     * 分页查询已售出地毯
     * @param page
     * @param pageSize
     * @return
     */
    @Select("select * from jbr.carpet where state = '1' limit #{arg0},#{arg1} ")
    List<Carpet> getYsCarpet(int page,int pageSize);
    /**
     * 查询已售出地毯数量
     * @return
     */
    @Select("select count(*) from jbr.carpet where state = '1' ")
    Integer getYsCarpetNum();
}
