package com.huerta.springboot.app.item.springbootserviceitem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.huerta.springboot.app.item.springbootserviceitem.models.entity.Item;
import com.huerta.springboot.app.item.springbootserviceitem.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAll() {
        return new ResponseEntity<List<Item>>(itemService.getAll(), HttpStatus.OK);
    }

    @GetMapping("items/{id}/amount/{amount}")
    public ResponseEntity<Item> getById(@PathVariable Long id, @PathVariable Integer amount) {
        return new ResponseEntity<>(itemService.getById(id, amount), HttpStatus.OK);
    }
}
 