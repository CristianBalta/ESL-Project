package com.esl.demo.controller;

import com.esl.demo.dto.OutletDto;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.service.interfaces.OutletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/api/outlets")
public class OutletController implements AbstractController<OutletDto, Long, Errors> {

    private final OutletService outletService;

    public OutletController(OutletService outletService) {
        this.outletService = outletService;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity getById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(outletService.getById(id));
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        return ResponseEntity.ok(outletService.getAll());
    }

    @PostMapping
    @Override
    public ResponseEntity add(@Valid @RequestBody OutletDto outletDto, Errors errors) {

        try {
            return ResponseEntity.ok(outletService.add(outletDto));
        } catch (ValidationException ex) {
            return new ResponseEntity(ErrorConstants.getErrorList(errors), HttpStatus.BAD_REQUEST);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {

        try {
            outletService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity update(@Valid @RequestBody OutletDto outletDto, Errors errors) {

        try {
            return ResponseEntity.ok(outletService.update(outletDto));
        } catch (ValidationException ex) {
            return new ResponseEntity(ErrorConstants.getErrorList(errors), HttpStatus.BAD_REQUEST);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
