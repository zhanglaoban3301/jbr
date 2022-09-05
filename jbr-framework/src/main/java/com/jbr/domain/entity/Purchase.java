package com.jbr.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * (Purchase)表实体类
 *
 * @author makejava
 * @since 2022-08-24 14:27:02
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase  {
    
    private String id;
    
    private Integer count;
    
    private String batch;
    
    private String type;
    
    private Double price;
    
    private Date purchasetime;




}

