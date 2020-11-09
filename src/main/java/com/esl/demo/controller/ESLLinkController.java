package com.esl.demo.controller;

import com.esl.demo.dto.ESLLinkDto;
import com.esl.demo.entity.compositeKeys.ESLLinkId;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.service.interfaces.ESLLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/api/esl-links")
public class ESLLinkController implements AbstractController<ESLLinkDto, ESLLinkId, Errors> {

    private final ESLLinkService eslLinkService;

    public ESLLinkController(ESLLinkService eslLinkService) {
        this.eslLinkService = eslLinkService;
    }

    @Override
    public ResponseEntity getById(ESLLinkId id) {
        return null;
    }

    @GetMapping("/esls/{eslId}/products/{productId}/outlets/{outletId}")
    public ResponseEntity getByComposedId(@PathVariable Long eslId, @PathVariable Long productId, @PathVariable Long outletId) {

        try {
            return ResponseEntity.ok(eslLinkService.getById(new ESLLinkId(eslId, productId, outletId)));
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        return ResponseEntity.ok(eslLinkService.getAll());
    }

    @PostMapping
    @Override
    public ResponseEntity add(@Valid @RequestBody ESLLinkDto eslLinkDto, Errors errors) {

        try {
            return ResponseEntity.ok(eslLinkService.add(eslLinkDto));
        } catch (ValidationException ex) {
            return new ResponseEntity(ErrorConstants.getErrorList(errors), HttpStatus.BAD_REQUEST);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/esls/{eslId}/products/{productId}/outlets/{outletId}")
    public ResponseEntity deleteByComposedId(@PathVariable Long eslId, @PathVariable Long productId, @PathVariable Long outletId) {

        try {
            eslLinkService.delete(new ESLLinkId(eslId, productId, outletId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deleteById(@PathVariable ESLLinkId id) {
        return null;
    }

    @PutMapping
    @Override
    public ResponseEntity update(@Valid @RequestBody ESLLinkDto eslLinkDto, Errors errors) {

        try {
            return ResponseEntity.ok(eslLinkService.update(eslLinkDto));
        } catch (ValidationException ex) {
            return new ResponseEntity(ErrorConstants.getErrorList(errors), HttpStatus.BAD_REQUEST);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
