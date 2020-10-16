package com.esl.demo.controller;

import com.esl.demo.dto.ProductDto;
import com.esl.demo.rest.errors.BadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.rest.errors.ResourceNotFoundException;
import com.esl.demo.service.interfaces.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        } catch (ResourceNotFoundException ex) {

            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        try {

            return ResponseEntity.ok(productService.getAll());

        } catch (BadRequestException ex) {
            throw new BadRequestException(ErrorConstants.ERR_EMPTY_LIST, HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping
    @Override
    public ResponseEntity add(@RequestBody ProductDto productDto) {

        try {
            return ResponseEntity.ok(productService.add(productDto));

        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {

        try {

            productService.delete(id);

        } catch (ResourceNotFoundException ex) {

            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);

    }

    @PutMapping
    @Override
    public ResponseEntity update(@RequestBody ProductDto productDto) {

        try {
            return ResponseEntity.ok(productService.update(productDto));

        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

}
