package com.huerta.springboot.app.products.springbootserviceproducts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huerta.springboot.app.products.springbootserviceproducts.dao.ProductDAO;
import com.huerta.springboot.app.products.springbootserviceproducts.models.entity.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        log.info("product list: {} ", productDAO.findAll());
        List<Product> products = new ArrayList<>();
        productDAO.findAll().forEach(product -> {
            log.info("Product: {}", product.getName());
            products.add(product);
        });
        return products;
    }

    @Transactional(readOnly = true)
    public Product getById(final Long id) {
        return productDAO.findById(id).orElse(null);
    }
}
