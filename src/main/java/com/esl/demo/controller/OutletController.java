package com.esl.demo.controller;

import com.esl.demo.dto.OutletDto;
import com.esl.demo.rest.errors.BadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.rest.errors.ResourceNotFoundException;
import com.esl.demo.service.interfaces.OutletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/outlets")
public class OutletController implements AbstractController<OutletDto, Long> {

    private final OutletService outletService;

    public OutletController(OutletService outletService) {
        this.outletService = outletService;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity getById(@PathVariable Long id) {

        try {

            return ResponseEntity.ok(outletService.getById(id));

        } catch (ResourceNotFoundException ex) {

            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    @Override
    public ResponseEntity getAll() {

        try {

            return ResponseEntity.ok(outletService.getAll());

        } catch (BadRequestException ex) {
            throw new BadRequestException(ErrorConstants.ERR_EMPTY_LIST, HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping
    @Override
    public ResponseEntity add(@RequestBody OutletDto outletDto) {

        try {
            return ResponseEntity.ok(outletService.add(outletDto));

        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {

        try {

            outletService.delete(id);

        } catch (ResourceNotFoundException ex) {

            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);

    }

    @PutMapping
    @Override
    public ResponseEntity update(@RequestBody OutletDto outletDto) {

        try {
            return ResponseEntity.ok(outletService.update(outletDto));

        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException(ErrorConstants.ERR_ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

}
