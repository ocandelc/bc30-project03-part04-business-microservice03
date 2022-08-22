/**
 * Resumen.
 * Objeto                   : OperationPassiveDaoInte.java
 * Descripción              : Clase de interface dao para obtener los datos de la base de datos.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              17/08/2022        Mario Vásquez           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.bank.operation.springwebflux.dao.inte;

import com.nttdata.bootcamp.bank.operation.springdata.document.OperationPassive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Clase de interface dao para obtener los datos de la base de datos.
 */
public interface OperationPassiveDaoInte extends ReactiveMongoRepository<OperationPassive, String> {
    Mono<OperationPassive> readByCodeOperationPassive(String codeOperationPassive);

}
