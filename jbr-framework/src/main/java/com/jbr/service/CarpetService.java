package com.jbr.service;

import com.jbr.domain.entity.Carpet;

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
}
