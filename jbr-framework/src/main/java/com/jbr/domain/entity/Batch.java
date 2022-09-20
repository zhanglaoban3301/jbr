/**
 * @author : zxw
 * @date : 2022-09-20 15:47
 * @version : 1.0
 **/
package com.jbr.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    private int id;
    private String year;
    private String name;
}
