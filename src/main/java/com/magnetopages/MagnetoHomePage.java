package com.magnetopages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumutility.SeleniumUtility;
import com.userdto.User;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MagnetoHomePage {
	private static Logger logger = Logger.getLogger(MagnetoHomePage.class);
	private SeleniumUtility seleniumUtility = new SeleniumUtility();
	private static final By SHOP_NEW_YOGA_BUTTON = By
			.xpath(".//span[contains(@class,'content')]//span[contains(@class,'button')]");
	private static final By CREATE_AN_ACCOUNT = By.xpath(".//a[contains(text(),'Create an Account')]");
	private static final By CREATE_ACCOUNT_TITLE = By.cssSelector(".page-title");
	private static final By FIRST_NAME = By.xpath("//input[@id='firstname']");
	private static final By LAST_NAME = By.xpath("//input[@id='lastname']");
	private static final By NEWSLETTER_CHECKBOX = By.xpath("//input[@id='is_subscribed']");
	private static final By EMAIL_ID = By.xpath("//input[@id='email_address']");
	private static final By PASSWORD = By.xpath("//input[@id='password']");
	private static final By CONFIRM_PASSWORD = By.xpath("//input[@id='password-confirmation']");
	private static final By CREATE_ACCOUNT_BUTTON = By.cssSelector(".submit");
	private static final By PASSWORD_STRENGTH_METER = By.xpath("//span[@id='password-strength-meter-label']");
	private static final By MESSAGES = By.xpath("//div[contains(@class,'message-success')]//div");
	private static final By HOME_PAGE = By.cssSelector(".logo");
	private static final By SELECT_ANY_ITEM = By.cssSelector(".product-image-photo");
	private static final By SELECT_ITEM_SIZE = By.cssSelector(".swatch-option.text");
	private static final By SELECT_ITEM_COLOR = By.cssSelector(".swatch-option.color");
	private static final By ADD_TO_CART = By.cssSelector("#product-addtocart-button");
	private static final By ADD_TO_CART_MESSAGE = By.xpath(".//div[contains(@class,'message-success')]//div");
	private static final By SHOPING_CART = By.xpath("//a[contains(text(),'shopping cart')]");
	private static final By ITEM_TITLE = By.cssSelector(".page-title");
	private static final By PROCEED_CHECKOUT = By.xpath("//span[contains(text(),'Proceed to Checkout')]");

	private static final By STREET_NUMBER = By.xpath("//input[@name='street[0]']");
	private static final By STREET_NAME = By.xpath("//input[@name='street[1]']");
	private static final By CITY = By.xpath("//input[@name='city']");
	private static final By STATE = By.xpath("//Select[@name='region_id']");
	private static final By POSTAL_CODE = By.xpath("//input[@name='postcode']");
	private static final By PHONE_NUMBER = By.xpath("//input[@name='telephone']");
	private static final By SHIPPING_METHOD = By.xpath("//td[text()='Table Rate']//parent::tr//input[@class='radio']");
	private static final By NEXT_BUTTON = By.xpath("//span[text()='Next']");
	private static final By PLACE_AN_ORDER_BUTTON = By.xpath("//span[text()='Place Order']");
	private static final By ORDER_SUCCESS = By.xpath("//div[@class='checkout-success']//p[2]");
	private static final By BAG_TITLE = By.cssSelector(".page-title>span");

	public boolean isShopNewYogaButtonDisplayed() {
		return $(SHOP_NEW_YOGA_BUTTON).isDisplayed();
	}

	public void clickOnCreateAnAccount() {
		$(CREATE_AN_ACCOUNT).isDisplayed();
		$(CREATE_AN_ACCOUNT).click();
	}

	public boolean isCreateAnAccountTitleDisplayed() {
		return $(CREATE_ACCOUNT_TITLE).isDisplayed();
	}

	public void enterAllFieldsInCreateAccountPage(User users) throws InterruptedException {
		$(FIRST_NAME).isDisplayed();
		$(FIRST_NAME).sendKeys(users.getResults().get(0).getName().getFirst());
		$(LAST_NAME).isDisplayed();
		$(LAST_NAME).sendKeys(users.getResults().get(0).getName().getLast());
		$(NEWSLETTER_CHECKBOX).click();
		$(NEWSLETTER_CHECKBOX).isSelected();
		$(EMAIL_ID).isDisplayed();
		$(EMAIL_ID).sendKeys(users.getResults().get(0).getEmail());
		$(PASSWORD).isDisplayed();
		$(PASSWORD).sendKeys(users.getResults().get(0).getLogin().getPassword());
		if ($(PASSWORD_STRENGTH_METER).getText().equals("Weak")) {
			$(PASSWORD).clear();
			String strongPassword = users.getResults().get(0).getLogin().getPassword() + UUID.randomUUID().toString();
			users.getResults().get(0).getLogin().setPassword(strongPassword);
			$(PASSWORD).sendKeys(strongPassword);
		}
		$(CONFIRM_PASSWORD).isDisplayed();
		$(CONFIRM_PASSWORD).sendKeys(users.getResults().get(0).getLogin().getPassword());
		$(CREATE_ACCOUNT_BUTTON).isDisplayed();
		$(CREATE_ACCOUNT_BUTTON).click();
		logger.info("Expected!, account is created successfully.");
		Thread.sleep(20);
	}

	public String getRegistrationSuccessMessage() {
		SelenideElement message = $(MESSAGES);
		message.shouldBe(Condition.visible, Duration.ofSeconds(10));
		return $(MESSAGES).getText();
	}

	public void visitHomePage() {
		$(HOME_PAGE).click();
	}

	public void selectAnyItemHomePage() {
		List<SelenideElement> product = $$(SELECT_ANY_ITEM);
		logger.info(product.size());
		int productNumber = seleniumUtility.getRandomNumberUsingNextInt(0, product.size());
		logger.info(productNumber);
		product.get(productNumber).click();
	}

	public void selectSizeColorAndQuantityOfItem() {
		String itemTitle = $(ITEM_TITLE).getText().toLowerCase();
		if (!itemTitle.contains("bag")) {
			List<SelenideElement> selectSize = $$(SELECT_ITEM_SIZE);
			logger.info(selectSize.size());
			int sizeNumber = 0;
			if (selectSize.size() > 0) {
				sizeNumber = seleniumUtility.getRandomNumberUsingNextInt(0, selectSize.size());
			}
			logger.info(sizeNumber);
			selectSize.get(sizeNumber).click();

			$(SELECT_ITEM_COLOR).click();
			logger.info("Expected! Product is not a bag related item.");
		}else {
			logger.info("Expected! Product is not a bag related item.");
		}
		
	}

	public void clickOnAddToCart() {
		$(ADD_TO_CART).click();
	}

	public String getTitleOfTheItem() {
		return $(ITEM_TITLE).getText();
	}

	public String getAddedSuccessMessage() {
		return $(ADD_TO_CART_MESSAGE).getText();
	}

	public void clickOnShopingCart() {
		SelenideElement shopingCart = $(SHOPING_CART);
		shopingCart.shouldBe(Condition.visible, Duration.ofSeconds(10));
		$(SHOPING_CART).click();
	}

	public void clickOnProceedToCheckOut() {
		SelenideElement proceedCheckout = $(PROCEED_CHECKOUT);
		proceedCheckout.shouldBe(Condition.visible, Duration.ofSeconds(10));
		$(PROCEED_CHECKOUT).click();
	}

	public void enterAllDeliveryDetails(User users) throws InterruptedException {
		SelenideElement streetNumber = $(STREET_NUMBER);
		streetNumber.shouldBe(Condition.visible, Duration.ofSeconds(10));
		$(STREET_NUMBER).sendKeys(String.valueOf(users.getResults().get(0).getLocation().getStreet().getNumber()));
		$(STREET_NAME).isDisplayed();
		$(STREET_NAME).sendKeys(users.getResults().get(0).getLocation().getStreet().getName());
		$(CITY).isDisplayed();
		$(CITY).sendKeys(users.getResults().get(0).getLocation().getCity());
		Select options = new Select($(STATE));
		options.selectByIndex(4);
		$(POSTAL_CODE).isDisplayed();
		$(POSTAL_CODE).sendKeys(users.getResults().get(0).getLocation().getPostcode());
		$(PHONE_NUMBER).isDisplayed();
		$(PHONE_NUMBER).sendKeys(users.getResults().get(0).getPhone());
		$(SHIPPING_METHOD).click();
		$(SHIPPING_METHOD).isSelected();
		logger.info("Expected!, account is created successfully.");
		Thread.sleep(100);
	}

	public void clickOnNextButton() {
		SelenideElement nextButton = $(NEXT_BUTTON);
		nextButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
		$(NEXT_BUTTON).click();
	}

	public void clickOnPlaceAndOrderButton() {
		SelenideElement placeAnOrder = $(PLACE_AN_ORDER_BUTTON);
		placeAnOrder.shouldBe(Condition.visible, Duration.ofSeconds(10));
		$(PLACE_AN_ORDER_BUTTON).click();
	}

	public String getOdersuccessMessage() {
		SelenideElement orderSuccess = $(ORDER_SUCCESS);
		orderSuccess.shouldBe(Condition.visible, Duration.ofSeconds(10));
		return $(ORDER_SUCCESS).getText();
	}
}
