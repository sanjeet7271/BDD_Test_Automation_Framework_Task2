package com.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPage {
	@Given("^I enter api endpoint url$")
	public void getEndPointURL() {
	    System.out.println("Hello");
	}

	@When("^I send api request$")
	public void getResponseFromRandomUserAPI() {
		System.out.println("Hello");
	}

	@Then("^I should get successful status code$")
	public void verifySuccessStatusCode() {
		System.out.println("Hello");
	}

	@Given("^I navigate to home page$")
	public void navigateToHomePage() {
		System.out.println("Hello");
	}

	@Then("^Magneto Page is opened successfully$")
	public void verifyMagnetoPageIsOpened() {
		System.out.println("Hello");
	}

	@And("^Click on Create Account option$")
	public void clickOnCreateAccountOption() {
		System.out.println("Hello");
	}

	@Then("^Registration page opened successfully$")
	public void verifyRegistrationPageIsOpened() {
		System.out.println("Hello");
	}
}
