package com.coded.spring.ordering.steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import io.restassured.RestAssured
import io.restassured.response.Response
import io.restassured.http.ContentType
import org.springframework.boot.test.web.server.LocalServerPort
import org.hamcrest.MatcherAssert.assertThat
import org.skyscreamer.jsonassert.JSONAssert
import org.hamcrest.Matchers.equalTo
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration
class StepDefinitions {

    @LocalServerPort
    private var port: Int = 8081

    private lateinit var response: Response
    private var requestBody: String = ""

    @Given("the client sets the request body to")
    fun setRequestBody(body: String) {
        requestBody = body
    }

    @When("the client sends a GET request to {string}")
    fun sendGetRequest(endpoint: String) {
        response = RestAssured
            .given()
            .port(port)
            .`when`()
            .get(endpoint)
    }

    @When("the client sends a POST request to {string}")
    fun sendPostRequest(endpoint: String) {
        response = RestAssured
            .given()
            .port(port)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .`when`()
            .post(endpoint)
    }

    @Then("the response status should be {int}")
    fun checkStatus(expectedStatus: Int) {
        assertThat(response.statusCode, equalTo(expectedStatus))
    }

    @Then("the response body should be {string}")
    fun checkResponseBody(expectedBody: String) {
        val actualBody = response.body.asString()
        assertThat(actualBody, equalTo(expectedBody))
    }

    @Then("the response body should be")
    fun checkResponseBodyJson(expectedJson: String) {
        val actualJson = response.body.asString()
        JSONAssert.assertEquals(expectedJson, actualJson, true)
    }
}