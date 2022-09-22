/**
 * @author : zxw
 * @date : 2022-09-22 15:12
 * @version : 1.0
 **/
package com.jbr.domain.pojo;

import com.jbr.domain.entity.Carpet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestObj {
    private int page;
    private Date entrytime;
    private int id;
    private String name;
    private String batch;
    private Double price;
    private String region;
    private String type;
}
