package com.esl.demo.controller;

import com.esl.demo.dto.ESLDto;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.service.interfaces.ESLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/api/esls")
public class ESLController implements AbstractController<ESLDto, Long, Errors> {

    private final ESLService eslService;

    public ESLController(ESLService eslService) {
        this.eslService = eslService;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity getById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(eslService.getById(id));
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        return ResponseEntity.ok(eslService.getAll());
    }

    @PostMapping
    public ResponseEntity add(@Valid @RequestBody ESLDto eslDto, Errors errors) {

        try {
            return ResponseEntity.ok(eslService.add(eslDto));
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
            eslService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity update(@Valid @RequestBody ESLDto eslDto, Errors errors) {

        try {
            return ResponseEntity.ok(eslService.update(eslDto));
        } catch (ValidationException ex) {
            return new ResponseEntity(ErrorConstants.getErrorList(errors), HttpStatus.BAD_REQUEST);
        } catch (CustomBadRequestException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
