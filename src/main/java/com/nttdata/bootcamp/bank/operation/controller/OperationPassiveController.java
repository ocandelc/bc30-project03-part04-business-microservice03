package com.nttdata.bootcamp.bank.operation.controller;

import com.nttdata.bootcamp.bank.operation.model.document.OperationPassive;
import com.nttdata.bootcamp.bank.operation.service.inte.OperationPassiveServiceInte;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/operationPassive")
public class OperationPassiveController {

    private static final Logger log = LoggerFactory.getLogger(OperationPassiveServiceInte.class);

    @Autowired
    private OperationPassiveServiceInte operationPassiveServiceInte;

    @PostMapping("create")
    public Mono<OperationPassive> create(@RequestBody final OperationPassive operationPassive) {
        log.debug("Begin RestController create OperationPassive");
        return operationPassiveServiceInte.create(operationPassive);
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

    @PutMapping("update/{id}")
    public Mono<OperationPassive> updateById(@RequestBody final OperationPassive operationPassive, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById OperationPassive");
        return operationPassiveServiceInte.updateById(id, operationPassive);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById PassiveOperation");
        return operationPassiveServiceInte.deleteById(id);
    }

}