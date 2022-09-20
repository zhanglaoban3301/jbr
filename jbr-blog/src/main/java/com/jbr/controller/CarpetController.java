package com.jbr.controller;

import com.jbr.domain.entity.Batch;
import com.jbr.domain.entity.Carpet;
import com.jbr.domain.pojo.RespBean;
import com.jbr.service.CarpetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/getcarpet")
    public RespBean GetCarpet(int page){
        HashMap map = new HashMap();
        map.put("data",carpetService.getcarpet(page));
        map.put("total",carpetService.total());
        return  RespBean.success("查询成功",map);
    }
    @GetMapping("/getbatch")
    public List<Batch> GetBatch(String year){
        return carpetService.getbatch(year);
    }
    @GetMapping("/deletecarpet")
    public RespBean Detelecarpet(int id){
        return RespBean.success("删除成功",carpetService.detelecarpet(id));
    }
    @PostMapping("/searchcarpet")
    public RespBean SearchCarpet(@RequestBody Carpet carpet){
        HashMap map = new HashMap();
        map.put("data",carpetService.searchcarpet(carpet));
        map.put("total",carpetService.searchcarpetnum(carpet));
        return RespBean.success("查询成功",map);
    }

    @PostMapping("/updatecarpet")
    public RespBean UpdateCarpet(@RequestBody Carpet carpet){
        return RespBean.success("编辑数据成功",carpetService.updatecarpet(carpet));
    }


}
