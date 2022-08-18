package com.nttdata.bootcamp.bank.operation.model.dao.inte;

import com.nttdata.bootcamp.bank.operation.model.document.OperationPassive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface OperationPassiveDaoInte extends ReactiveMongoRepository<OperationPassive, String> {
    Mono<OperationPassive> readByCodeOperationPassive(String codeOperationPassive);

}
