package com.jbr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbr.domain.entity.Batch;
import com.jbr.domain.entity.Carpet;
import com.jbr.domain.pojo.RequestObj;
import com.jbr.domain.pojo.RespBean;
import com.jbr.service.CarpetService;
import com.jbr.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private OrderService orderService;
    @Value("${pageSize}")
    private int pageSize;

    /**
     * 添加地毯
     * @param carpet
     * @return
     */
    @PostMapping("/addcarpet")
    public RespBean AddCarpet(@RequestBody Carpet carpet){
        return RespBean.success("添加成功",carpetService.addcarpet(carpet));
    }

    /**
     * 分页获取全部地毯
     * @param requestObj
     * @return
     */
    @PostMapping("/getcarpet")
    public RespBean GetCarpet(@RequestBody RequestObj requestObj){

        int page = requestObj.getPage();

        Carpet carpet = new Carpet();
        carpet.setBatch(requestObj.getBatch());
        carpet.setName(requestObj.getName());
        carpet.setId(requestObj.getId());
        carpet.setEntrytime(requestObj.getEntrytime());
        carpet.setType(requestObj.getType());
        carpet.setState(requestObj.getState());
        PageHelper.startPage(page,pageSize);
        List<Carpet> list = carpetService.searchcarpet(carpet);

        //根据查询的数据列表，得到分页的结果对象
        PageInfo<Carpet> pageList = new PageInfo<Carpet>(list);
        List<Carpet> data = pageList.getList();
        HashMap<String,Object> map = new HashMap();
        map.put("data",data);
        map.put("total",carpetService.searchcarpetnum(carpet));
        return  RespBean.success("查询成功",map);
    }

    /**
     * 根据年份获取批次
     * @param year
     * @return
     */
    @GetMapping("/getbatch")
    public List<Batch> GetBatch(String year){
        return carpetService.getbatch(year);
    }

    /**
     * 删除地毯 by id
     * @param id
     * @return
     */
    @GetMapping("/deletecarpet")
    public RespBean Detelecarpet(int id){
        return RespBean.success("删除成功",carpetService.detelecarpet(id));
    }

    /**
     * 编辑地毯信息
     * @param carpet
     * @return
     */
    @PostMapping("/updatecarpet")
    public RespBean UpdateCarpet(@RequestBody Carpet carpet){
        return RespBean.success("编辑数据成功",carpetService.updatecarpet(carpet));
    }
    @GetMapping("/sellcarpet")
    public RespBean SellCarpet(int id,String batch,double money){
        orderService.addOrder(id,batch,money);
        return RespBean.success("售卖成功",carpetService.sellCarpet(id));
    }

}
