package com.jbr.mapper;

import com.jbr.domain.entity.Purchase;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author zxw
 * @Date 2022/9/20 20:32
 * @Description:
 * @Version 1.0
 */
@Mapper
public interface PurchaseMapper {
    /**
     * 按照批次将地毯分组
     * @return
     */
    @Select("select batch , sum(price) as price,count(price) as count ,max(entrytime) as purchasetime from carpet group by batch")
    List<Purchase> groupPurchase();

    /**
     * 新增进货记录
     * @param purchase
     * @return
     */
    @Insert("insert into jbr.purchase(id,count,batch,price,purchasetime) values(null,#{count}," +
            "#{batch},#{price},#{purchasetime} )")
    Integer addpurchase(Purchase purchase);

    @Select("select * from jbr.purchase where 1=1 limit #{arg0},#{arg1}")
    List<Purchase> getPurchase(int page,int pageSize);

    /**
     * 删除进货记录
     * @return
     */
    @Delete("delete from jbr.purchase")
    Integer deletepurchase();

    /**
     *
     */
    @Select("select count(*) from jbr.purchase")
    Integer getPurchaseCount();
}
