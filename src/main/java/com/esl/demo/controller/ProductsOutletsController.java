package com.esl.demo.controller;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.compositeKeys.LinkId;
import com.esl.demo.rest.errors.BadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.rest.errors.ResourceNotFoundException;
import com.esl.demo.service.interfaces.ProductsOutletsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products-outlets")
public class ProductsOutletsController implements AbstractController<ProductsOutletsDto, LinkId> {

    private final ProductsOutletsService productsOutletsService;

    public ProductsOutletsController(ProductsOutletsService productsOutletsService) {
        this.productsOutletsService = productsOutletsService;
    }

    @GetMapping("/products/{productId}/outlets/{outletId}")
    public ResponseEntity getByBothId(@PathVariable Long productId, @PathVariable Long outletId) {

        try {

            return ResponseEntity.ok(productsOutletsService.getById(new LinkId(productId,outletId)));

        } catch (ResourceNotFoundException ex) {

            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity getById(LinkId id) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        try {

            return ResponseEntity.ok(productsOutletsService.getAll());

        } catch (BadRequestException ex) {
            throw new BadRequestException(ErrorConstants.ERR_EMPTY_LIST, HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping
    @Override
    public ResponseEntity add(@RequestBody ProductsOutletsDto productsOutletsDto) {

        try {
            return ResponseEntity.ok(productsOutletsService.add(productsOutletsDto));

        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity deleteById(LinkId id) {
        return null;
    }

    @DeleteMapping("/products/{productId}/outlets/{outletId}")
    public ResponseEntity deleteByBothId(@PathVariable Long productId, @PathVariable Long outletId) {

        try {

            productsOutletsService.delete(new LinkId(productId, outletId));

        } catch (ResourceNotFoundException ex) {

            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);

    }

    @PutMapping
    @Override
    public ResponseEntity update(@RequestBody ProductsOutletsDto productsOutletsDto) {

        try {
            return ResponseEntity.ok(productsOutletsService.update(productsOutletsDto));

        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }


}
