package com.ebay.stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CoindeskStepDefinitions {

	    private Response response;

	    @Given("user send a GET request to {string}")
	    public void i_send_a_get_request_to(String url) {
	        
	        response = RestAssured.given().get(url);
	    }

	    @Then("the response status code should be {int}")
	    public void the_response_status_code_should_be(int statusCode) {
	       
	        Assert.assertEquals("Unexpected status code!", statusCode, response.getStatusCode());
	    }

	    @Then("the response should contain BPIs {string}, {string}, {string}")
	    public void the_response_should_contain_bpis(String bpi1, String bpi2, String bpi3) {
	        
	        String responseBody = response.getBody().asString();
	        Assert.assertTrue("BPI " + bpi1 + " not found!", responseBody.contains("\"" + bpi1 + "\""));
	        Assert.assertTrue("BPI " + bpi2 + " not found!", responseBody.contains("\"" + bpi2 + "\""));
	        Assert.assertTrue("BPI " + bpi3 + " not found!", responseBody.contains("\"" + bpi3 + "\""));
	    }

	    @Then("the GBP description should be {string}")
	    public void the_gbp_description_should_be(String expectedDescription) {
	       
	        String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
	        Assert.assertEquals("GBP description does not match!", expectedDescription, gbpDescription);
	    }
	}

