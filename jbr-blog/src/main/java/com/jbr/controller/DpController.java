/**
 * @author : zxw
 * @date : 2022-09-24 21:16
 * @version : 1.0
 **/
package com.jbr.controller;

import com.jbr.domain.pojo.OrderList;
import com.jbr.service.DpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class DpController {
    @Autowired
    private DpService DpService;

    @GetMapping("/getDpHeader")
    public HashMap getDpHeader() {
        return DpService.getDpHeader();
    }

    @GetMapping("/getSellByMonth")
    public List<Map> getSellByMonth() {

        List<Map> ListMap = new ArrayList<Map>();
        HashMap<String, Long> result = DpService.getSellByMonth();
        for (Map.Entry<String, Long> entry : result.entrySet()) {
            String mapKey = entry.getKey();
            Long mapValue = entry.getValue();

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", mapKey);
            map.put("value", mapValue);
            ListMap.add(map);
        }
        return ListMap;

    }

    @GetMapping("/getSellFbByMonth")
    public List<Map> getSellFbByMonth() {

        List<Map> ListMap = new ArrayList<Map>();
        HashMap<String, Double> result = DpService.getSellFbByMonth();
        for (Map.Entry<String, Double> entry : result.entrySet()) {
            String mapKey = entry.getKey();
            Double mapValue = entry.getValue();

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", mapKey);
            map.put("value", mapValue);
            ListMap.add(map);
        }
        return ListMap;

    }

    @GetMapping("/getSellBlByMonth")
    public Object getSellBlByMonth() {
        List<Map> ListMap = new ArrayList<Map>();
        HashMap<String, Double> result = DpService.getSellBlByMonth();
        for (Map.Entry<String, Double> entry : result.entrySet()) {
            String mapKey = entry.getKey();
            Double mapValue = entry.getValue();

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", mapKey);
            map.put("value", mapValue);
            ListMap.add(map);
        }
        return ListMap;
    }

    @GetMapping("/getOrderList")
    public List<OrderList> getOrderList() {
        List<OrderList> result = DpService.getOrderList();
        List list = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (OrderList item : result) {
            List list1 = new ArrayList();
            list1.add(sdf.format(item.getSelltime()));
            list1.add(item.getBatch());
            list1.add(item.getName());
            list1.add(item.getType());
            list1.add(item.getPrice());
            list.add(list1);
        }

        return list;
    }

    @GetMapping("/getSellInfoBetweenFive")
    public List<Map> getSellInfoBetweenFive() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map> result = DpService.getSellInfoBetweenFive();
        List list = new ArrayList();
        Double d = 0.0d;
        for (Map item1 : result) {
            d += (double) item1.get("totalprice");
        }
        for (Map item2 : result) {
            Calendar cal= Calendar.getInstance();
            HashMap map = new HashMap();
            map.put("该日金额",item2.get("totalprice"));
            map.put("售出地毯",item2.get("total"));
            map.put("资金占比",d==0?100:String.format("%.4f",(double)item2.get("totalprice")/d * 100)  );
            String time = "";
            String selltime = sdf.format((Date)item2.get("selltime"));

            if(selltime.equals(sdf.format(new Date()))){
                time = "今日";
            }else {
                time = selltime;
            }
            map.put("time",time);
            list.add(map);
        }
        return list;
    }
}
