/**
 * Resumen.
 * Objeto                   : OperationPassiveServiceInte.java
 * Descripción              : Clase de interface de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.bank.operation.springwebflux.service.inte;

import com.nttdata.bootcamp.bank.operation.springdata.document.OperationPassive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface OperationPassiveServiceInte {

    Mono<OperationPassive> insert(final OperationPassive operationPassive) throws InterruptedException;

    Flux<OperationPassive> readAll();

    Mono<OperationPassive> readByCodeOperationPassive(String codeOperationPassive);

    Mono<OperationPassive> updateById(final String id, final OperationPassive operationPassive);

    Mono<Void> deleteById(final String id);
}