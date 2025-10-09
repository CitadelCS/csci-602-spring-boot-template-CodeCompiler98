package edu.citadel.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonStepDefinitions extends SpringIntegrationTest {

    @When("^the client calls /info$")
    public void the_client_issues_GET_version() throws Throwable{
        executeGet(createURLWithPort("/info"));
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        int currentStatusCode = latestResponse.getStatusCode().value();
        assertThat("status code is incorrect : "+
                latestResponse.getBody(), currentStatusCode, is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        JsonNode jsonResponse = new ObjectMapper().readTree(latestResponse.getBody());
        String actualVersion = jsonResponse.get("version").asText();
        assertThat(actualVersion, is(version));
    }

    @And("^the client receives server Description \"([^\"]*)\"$")
    public void the_client_receives_server_description_body(String description) throws Throwable {
        JsonNode jsonResponse = new ObjectMapper().readTree(latestResponse.getBody());
        String actualDescription = jsonResponse.get("description").asText();
        assertThat(actualDescription, is(description));
    }

    @When("^the client calls /health$")
    public void theClientCallsHealth() {
        executeGet(createURLWithPort("/health"));
    }

    @And("the client receives a status of {string}")
    public void theClientReceivesAStatusOf(String status) throws Throwable {
        JsonNode jsonResponse = new ObjectMapper().readTree(latestResponse.getBody());
        String actualStatus = jsonResponse.get("status").asText();
        assertThat(actualStatus, is(status));
    }
}