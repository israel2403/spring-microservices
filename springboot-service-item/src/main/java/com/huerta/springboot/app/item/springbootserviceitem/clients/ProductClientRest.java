package com.huerta.springboot.app.item.springbootserviceitem.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.huerta.springboot.app.item.springbootserviceitem.models.entity.Product;

@FeignClient(name = "service-products", url = "localhost:8001")
public interface ProductClientRest {

    @GetMapping("/products")
    public List<Product> getAll();

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable final Long id);
}
