package com.nttdata.bootcamp.bank.operation.service.impl;

import com.nttdata.bootcamp.bank.operation.model.dao.inte.PassiveOperationDaoInte;
import com.nttdata.bootcamp.bank.operation.model.document.PassiveOperation;
import com.nttdata.bootcamp.bank.operation.model.webclient.Location;
import com.nttdata.bootcamp.bank.operation.service.inte.PassiveOperationServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PassiveOperationServiceImpl implements PassiveOperationServiceInte {

    private static final Logger log = LoggerFactory.getLogger(PassiveOperationServiceInte.class);

    private final WebClient webClient;

    public PassiveOperationServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8094").build();
    }

    @Autowired
    private PassiveOperationDaoInte passiveOpeartiontDaoInte;

    @Override
    public Mono<PassiveOperation> create(final PassiveOperation passiveOperation) {

        return passiveOpeartiontDaoInte.save(passiveOperation)
                .doFirst(() -> log.info("Begin create PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create PassiveOperation"));
    }

    @Override
    public Flux<PassiveOperation> readAll() {

        return passiveOpeartiontDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll PassiveOperation"));
    }

    /*@Override
    public Mono<PassiveOperation> readByCodePassiveOperation(String codePassiveOperation) {
        return passiveOpeartiontDaoInte.readByCodePassiveOperation(codePassiveOperation)
                .doFirst(() -> log.info("Begin readByCodePassiveOperation PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readByCodePassiveOperation PassiveOperation"));
    }*/

    @Override
    public Mono<PassiveOperation> readByCodePassiveOperation(String codePassiveOperation) {
        Location webclientLocation = new Location();
        Mono<Location> monoLocation = this.webClient.get().uri("/api/locations/readByCodeLocation/{codeLocation}", "L-0000000001").retrieve().bodyToMono(Location.class);

        return monoLocation.flatMap(x -> {
            webclientLocation.setId(x.getId());
            webclientLocation.setCodeLocation(x.getCodeLocation());
            webclientLocation.setName(x.getName());
            webclientLocation.setDescription(x.getDescription());
            webclientLocation.setState(x.getState());
            webclientLocation.setCodeLocationType(x.getCodeLocationType());
            webclientLocation.setCodeEmployee(x.getCodeEmployee());
            webclientLocation.setCodeUbigeo(x.getCodeUbigeo());

            log.debug("webclientLocation.getCodeLocation() = [" + webclientLocation.getCodeLocation() + "]");

            return passiveOpeartiontDaoInte.readByCodePassiveOperation(codePassiveOperation)
                    .doFirst(() -> log.info("Begin readByCodePassiveOperation PassiveOperation"))
                    .doOnNext(a -> log.info("webclientLocation.getCodeLocation() = [" + webclientLocation.getCodeLocation() + "]"))
                    .doAfterTerminate(() -> log.info("Finish readByCodePassiveOperation PassiveOperation"));
        });
    }

    @Override
    public Mono<PassiveOperation> updateById(final String id, final PassiveOperation passiveOperation) {

        return passiveOpeartiontDaoInte.save(passiveOperation)
                .doFirst(() -> log.info("Begin updateById PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById PassiveOperation"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return passiveOpeartiontDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById PassiveOperation"));
    }

}