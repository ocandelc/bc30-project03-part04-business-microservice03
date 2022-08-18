package com.nttdata.bootcamp.bank.operation;

import com.nttdata.bootcamp.bank.operation.model.dao.inte.OperationPassiveDaoInte;
import com.nttdata.bootcamp.bank.operation.model.document.OperationPassive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.Date;

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
