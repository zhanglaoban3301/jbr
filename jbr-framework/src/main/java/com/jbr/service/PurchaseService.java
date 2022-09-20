package com.jbr.service;

import com.jbr.domain.entity.Purchase;

import java.util.List;

/**
 * @Author zxw
 * @Date 2022/9/20 20:35
 * @Description:
 * @Version 1.0
 */
public interface PurchaseService {
    /**
     * 按照批次将地毯分组
     * @return
     */
    void groupPurchase();

    /**
     * 分页查询进货记录
     * @return
     */
    List<Purchase> getPurchases(int page);

    /**
     * 获取总数
     * @return
     */
    Integer getPurchaseCount();
}
