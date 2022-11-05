package com.stepdefinition;

import com.configuration.BaseUI;
import com.constants.HttpMethods;
import com.constants.TestCaseConstants;
import com.httpmethods.RestAssuredMethods;
import com.magnetoassertions.APIResponseAssertions;
import com.magnetoassertions.MagnetoHomePageAssertions;
import com.magnetosteps.MagnetoSteps;
import com.resoursesreader.ResourcesURLsReader;
import com.userdto.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class RegistrationAndBuyAnyItem extends BaseUI {

	private RestAssuredMethods restCall = new RestAssuredMethods();
	private ResourcesURLsReader resources = new ResourcesURLsReader();
	private APIResponseAssertions apiResponse = new APIResponseAssertions();
	private MagnetoHomePageAssertions magnetoHomePageAssertions = new MagnetoHomePageAssertions();
	private MagnetoSteps magnetoSteps = new MagnetoSteps();
	private Response response;
	String baseURL;
	String resourceURL;
	User userFields;

	@Given("^I enter api endpoint url$")
	public void getEndPointURL() {
		resourceURL = resources.getRandomResourceURI();
	}

	@When("^I send api request$")
	public void getResponseFromRandomUserAPI() {
		response = restCall.restAssuredMethods(HttpMethods.GET, resourceURL);
	}

	@Then("^I should get successful status code$")
	public void verifySuccessStatusCode() {
		apiResponse.verifyResponseStatusCode(response);
	}

	@Given("^I navigate to home page$")
	public void navigateToHomePage() {
		initializeBrowser();
	}

	@Then("^Magneto Page is opened successfully$")
	public void verifyMagnetoPageIsOpened() {
		magnetoHomePageAssertions.verifyShopNewYogaButton(true);
	}

	@And("^I click on Create Account option$")
	public void clickOnCreateAccountOption() {
		magnetoSteps.clickOnCreateAnAccount();
	}

	@Then("^Registration page opened successfully$")
	public void verifyRegistrationPageIsOpened() {
		magnetoHomePageAssertions.verifyCreateAnAccountTitleDisplayed(true);
	}

	@And("^I enter all registration fields$")
	public void enterAllRegistrationFields() throws InterruptedException {
		userFields = response.as(User.class);
		magnetoSteps.enterAllFieldsInCreateAccountPage(userFields);
	}

	@Then("^Registration completed successfully$")
	public void registrationCompleted() {
		magnetoHomePageAssertions.verifyRegistrationSuccess(TestCaseConstants.SUCCESS);
	}

	@Then("^I navigate to homepage$")
	public void visitHomePage() {
		magnetoSteps.visitHomePage();
	}

	@Then("^I select Item from Home page$")
	public void selectItemHomePage() {
		magnetoSteps.selectAnyItemHomePage();
	}

	@Then("^I select size, color and quantity$")
	public void selectDetailOfProduct() {
		magnetoSteps.selectSizeColorAndQuantityOfItem();
	}

	@Then("^I click on add to cart icon$")
	public void clickOnAddToCart() {
		magnetoSteps.clickOnAddToCart();
	}

	@Then("^verify item is added to cart successfully$")
	public void verifyAddToCartItemSuccessMessage() {
		String successMessage = "You added " + magnetoSteps.getTitleOfTheItem() + " to your shopping cart.";
		magnetoHomePageAssertions.verifyAddToCartSuccessMessage(successMessage);
	}

	@Then("^Go to cart and click on proceed to checkout$")
	public void goToCartAndProceedToCheckoutt() throws InterruptedException {
		magnetoSteps.clickOnShoingCartAndProceedToCheckout();
	}

	@And("^select to delivery address details$")
	public void selectDeliveryDetials() throws InterruptedException {
		userFields = response.as(User.class);
		magnetoSteps.enterAllDeliveryDetails(userFields);
	}

	@Then("^Click on next button$")
	public void clickOnNextButton() {
		magnetoSteps.clickOnNextButton();
	}

	@Then("^Click on place and order$")
	public void clickOnPlaceAnOrderButton() throws InterruptedException {
		magnetoSteps.clickOnPlaceAndOrderButton();
	}

	@Then("^verify order is placed successfully$")
	public void verifyPlacedSuccessMessage() throws InterruptedException {
		magnetoHomePageAssertions.verifyOdersuccessMessage(TestCaseConstants.ORDER_PLACED_SUCCESS_MESSAGE);
	}
}
