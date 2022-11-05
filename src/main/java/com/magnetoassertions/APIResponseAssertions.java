package com.magnetoassertions;

import org.apache.log4j.Logger;
import com.constants.HttpStatusCodes;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

public class APIResponseAssertions {
	public static Logger logger = Logger.getLogger(APIResponseAssertions.class);

	public void verifyResponseStatusCode(Response response) {
		int actualStatusCode = response.getStatusCode();
		assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
		logger.info("Expected!, status code is successfully validated.");
	}

}
