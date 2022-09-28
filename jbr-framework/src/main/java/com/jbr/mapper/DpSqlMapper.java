package com.jbr.mapper;

import com.jbr.domain.pojo.OrderList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxw
 */
@Mapper
public interface DpSqlMapper {
    /**
     * 查询大屏综合数据
     * @return
     */
    @Select("select\n" +
            "    count(*) as zkcnum,\n" +
            "    count(case when state = '1' then 1 end ) as yscnum,\n" +
            "    count(case when state = '0' then 1 end ) as wscnum,\n" +
            "    count(case when year(entrytime) <YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) then 1 end ) as zxnum,\n" +
            "    count(case when DATEDIFF(selltime,NOW())=0 then 1 end ) as  jrscnum,\n" +
            "    count(case when yearweek(date_format(selltime,'%Y-%m-%d'),1) =  yearweek(now(),1) then 1 end ) as  bzscnum,\n" +
            "    count(case when date_format(selltime,'%Y%m') =  DATE_FORMAT( now() , '%Y%m' ) then 1 end ) as  byscnum\n" +
            "\n" +
            "from jbr.carpet")
    HashMap getDpHeader();

    /**
     * 1-12月销售数量统计
     * @return
     */
    @Select("select\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202201' then 1 end) as 1月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202202' then 1 end) as 2月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202203' then 1 end) as 3月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202204' then 1 end) as 4月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202205' then 1 end) as 5月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202206' then 1 end) as 6月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202207' then 1 end) as 7月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202208' then 1 end) as 8月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '202209' then 1 end) as 9月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '2022010' then 1 end) as 10月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '2022011' then 1 end) as 11月,\n" +
            "    count(case when DATE_FORMAT( selltime, '%Y%m' ) = '2022011' then 1 end) as 12月\n" +
            "from jbr.carpet where state = '1' and YEAR(selltime)=YEAR(NOW())")
    HashMap<String,Long> getSellByMonth();

    /**
     * 每月售出资金分布
     * @return
     */
    @Select("select\n" +
            " Jan/total * 100 as 1月,\n" +
            " Feb/total * 100 as 2月,\n" +
            " Mar/total * 100 as 3月,\n" +
            " Apr/total * 100 as 4月,\n" +
            " May/total * 100 as 5月,\n" +
            " Jun/total * 100 as 6月,\n" +
            " Jul/total * 100 as 7月,\n" +
            " Aug/total * 100 as 8月,\n" +
            " Sept/total * 100 as 9月,\n" +
            " Oct/total * 100 as 10月,\n" +
            " Nov/total * 100 as 11月,\n" +
            " Dece/total * 100 as 12月\n" +
            "from (\n" +
            "select\n" +
            "    sum(price) as total,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202201' then price end) as Jan,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202202' then price end) as Feb,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202203' then price end) as Mar,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202204' then price end) as Apr,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202205' then price end) as May,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202206' then price end) as Jun,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202207' then price end) as Jul,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202208' then price end) as Aug,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '202209' then price end) as Sept,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '2022010' then price end) as Oct,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '2022011' then price end) as Nov,\n" +
            "    sum(case when DATE_FORMAT( selltime, '%Y%m' ) = '2022011' then price end) as Dece\n" +
            "from jbr.`order` where  YEAR(selltime)=YEAR(NOW())   ) t")
    HashMap getSellFbByMonth();

    /**
     * 每月收入情况
     * @return
     */
    @Select("select round((t.bytotal/t.total * 100),2) as result,t.total from (\n" +
            "select\n" +
            "    sum(case when DATE_FORMAT(selltime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m') then price end) as bytotal,\n" +
            "    sum(price) as total\n" +
            "from jbr.`order` where   YEAR(selltime)=YEAR(NOW()))t")
    HashMap getSellBlByMonth();

    /**
     * 大屏订单
     * @return
     */
    @Select("select A.selltime ,A.batch,B.name,B.type,A.price from jbr.order A  inner join jbr.carpet B on A.carpetid = B.id order by selltime desc limit 0,10")
    List<OrderList> getOrderList();

    /**
     * 最近五日情况
     * @return
     */
    @Select("select selltime,sum(price) as totalprice, count(*) as total from jbr.order where TO_DAYS(NOW())  - TO_DAYS(selltime) <= 5\n" +
            "group by selltime order by selltime desc limit 0,5")
    List<Map> getSellInfoBetweenFive();
}
