package com.huerta.springboot.app.item.springbootserviceitem.models.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private Date createdAt;
}
