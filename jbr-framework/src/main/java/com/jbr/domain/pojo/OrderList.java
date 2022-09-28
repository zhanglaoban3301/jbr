/**
 * @author : zxw
 * @date : 2022-09-25 17:04
 * @version : 1.0
 **/
package com.jbr.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {
    private Date selltime;
    private String batch;
    private String name;
    private String type;
    private double price;

}
