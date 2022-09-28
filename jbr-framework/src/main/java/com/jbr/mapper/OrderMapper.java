package com.jbr.mapper;

import com.jbr.domain.entity.Carpet;
import com.jbr.domain.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 新增订单
     * @param carpetid
     * @param batch
     * @param money
     * @return
     */
    @Insert("insert into jbr.order(id,batch,price,selltime,carpetid,stockprice)" +
            "values(null,#{arg1},#{arg2},now(),#{arg0},(select price from jbr.carpet where id " +
            "= #{arg0} ))")
    Integer addOrder(int carpetid,String batch,double money);

    @Select("<script>" +
            "select * from  jbr.order where 1=1" +

            "<if test= 'batch!=null  ' >" +
            "and batch = #{batch}"+
            "</if>" +
            "</script>"
    )
    List<Order> getorders(Order order);

    @Select("<script>" +
            "select count(*) from  jbr.order where 1=1" +

            "<if test= 'batch!=null  ' >" +
            "and batch = #{batch}"+
            "</if>" +
            "</script>"
    )
    Integer getordersnum(Order order);
}
