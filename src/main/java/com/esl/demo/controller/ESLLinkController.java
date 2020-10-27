package com.esl.demo.controller;

import com.esl.demo.dto.ESLLinkDto;
import com.esl.demo.entity.compositeKeys.ESLLinkId;
import com.esl.demo.rest.errors.BadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.rest.errors.ResourceNotFoundException;
import com.esl.demo.service.interfaces.ESLLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/esl-links")
public class ESLLinkController implements AbstractController<ESLLinkDto, ESLLinkId> {

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
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        try {
            return ResponseEntity.ok(eslLinkService.getAll());
        } catch (BadRequestException ex) {
            throw new BadRequestException(ErrorConstants.ERR_EMPTY_LIST, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    @Override
    public ResponseEntity add(@RequestBody ESLLinkDto eslLinkDto) {

        try {
            return ResponseEntity.ok(eslLinkService.add(eslLinkDto));
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/esls/{eslId}/products/{productId}/outlets/{outletId}")
    public ResponseEntity deleteByComposedId(@PathVariable Long eslId, @PathVariable Long productId, @PathVariable Long outletId) {

        try {
            eslLinkService.delete(new ESLLinkId(eslId, productId, outletId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity deleteById(@PathVariable ESLLinkId id) {
        return null;
    }

    @PutMapping
    @Override
    public ResponseEntity update(@RequestBody ESLLinkDto eslLinkDto) {

        try {
            return ResponseEntity.ok(eslLinkService.update(eslLinkDto));
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
