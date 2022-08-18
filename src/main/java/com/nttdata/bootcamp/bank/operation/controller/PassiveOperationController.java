package com.nttdata.bootcamp.bank.operation.controller;

import com.nttdata.bootcamp.bank.operation.model.document.PassiveOperation;
import com.nttdata.bootcamp.bank.operation.model.webclient.Location;
import com.nttdata.bootcamp.bank.operation.service.inte.PassiveOperationServiceInte;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/passiveoperations")
public class PassiveOperationController {

    private static final Logger log = LoggerFactory.getLogger(PassiveOperationServiceInte.class);

    @Autowired
    private PassiveOperationServiceInte passiveOperationServiceInte;

    @PostMapping("create")
    public Mono<PassiveOperation> create(@RequestBody final PassiveOperation passiveOperation) {
        log.debug("Begin RestController create PassiveOperation");
        return passiveOperationServiceInte.create(passiveOperation);
    }

    @GetMapping
    public Flux<PassiveOperation> readAll() {
        log.debug("Begin RestController readAll PassiveOperation");
        return passiveOperationServiceInte.readAll();
    }

    /*@GetMapping("/findByCodePassiveOperation/{codePassiveOperation}")
    public Mono<PassiveOperation> readByCodePassiveOperation(@PathVariable String codePassiveOperation) {
        log.debug("Begin RestController readByCodePassiveOperation PassiveOperation");
        return passiveOperationServiceInte.readByCodePassiveOperation(codePassiveOperation);
    }*/

    @GetMapping("/findByCodePassiveOperation/{codePassiveOperation}")
    @CircuitBreaker(name="circuitbreaker-business-microservice03-operation", fallbackMethod = "readByCodePassiveOperationFallBack")
    public Mono<PassiveOperation> readByCodePassiveOperation(@PathVariable String codePassiveOperation) {
        log.debug("Begin RestController readByCodePassiveOperation PassiveOperation");
        return passiveOperationServiceInte.readByCodePassiveOperation(codePassiveOperation);
    }

    public Mono<String> readByCodePassiveOperationFallBack(String codePassiveOperation, RuntimeException runtimeException) {
        return Mono.just("El endpoint readByCodeLocation del api bc30-project02-part04-business-microservice04 (Location)  no está respondiendo. Por favor, comunicarse con el Departamento de Tecnología de Información.");
    }

    @PutMapping("update/{id}")
    public Mono<PassiveOperation> updateById(@RequestBody final PassiveOperation passiveOperation, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById PassiveOperation");
        return passiveOperationServiceInte.updateById(id, passiveOperation);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById PassiveOperation");
        return passiveOperationServiceInte.deleteById(id);
    }

}