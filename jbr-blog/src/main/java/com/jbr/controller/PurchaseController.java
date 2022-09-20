package com.jbr.controller;

import com.jbr.domain.pojo.RespBean;
import com.jbr.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


/**
 * @Author zxw
 * @Date 2022/9/20 20:45
 * @Description:
 * @Version 1.0
 */
@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @GetMapping("/getpurchase")
    public RespBean getPurchase(int page){
        HashMap map = new HashMap();
        map.put("data",purchaseService.getPurchases(page));
        map.put("total",purchaseService.getPurchaseCount());
        return RespBean.success("查询成功",map);
    }
}
