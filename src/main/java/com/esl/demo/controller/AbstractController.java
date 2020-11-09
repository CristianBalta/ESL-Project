package com.esl.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

public interface AbstractController<T, K, E> {

    /**
     * @param id the id of the entity to be found
     * @return the entity if it exists
     * 404 otherwise
     */
    ResponseEntity getById(K id);

    /**
     * @return List of entities
     */
    ResponseEntity getAll();

    /**
     * @param t the entity to be added
     * @return the entity added + status ok
     * or status 409
     */
    ResponseEntity add(T t, E k);

    /**
     * @param id the id of the to be deleted entity
     * @return 200 if operation successfully
     * Else 404 +- message
     */
    ResponseEntity deleteById(K id);

    /**
     * @param t the new entity to be added. The id will be preserved
     * @return the updated entity + status ok if entity exists
     * 404 if the resource is not found
     */
    ResponseEntity update(T t, E k);
}
