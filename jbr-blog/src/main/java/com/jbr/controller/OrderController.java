/**
 * @author : zxw
 * @date : 2022-09-25 21:28
 * @version : 1.0
 **/
package com.jbr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbr.domain.entity.Carpet;
import com.jbr.domain.entity.Order;
import com.jbr.domain.pojo.RequestObj;
import com.jbr.domain.pojo.RespBean;
import com.jbr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Value("${pageSize}")
    private int pageSize;
    /**
     * 分页获取全部地毯
     * @param requestObj
     * @return
     */
    @PostMapping("/getorder")
    public RespBean GetOrder(@RequestBody RequestObj requestObj){

        int page = requestObj.getPage();

        Order order = new Order();
        order.setBatch(requestObj.getBatch());

        PageHelper.startPage(page,pageSize);
        List<Order> list = orderService.getorders(order);

        //根据查询的数据列表，得到分页的结果对象
        PageInfo<Order> pageList = new PageInfo<Order>(list);
        List<Order> data = pageList.getList();
        HashMap<String,Object> map = new HashMap();
        map.put("data",data);
        map.put("total",orderService.getordersnum(order));
        return  RespBean.success("查询成功",map);
    }
}
