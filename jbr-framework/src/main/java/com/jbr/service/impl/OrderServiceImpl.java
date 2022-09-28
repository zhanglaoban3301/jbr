/**
 * @author : zxw
 * @date : 2022-09-22 23:31
 * @version : 1.0
 **/
package com.jbr.service.impl;

import com.jbr.domain.entity.Order;
import com.jbr.mapper.OrderMapper;
import com.jbr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Integer addOrder(int carpetid, String batch, double price) {
        return orderMapper.addOrder(carpetid,batch,price);
    }

    @Override
    public List<Order> getorders(Order order) {
        return orderMapper.getorders(order);
    }

    @Override
    public Integer getordersnum(Order order) {
        return orderMapper.getordersnum(order);
    }
}
