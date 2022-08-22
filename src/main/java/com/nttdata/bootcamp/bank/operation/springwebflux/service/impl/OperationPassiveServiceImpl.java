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

package com.nttdata.bootcamp.bank.operation.springwebflux.service.impl;

import com.nttdata.bootcamp.bank.operation.springwebflux.dao.inte.OperationPassiveDaoInte;
//import com.nttdata.bootcamp.bank.operation.springdata.dao.inte.JpaOperationPassiveDaoInte;
import com.nttdata.bootcamp.bank.operation.springdata.document.OperationPassive;
import com.nttdata.bootcamp.bank.operation.springwebflux.webclient.Location;
import com.nttdata.bootcamp.bank.operation.springwebflux.service.inte.OperationPassiveServiceInte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Scannable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Clase de implementación de servicio para utilizar los métodos de CRUD.
 */
@Service
public class OperationPassiveServiceImpl implements OperationPassiveServiceInte {

    private static final Logger log = LoggerFactory.getLogger(OperationPassiveServiceInte.class);

    private final WebClient setupWebClientOperation;

    private final WebClient setupWebClientLocation;

    public OperationPassiveServiceImpl(WebClient.Builder webClientBuilder) {
        this.setupWebClientOperation = webClientBuilder
                .baseUrl("http://localhost:8093")
                .build();

        this.setupWebClientLocation = webClientBuilder
                .baseUrl("http://localhost:8094")
                .build();
    }

    @Autowired
    private OperationPassiveDaoInte operationPassiveDaoInte;

    /*@Autowired
    private JpaOperationPassiveDaoInte jpaOperationPassiveDaoInte;*/

    @Override
    public Mono<OperationPassive> insert(OperationPassive operationPassive) throws InterruptedException {

        String parameterRuleHaveCommissionFree = "1";
        String parameterRuleHaveMaximumLimit = "1";
        String parameterRuleDatumCommissionFree = "0.10";
        String parameterRuleDatumMaximumLimit = "3";

        Boolean resultRule01 = Stream
                .of(("1".equals(parameterRuleHaveCommissionFree)))
                .reduce(Boolean.TRUE, (value1, value2) -> value1 && value2);

        log.info("resultRule01 = [" + resultRule01 + "]");

        Boolean resultRule02 = Stream
                .of(("1".equals(parameterRuleHaveMaximumLimit)))
                .reduce(Boolean.TRUE, (value1, value2) -> value1 && value2);

        log.info("resultRule02 = [" + resultRule02 + "]");


        Date date = new Date();
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
        int dateYear = getLocalDate.getYear();
        int dateMonth = getLocalDate.getMonthValue();
        log.info("dateYear = [" + dateYear + "]; dateMonth = [" + dateMonth + "]");

        /*
        Flux<OperationPassive> fluxOperationPassive = operationPassiveDaoInte.findAll()
        .filter(x -> (dateYear == x.getOperationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear()) && (dateMonth == x.getOperationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue()))
        ;
        */



        //if (resultRule02) {
            log.info("fluxOperationPassive = [" + "inicio" + "]");
            /*Mono<Long> z = operationPassiveDaoInte.findAll()
                    .count()
                    .doFirst(() -> log.info("Begin readAll OperationPassive"))
                    .doOnNext(a -> log.info(a.toString()))
                    .doAfterTerminate(() -> log.info("Finish readAll OperationPassive"))
                    ;*/


        int numberOfMonthlyMovementsMade = 2;

        //ArrayList<OperationPassive> al = new ArrayList<OperationPassive>();

            /*Flux<OperationPassive> fluxOperationPassive = operationPassiveDaoInte.findAll()
                    .doFirst(() -> log.info("Begin readAll OperationPassive"))
                    .doOnNext(a -> log.info(a.toString()))
                    .flatMap(x->{return al.add(x)})
                    .doAfterTerminate(() -> log.info("Finish readAll OperationPassive"))
                    ;*/

        //fluxOperationPassive.subscribe(al::append);
        //numberOfMonthlyMovementsMade = fluxOperationPassive.count().block();
        //numberOfMonthlyMovementsMade = operationPassiveDaoInte.findAll().collectList().block().size();

            //fluxOperationPassive.subscribe();

        //long xxx = fluxOperationPassive.toStream().count();
        //log.info("xxx = [" + xxx + "]");

        /*Flux<OperationPassive> fluxOperationPassive = this.setupWebClientOperation
                .get()
                .uri("/api/operationPassive")
                .retrieve()
                .bodyToFlux(OperationPassive.class);*/

        //fluxOperationPassive.subscribe(System.out::println);
        //fluxOperationPassive.blockFirst();
        //log.info("fluxOperationPassiveToString = " + fluxOperationPassive.collectList().cache());


            log.info("fluxOperationPassive = [" + "fin" + "]");

            //List<OperationPassive> listOfMonthlyMovementsMade = fluxOperationPassive.collectList().block();
            //int numberOfMonthlyMovementsMade = listOfMonthlyMovementsMade.size();

        //int numberOfMonthlyMovementsMade = IterableUtils.size(jpaOperationPassiveDaoInte.findAll());
        //int numberOfMonthlyMovementsMade = 4;
        //Mono<Long> monoMonthlyMovementsMade = fluxOperationPassive.map(x->x.getCodeOperationPassive());

        /*Flux<String> monoMonthlyMovementsMade = fluxOperationPassive
                .map(y -> y.getId())
                .doFirst(() -> log.info("Begin monoMonthlyMovementsMade Movement"))
                .doOnNext(y -> log.info(y.toString()))
                .doAfterTerminate(() -> log.info("Finish monoMonthlyMovementsMade Movement"));
        monoMonthlyMovementsMade.subscribe();*/


        /*
        Iterator<OperationPassive> x = fluxOperationPassive.toIterable().iterator();


        while (x.hasNext()) {
            x.next();
            numberOfMonthlyMovementsMade++;
        }
        */


        //Scannable sc = Scannable.from(fluxOperationPassive);
        //long numberOfMonthlyMovementsMade = sc.parents().count();

        //numberOfMonthlyMovementsMade = 0;
        //numberOfMonthlyMovementsMade = monoMonthlyMovementsMade.collectList().block(Duration.ofSeconds(5)).size();
        log.info("numberOfMonthlyMovementsMade = [" + numberOfMonthlyMovementsMade + "]");
        //}



        Boolean resultRule03 = Stream
                .of(("0.10".equals(parameterRuleDatumCommissionFree)))
                .reduce(Boolean.TRUE, (value1, value2) -> value1 && value2);

        log.info("resultRule03 = [" + resultRule03 + "]");

        Boolean resultRule04 = Stream
                .of((numberOfMonthlyMovementsMade <= Long.parseLong(parameterRuleDatumMaximumLimit)))
                .reduce(Boolean.TRUE, (value1, value2) -> value1 && value2);

        log.info("resultRule04 = [" + resultRule04 + "]");

        Boolean resultRuleAll = Stream
                .of(resultRule01, resultRule02, resultRule03, resultRule04)
                .reduce(Boolean.TRUE, Boolean::logicalAnd);

        log.info("resultRuleAll = [" + resultRuleAll + "]");

        TimeUnit.SECONDS.sleep(10);

        if (resultRuleAll) {

            return operationPassiveDaoInte.insert(operationPassive)
                    .doFirst(() -> log.info("Begin create OperationPassive"))
                    .doOnNext(a -> log.info(a.toString()))
                    .doAfterTerminate(() -> log.info("Finish create OperationPassive"))
                    ;

        } else {
            return Mono.empty();
        }
    }

    /*public Mono<OperationPassive> create(final OperationPassive operationPassive) {

        return operationPassiveDaoInte.save(operationPassive)
                .doFirst(() -> log.info("Begin create OperationPassive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create OperationPassive"));

    }*/

    @Override
    public Flux<OperationPassive> readAll() {

        return operationPassiveDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll OperationPassive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll OperationPassive"))
                ;
    }

    @Override
    public Mono<OperationPassive> readByCodeOperationPassive(String codeOperationPassive) {
        Location webclientLocation = new Location();
        Mono<Location> monoLocation = this.setupWebClientLocation.get()
                .uri("/api/location/readByCodeLocation/{codeLocation}", "L-0000000001")
                .retrieve()
                .bodyToMono(Location.class);

        return monoLocation.flatMap(x -> {
            webclientLocation.setId(x.getId());
            webclientLocation.setCodeLocation(x.getCodeLocation());
            webclientLocation.setName(x.getName());
            webclientLocation.setDescription(x.getDescription());
            webclientLocation.setState(x.getState());
            webclientLocation.setCodeLocationType(x.getCodeLocationType());
            webclientLocation.setCodeUbigeo(x.getCodeUbigeo());

            log.info("webclientLocation.getCodeLocation() = [" + webclientLocation.getCodeLocation() + "]");

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