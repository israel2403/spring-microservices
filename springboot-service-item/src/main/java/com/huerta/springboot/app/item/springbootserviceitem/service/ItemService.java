package com.huerta.springboot.app.item.springbootserviceitem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.huerta.springboot.app.item.springbootserviceitem.clients.ProductClientRest;
import com.huerta.springboot.app.item.springbootserviceitem.models.entity.Item;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemService {

    // private final RestTemplate clientRest;

    private final ProductClientRest productClientRest;

    /*
     * This way is with restTemplate
     * public List<Item> getAll() {
     * List<Product> products = Arrays
     * .asList(clientRest.getForObject("http://localhost:8001/products",
     * Product[].class));
     * return products.stream().map(product -> new Item(product,
     * 1)).collect(Collectors.toList());
     * }
     */

    // Using feing
    public List<Item> getAll() {
        return productClientRest.getAll().stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    /*
     * // Using RestTemplate
     * public Item getById(final Long id, Integer amount) {
     * Map<String, String> pathVariables = new HashMap<>();
     * pathVariables.put("id", id.toString());
     * Product product =
     * clientRest.getForObject("http://localhost:8001/products/{id}", Product.class,
     * pathVariables);
     * return new Item(product, amount);
     * }
     */

    // Using Feing
    public Item getById(final Long id, Integer amount) {
        return new Item(productClientRest.getById(id), amount);
    }
}
