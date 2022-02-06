package com.paystack.stepdefination;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.paystack.model.Automation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class AutomationStep {

    private Response response;
    private Automation automation;

    @Given("^I have a payload name \"([^\"]*)\" completed \"([^\"]*)\"$")
    public void i_have_a_payload_name_completed(String name, String completed) throws Throwable {
        this.automation = Automation.builder()
                .name(name)
                .completed(completed).build();
    }

    @When("^I hit the post method$")
    public void i_hit_the_post_method() throws Throwable {
        response = given()
                .contentType(ContentType.JSON)
                .body(this.automation)
                .post("https://swapi.dev/api/planets/3/");

    }

    @Then("^I verify response headers$")
    public void i_verify_response_headers() throws Throwable {
        assertThat(response.getHeaders()).isNotEmpty();
    }

    @And("^I verify response data$")
    public void i_verify_response_data() throws Throwable {
        assertThat(response.path("detail").toString()).isEqualTo("Method 'POST' not allowed.");
    }

    @And("^I Verify the status code (\\d+)$")
    public void i_Verify_the_status_code(int arg1) throws Throwable {
        assertThat(response.statusCode()).isEqualTo(arg1);
    }

    @And("^I verify response time does not exceed (\\d+)ms$")
    public void i_verify_response_time_does_not_exceed_ms(int arg1) throws Throwable {
        assertThat(response.time()).isLessThan(arg1);
    }

}
