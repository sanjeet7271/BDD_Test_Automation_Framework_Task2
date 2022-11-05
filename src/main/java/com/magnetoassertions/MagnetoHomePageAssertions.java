package com.magnetoassertions;

import com.magnetosteps.MagnetoSteps;
import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;

public class MagnetoHomePageAssertions {
	private MagnetoSteps magnetoSteps = new MagnetoSteps();
	public static Logger logger = Logger.getLogger(MagnetoHomePageAssertions.class);

	public void verifyShopNewYogaButton(boolean isbutton) {
		assertEquals(magnetoSteps.isShopNewYogaButtonDisplayed(), isbutton);
		logger.info("Expected!, Show new yoga button is displayed");
	}

	public void verifyCreateAnAccountTitleDisplayed(boolean isDisplayed) {
		assertEquals(magnetoSteps.isCreateAnAccountTitleDisplayed(), isDisplayed);
		logger.info("Expected!, Create an account title is displayed");
	}

	public void verifyRegistrationSuccess(String successMessage) {
		assertEquals(magnetoSteps.getRegistrationSuccessMessage(), successMessage);
		logger.info("Expected!, Registration success message is displayed");
	}

	public void verifyAddToCartSuccessMessage(String successMessage) {
		assertEquals(magnetoSteps.getAddedSuccessMessage(), successMessage);
		logger.info("Expected!, add to cart success message is displayed");
	}

	public void verifyOdersuccessMessage(String successMessage) throws InterruptedException {
		assertEquals(magnetoSteps.getOdersuccessMessage(), successMessage);
		logger.info("Expected!, Order placed message is displayed");
	}
}
