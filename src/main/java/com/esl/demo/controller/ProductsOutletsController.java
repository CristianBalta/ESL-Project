package com.esl.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products-outlets")
public class ProductsOutletsController implements AbstractController{

    @Override
    public ResponseEntity getById(Object id) {
        return null;
    }

    @Override
    public ResponseEntity getAll() {
        return null;
    }

    @Override
    public ResponseEntity add(Object o) {
        return null;
    }

    @Override
    public ResponseEntity deleteById(Object id) {
        return null;
    }

    @Override
    public ResponseEntity update(Object o) {
        return null;
    }
}
