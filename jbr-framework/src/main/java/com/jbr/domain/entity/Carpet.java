package com.jbr.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * (Carpet)表实体类
 *
 * @author makejava
 * @since 2022-08-24 14:24:54
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carpet  {
    
    private String id;
    
    private String name;
    
    private String type;
    
    private Double price;
    
    private Double discount;
    
    private Double length;
    
    private Double width;
    
    private Double thickness;
    
    private String batch;
    
    private Date entrytime;
    
    private Date selltime;




}

