package com.jbr.service;

import com.jbr.domain.entity.Order;

import java.util.List;

public interface OrderService {
    /**
     * 新增订单
     * @param carpetid
     * @param batch
     * @param price
     * @return
     */
    Integer addOrder(int carpetid,String batch,double price);

    /**
     * 获取订单
     * @param order
     * @return
     */
    List<Order> getorders(Order order);

    /**
     * 获取全部订单
     * @param order
     * @return
     */
    Integer getordersnum(Order order);
}
