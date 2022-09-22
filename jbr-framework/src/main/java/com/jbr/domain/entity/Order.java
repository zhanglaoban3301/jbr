package com.jbr.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * (Order)表实体类
 *
 * @author makejava
 * @since 2022-08-24 14:26:40
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order  {
    
    private String id;
    
    private Integer count;
    
    private String batch;
    
    private int carpetid;
    
    private Double price;
    
    private Date selltime;




}

