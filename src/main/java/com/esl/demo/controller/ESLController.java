package com.esl.demo.controller;

import com.esl.demo.dto.ESLDto;
import com.esl.demo.rest.errors.BadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.rest.errors.ResourceNotFoundException;
import com.esl.demo.service.interfaces.ESLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/esls")
public class ESLController implements AbstractController<ESLDto, Long> {

    private final ESLService eslService;

    public ESLController(ESLService eslService) {
        this.eslService = eslService;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity getById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(eslService.getById(id));
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        try {
            return ResponseEntity.ok(eslService.getAll());
        } catch (BadRequestException ex) {
            throw new BadRequestException(ErrorConstants.ERR_EMPTY_LIST, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    @Override
    public ResponseEntity add(@RequestBody ESLDto eslDto) {

        try {
            return ResponseEntity.ok(eslService.add(eslDto));
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {

        try {
            eslService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity update(@RequestBody ESLDto eslDto) {

        try {
            return ResponseEntity.ok(eslService.update(eslDto));
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
