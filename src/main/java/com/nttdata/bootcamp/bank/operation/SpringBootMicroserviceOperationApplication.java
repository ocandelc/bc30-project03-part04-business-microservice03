/**
 * Resumen.
 * Objeto                   : SpringBootMicroserviceOperationApplication.java
 * Descripción              : Clase para iniciar el microservicio.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              17/08/2022        Mario Vásquez           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.bank.operation;

import com.nttdata.bootcamp.bank.operation.model.dao.inte.OperationPassiveDaoInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase para iniciar el microservicio.
 */
@SpringBootApplication
public class SpringBootMicroserviceOperationApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootMicroserviceOperationApplication.class);

    @Autowired
    private OperationPassiveDaoInte dao;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceOperationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Init OperationPassive");

    }

}
