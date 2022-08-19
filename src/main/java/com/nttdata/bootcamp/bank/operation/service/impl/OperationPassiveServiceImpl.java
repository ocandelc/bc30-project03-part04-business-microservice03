/**
 * Resumen.
 * Objeto                   : OperationPassiveServiceInte.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.bank.operation.service.impl;

import com.nttdata.bootcamp.bank.operation.model.dao.inte.OperationPassiveDaoInte;
import com.nttdata.bootcamp.bank.operation.model.document.OperationPassive;
import com.nttdata.bootcamp.bank.operation.model.webclient.Location;
import com.nttdata.bootcamp.bank.operation.service.inte.OperationPassiveServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de implementación de servicio para utilizar los métodos de CRUD.
 */
@Service
public class OperationPassiveServiceImpl implements OperationPassiveServiceInte {

    private static final Logger log = LoggerFactory.getLogger(OperationPassiveServiceInte.class);

    private final WebClient webClient;

    public OperationPassiveServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8094").build();
    }

    @Autowired
    private OperationPassiveDaoInte operationPassiveDaoInte;

    @Override
    public Mono<OperationPassive> create(final OperationPassive operationPassive) {

        return operationPassiveDaoInte.save(operationPassive)
                .doFirst(() -> log.info("Begin create OperationPassive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create OperationPassive"));
    }

    @Override
    public Flux<OperationPassive> readAll() {

        return operationPassiveDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll OperationPassive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll OperationPassive"));
    }

    @Override
    public Mono<OperationPassive> readByCodeOperationPassive(String codeOperationPassive) {
        Location webclientLocation = new Location();
        Mono<Location> monoLocation = this.webClient.get().uri("/api/location/readByCodeLocation/{codeLocation}", "L-0000000001").retrieve().bodyToMono(Location.class);

        return monoLocation.flatMap(x -> {
            webclientLocation.setId(x.getId());
            webclientLocation.setCodeLocation(x.getCodeLocation());
            webclientLocation.setName(x.getName());
            webclientLocation.setDescription(x.getDescription());
            webclientLocation.setState(x.getState());
            webclientLocation.setCodeLocationType(x.getCodeLocationType());
            webclientLocation.setCodeUbigeo(x.getCodeUbigeo());

            log.debug("webclientLocation.getCodeLocation() = [" + webclientLocation.getCodeLocation() + "]");

            return operationPassiveDaoInte.readByCodeOperationPassive(codeOperationPassive)
                    .doFirst(() -> log.info("Begin readByCodePassiveOperation OperationPassive"))
                    .doOnNext(a -> log.info("webclientLocation.getCodeLocation() = [" + webclientLocation.getCodeLocation() + "]"))
                    .doAfterTerminate(() -> log.info("Finish readByCodePassiveOperation OperationPassive"));
        });
    }

    @Override
    public Mono<OperationPassive> updateById(final String id, final OperationPassive operationPassive) {

        return operationPassiveDaoInte.save(operationPassive)
                .doFirst(() -> log.info("Begin updateById OperationPassive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById OperationPassive"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return operationPassiveDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById OperationPassive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById OperationPassive"));
    }

}