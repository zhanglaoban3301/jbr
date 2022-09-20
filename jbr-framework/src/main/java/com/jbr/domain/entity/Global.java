/**
 * @author : zxw
 * @date : 2022-09-20 14:49
 * @version : 1.0
 **/
package com.jbr.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Global {
    private int id;
    private String key;
    private String value;
}
