package com.nttdata.bootcamp.bank.operation.springflux.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OperationPassiveRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void readAllTest() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + "8093" + "/api/operationPassive").toString(), String.class);
        String statusCode = response.getStatusCode().toString();
        assertFalse("200 OK".equals(statusCode));

    }

}
