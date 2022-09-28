/**
 * @author : zxw
 * @date : 2022-09-24 21:09
 * @version : 1.0
 **/
package com.jbr.service;


import com.jbr.domain.pojo.OrderList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DpService {
    /**
     * 大屏头部
     * @return
     */
    HashMap getDpHeader();

    /**
     *  1-12月销售数量统计
     * @return
     */
    HashMap<String,Long> getSellByMonth();

    /**
     * 每月售出资金分布
     * @return
     */
    HashMap getSellFbByMonth();

    /**
     * 每月收入情况
     * @return
     */
    HashMap getSellBlByMonth();

    /**
     * 获得订单列表
     * @return
     */
    List<OrderList> getOrderList();

    /**
     * 最近五日情况
     * @return
     */
    List<Map> getSellInfoBetweenFive();
}
