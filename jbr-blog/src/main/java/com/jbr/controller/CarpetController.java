package com.jbr.controller;

import com.jbr.domain.entity.Carpet;
import com.jbr.domain.pojo.RespBean;
import com.jbr.service.CarpetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zxw
 * @Date 2022/9/8 21:22
 * @Description:
 * @Version 1.0
 */
@RestController
public class CarpetController {
    @Autowired
    private CarpetService carpetService;
    @PostMapping("/addcarpet")
    public RespBean AddCarpet(@RequestBody Carpet carpet){
        return RespBean.success("添加成功",carpetService.addcarpet(carpet));
    }

}
