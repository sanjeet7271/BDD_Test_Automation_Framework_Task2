package com.magnetosteps;

import org.apache.log4j.Logger;
import com.magnetopages.MagnetoHomePage;
import com.userdto.User;

public class MagnetoSteps {
	public static Logger logger = Logger.getLogger(MagnetoSteps.class);
	private MagnetoHomePage magnetoHomePage = new MagnetoHomePage();

	public boolean isShopNewYogaButtonDisplayed() {
		return magnetoHomePage.isShopNewYogaButtonDisplayed();
	}

	public void clickOnCreateAnAccount() {
		logger.info("Expected! click on Creat an Account button.");
		magnetoHomePage.clickOnCreateAnAccount();
	}

	public boolean isCreateAnAccountTitleDisplayed() {
		return magnetoHomePage.isCreateAnAccountTitleDisplayed();
	}

	public void enterAllFieldsInCreateAccountPage(User users) throws InterruptedException {
		logger.info("Expected! Enter all mandatory fields.");
		magnetoHomePage.enterAllFieldsInCreateAccountPage(users);
	}

	public String getRegistrationSuccessMessage() {
		return magnetoHomePage.getRegistrationSuccessMessage();
	}

	public void visitHomePage() {
		logger.info("Expected! navigate to home page.");
		magnetoHomePage.visitHomePage();
	}

	public void selectAnyItemHomePage() {
		logger.info("Expected! select any item from home page.");
		magnetoHomePage.selectAnyItemHomePage();
	}

	public void selectSizeColorAndQuantityOfItem() {
		logger.info("Expected! select size, color and quantity of items.");
		magnetoHomePage.selectSizeColorAndQuantityOfItem();
	}

	public void clickOnAddToCart() {
		logger.info("Expected! click on Add to Cart button.");
		magnetoHomePage.clickOnAddToCart();
	}

	public String getAddedSuccessMessage() {
		return magnetoHomePage.getAddedSuccessMessage();
	}

	public String getTitleOfTheItem() {
		return magnetoHomePage.getTitleOfTheItem();
	}

	public void clickOnShoingCartAndProceedToCheckout() {
		logger.info("Expected! click on Shoping Cart button.");
		magnetoHomePage.clickOnShopingCart();
		logger.info("Expected! click on Proceed to Checkout button.");
		magnetoHomePage.clickOnProceedToCheckOut();
	}

	public void enterAllDeliveryDetails(User users) throws InterruptedException {
		logger.info("Expected! Enter delivary address details.");
		magnetoHomePage.enterAllDeliveryDetails(users);
	}

	public void clickOnNextButton() {
		logger.info("Expected! click on Next button.");
		magnetoHomePage.clickOnNextButton();
	}

	public void clickOnPlaceAndOrderButton() {
		logger.info("Expected! click on Place and Order button.");
		magnetoHomePage.clickOnPlaceAndOrderButton();
	}

	public String getOdersuccessMessage() throws InterruptedException {
		return magnetoHomePage.getOdersuccessMessage();
	}
}
