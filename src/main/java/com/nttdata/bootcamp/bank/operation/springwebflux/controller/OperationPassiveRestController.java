/**
 * Resumen.
 * Objeto                   : OperationPassiveController.java
 * Descripción              : Clase de controladora para invocar los métodos con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              05/08/2022        Mario Vásquez           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.bank.operation.springwebflux.controller;

import com.nttdata.bootcamp.bank.operation.springdata.document.OperationPassive;
//import com.nttdata.bootcamp.bank.operation.springdata.service.inte.JpaOperationPassiveServiceInte;
import com.nttdata.bootcamp.bank.operation.springwebflux.service.inte.OperationPassiveServiceInte;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar los métodos con rest api.
 */
@RestController
@RequestMapping("/api/operationPassive")
public class OperationPassiveRestController {

    private static final Logger log = LoggerFactory.getLogger(OperationPassiveServiceInte.class);

    @Autowired
    private OperationPassiveServiceInte operationPassiveServiceInte;

    @PostMapping
    public Mono<OperationPassive> create(@RequestBody final OperationPassive operationPassive) throws InterruptedException {
        log.debug("Begin RestController create OperationPassive");
        return operationPassiveServiceInte.insert(operationPassive);
    }

    @GetMapping
    public Flux<OperationPassive> readAll() {
        log.debug("Begin RestController readAll OperationPassive");
        return operationPassiveServiceInte.readAll();
    }

    @GetMapping("/readByCodeOperationPassive/{codeOperationPassive}")
    @CircuitBreaker(name="circuitbreaker-business-microservice03-operation", fallbackMethod = "readByCodeOperationPassiveFallBack")
    public Mono<OperationPassive> readByCodeOperationPassive(@PathVariable String codeOperationPassive) {
        log.debug("Begin RestController readByCodeOperationPassive OperationPassive");
        return operationPassiveServiceInte.readByCodeOperationPassive(codeOperationPassive);
    }

    public Mono<String> readByCodeOperationPassiveFallBack(String codeOperationPassive, RuntimeException runtimeException) {
        return Mono.just("El endpoint readByCodeLocation del api bc30-project03-part04-business-microservice04 (Location)  no está respondiendo. Por favor, comunicarse al teléfono 444-0000 y anexo 1234 con el equipo de soporte de sistemas del Departamento de Tecnología de Información.");
    }

    @PutMapping("{id}")
    public Mono<OperationPassive> updateById(@RequestBody final OperationPassive operationPassive, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById OperationPassive");
        return operationPassiveServiceInte.updateById(id, operationPassive);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById OperationPassive");
        return operationPassiveServiceInte.deleteById(id);
    }

}