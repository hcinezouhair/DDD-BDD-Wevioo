package com.wevioo.demo.bdd.createUser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wevioo.demo.bdd.utils.ApiException;
import com.wevioo.demo.infrastructure.utils.ErrorResponse;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class CreateSteps extends CreateServer {

    private static final String MISSING_STRING = "-";
    private ObjectMapper objectMapper = new ObjectMapper();
    private String firstName;
    private String lastName;
    private String email;
    private Response response;

    @Before
    public void clearContext() {
        firstName = null;
        lastName = null;
        email = null;
        response = null;
        super.setup();
    }

    @Given("le prenom {string}")
    public void lePrenom(String firstName) {
        this.firstName = firstName;
    }

    @And("le nom {string}")
    public void leNom(String lastName) {
        this.lastName = lastName;
    }

    @And("l adresse mail {string}")
    public void lAdresseMail(String email) {
        this.email = email;
    }

    @When("j appelle le service de creaion des users")
    public void jAppelleLeServiceDeCreaionDesUsers() throws ApiException {
        this.response = apiHelper.createUser(firstName, lastName, email);
    }

    @Then("je recois le code http {int} et l'erreur suivante {string}")
    public void jeRecoisLeCodeHttpHTTP_CODEEtLErreurSuivante(int httpCode, String codeError) throws ApiException {
        this.response.then()
                .assertThat()
                .statusCode(httpCode);
        if (MISSING_STRING.equals(codeError)) {
            return;
        }
        ErrorResponse errorResponse = readbean(response.getBody().asString(), ErrorResponse.class);
        assertThat(errorResponse.getCode()).isEqualTo(codeError);
    }

    private <T> T readbean(String json, Class<T> clazz) throws ApiException {
        T response;
        try {
            response = objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new ApiException("Unable to unserialize json=" + json + " to class " + clazz.getSimpleName(), e);
        }
        return response;
    }

}
