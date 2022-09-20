package com.jbr.service.impl;

import com.jbr.domain.entity.Purchase;
import com.jbr.mapper.PurchaseMapper;
import com.jbr.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zxw
 * @Date 2022/9/20 20:36
 * @Description:
 * @Version 1.0
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Value("${pageSize}")
    private int pageSize;

    @Override
    public void groupPurchase() {
        //删除数据
        purchaseMapper.deletepurchase();
        //查询数据
        List<Purchase> purchases = purchaseMapper.groupPurchase();
        //新增数据
        for (Purchase purchase : purchases) {
             purchaseMapper.addpurchase(purchase);
        }
    }


    @Override
    public List<Purchase> getPurchases(int page) {
        groupPurchase();
        return purchaseMapper.getPurchase((page-1)*pageSize,pageSize*page);
    }

    @Override
    public Integer getPurchaseCount() {
        return purchaseMapper.getPurchaseCount();
    }
}
