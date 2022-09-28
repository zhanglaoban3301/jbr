/**
 * @author : zxw
 * @date : 2022-09-24 21:14
 * @version : 1.0
 **/
package com.jbr.service.impl;

import com.jbr.domain.pojo.OrderList;
import com.jbr.mapper.DpSqlMapper;
import com.jbr.service.DpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DpServiceImpl implements DpService {

    @Autowired
    private DpSqlMapper dpSqlMapper;

    @Override
    public HashMap getDpHeader() {
        return dpSqlMapper.getDpHeader();
    }

    @Override
    public HashMap<String,Long> getSellByMonth() {
        return dpSqlMapper.getSellByMonth();
    }

    @Override
    public HashMap getSellFbByMonth() {
        return dpSqlMapper.getSellFbByMonth();
    }

    @Override
    public HashMap getSellBlByMonth() {
        return dpSqlMapper.getSellBlByMonth();
    }

    @Override
    public List<OrderList> getOrderList() {
        return dpSqlMapper.getOrderList();
    }

    @Override
    public List<Map> getSellInfoBetweenFive() {
        return dpSqlMapper.getSellInfoBetweenFive();
    }
}
