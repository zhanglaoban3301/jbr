package com.jbr.service;

import com.jbr.domain.entity.Batch;
import com.jbr.domain.entity.Carpet;
import com.jbr.domain.pojo.RespBean;

import java.util.List;

/**
 * @Author zxw
 * @Date 2022/9/8 21:22
 * @Description:
 * @Version 1.0
 */
public interface CarpetService {
    /**
     * 新增地毯
     * @param carpet
     * @return
     */
    public int addcarpet(Carpet carpet);

    /**
     * 根据id更新地毯
     * @param id
     * @return
     */
    public int updatecarpet(Integer id);
    /**
     * 根据id删除地毯
     * @param id
     * @return
     */
    public int deletecarpet(Integer id);

    /**
     * 分页查询地毯列表
     * @param page
     * @return
     */
    List<Carpet> getcarpet(int page);

    /**
     * 查询地毯总数
     * @return
     */
    Integer total();

    /**
     * 根据id删除地毯数据
     * @param id
     * @return
     */
    int detelecarpet(int id);

    /**
     * 根据搜索条件搜索地毯
     * @param carpet
     * @return
     */
    List<Carpet> searchcarpet(Carpet carpet);

    /**
     * 根据搜索条件搜索地毯数量
     * @param carpet
     * @return
     */
    Integer searchcarpetnum(Carpet carpet);

    /**
     * 更新地毯信息
     * @param carpet
     * @return
     */
    Integer updatecarpet(Carpet carpet);

    /**
     * 获取批次
     * @param year
     * @return
     */
    List<Batch> getbatch(String year);
}
