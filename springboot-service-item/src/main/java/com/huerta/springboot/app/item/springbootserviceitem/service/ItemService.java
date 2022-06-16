package com.huerta.springboot.app.item.springbootserviceitem.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.huerta.springboot.app.item.springbootserviceitem.models.entity.Item;
import com.huerta.springboot.app.item.springbootserviceitem.models.entity.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemService {

    private final RestTemplate clientRest;

    public List<Item> getAll() {
        List<Product> products = Arrays
                .asList(clientRest.getForObject("http://localhost:8001/products", Product[].class));
        return products.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    public Item getById(final Long id, Integer amount) {
        Map<String, String> pathVariables = new HashMap();
        pathVariables.put("id", id.toString());
        Product product = clientRest.getForObject("http://localhost:8001/products/{id}", Product.class, pathVariables);
        return new Item(product, amount);
    }
}
