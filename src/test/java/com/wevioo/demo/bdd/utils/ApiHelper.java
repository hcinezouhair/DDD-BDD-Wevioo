package com.wevioo.demo.bdd.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.wevioo.demo.infrastructure.createUser.io.CreateUSerRequest;
import com.wevioo.demo.infrastructure.utils.ErrorResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Classe masquant les détails techniques de communication avec l'API
 */

public class ApiHelper {

    private int port;

    private int port() {
        return port;
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    public ApiHelper(int port) {
        this.port = port;
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
                .registerModule(new Jdk8Module())
                .findAndRegisterModules();
    }

    public Response createUser(String firstName, String lastName, String email) throws ApiException {
        // call the ws
        CreateUSerRequest entity = new CreateUSerRequest(firstName, lastName, email);
        return connect("", "")
                .header("Content-Type", "application/json")
                .body(entity)
                .post("http://localhost:" + port() + "/api/1.0/create");

    }

    private RequestSpecification connect(String login, String pwd) {
        return given()
                .auth()
                .preemptive()
                .basic(login, pwd)
                .when();
    }
}
