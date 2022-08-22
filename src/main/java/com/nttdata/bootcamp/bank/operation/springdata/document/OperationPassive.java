/**
 * Resumen.
 * Objeto                   : OperationPassive.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              17/08/2022        Mario Vásquez           Realizar la creación de un campo nuevo.
 */

package com.nttdata.bootcamp.bank.operation.springdata.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@AllArgsConstructor
@Document(collection="operation_passive")
public class OperationPassive {

    @Id
    private String id;
    private String codeOperationPassive;
    private String name;
    private String description;
    private Date operationDate;
    private Double principalBalance;
    private Double balanceCurrent;
    private Double balanceMove;
    private Double balanceCommission;
    private Double balanceNew;
    private String state;
    private String codeProduct;
    private String codeOperationType;

}
