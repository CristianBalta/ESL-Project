package com.esl.demo.controller;

import com.esl.demo.dto.ProductDto;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.service.interfaces.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController implements AbstractController<ProductDto, Long> {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity getById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(productService.getById(id));
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    @Override
    public ResponseEntity add(@Valid @RequestBody ProductDto productDto) {

        return ResponseEntity.ok(productService.add(productDto));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {

        try {
            productService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity update(@Valid @RequestBody ProductDto productDto) {

        try {
            return ResponseEntity.ok(productService.update(productDto));
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
