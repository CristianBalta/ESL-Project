package com.esl.demo.controller;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.compositeKeys.ProductsOutletsLinkId;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.service.interfaces.ProductsOutletsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/api/products-outlets")
public class ProductsOutletsController implements AbstractController<ProductsOutletsDto, ProductsOutletsLinkId, Errors> {

    private final ProductsOutletsService productsOutletsService;

    public ProductsOutletsController(ProductsOutletsService productsOutletsService) {
        this.productsOutletsService = productsOutletsService;
    }

    @GetMapping("/products/{productId}/outlets/{outletId}")
    public ResponseEntity getByBothId(@PathVariable Long productId, @PathVariable Long outletId) {

        try {
            return ResponseEntity.ok(productsOutletsService.getById(new ProductsOutletsLinkId(productId, outletId)));
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity getById(ProductsOutletsLinkId id) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        return ResponseEntity.ok(productsOutletsService.getAll());
    }

    @PostMapping
    @Override
    public ResponseEntity add(@Valid @RequestBody ProductsOutletsDto productsOutletsDto, Errors errors) {

        try {
            return ResponseEntity.ok(productsOutletsService.add(productsOutletsDto));
        } catch (ValidationException ex) {
            return new ResponseEntity(ErrorConstants.getErrorList(errors), HttpStatus.BAD_REQUEST);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deleteById(ProductsOutletsLinkId id) {
        return null;
    }

    @DeleteMapping("/products/{productId}/outlets/{outletId}")
    public ResponseEntity deleteByBothId(@PathVariable Long productId, @PathVariable Long outletId) {

        try {
            productsOutletsService.delete(new ProductsOutletsLinkId(productId, outletId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity update(@Valid @RequestBody ProductsOutletsDto productsOutletsDto, Errors errors) {

        try {
            return ResponseEntity.ok(productsOutletsService.update(productsOutletsDto));
        } catch (ValidationException ex) {
            return new ResponseEntity(ErrorConstants.getErrorList(errors), HttpStatus.BAD_REQUEST);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
