package com.nttdata.bootcamp.bank.operation.service.inte;

import com.nttdata.bootcamp.bank.operation.model.document.OperationPassive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OperationPassiveServiceInte {

    Mono<OperationPassive> create(final OperationPassive operationPassive);

    Flux<OperationPassive> readAll();

    Mono<OperationPassive> readByCodeOperationPassive(String codeOperationPassive);

    Mono<OperationPassive> updateById(final String id, final OperationPassive operationPassive);

    Mono<Void> deleteById(final String id);
}