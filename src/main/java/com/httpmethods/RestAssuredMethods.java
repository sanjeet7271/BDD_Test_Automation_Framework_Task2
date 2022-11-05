package com.httpmethods;

import com.constants.HttpMethods;
import com.resoursesreader.ResourcesURLsReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * 
 * @author Sanjeet Kumar Pandit
 *
 */
public class RestAssuredMethods {
	ResourcesURLsReader resource = new ResourcesURLsReader();
	Response response = null;

	public Response restAssuredMethods(String requestType, String request) {
		switch (requestType) {
		case HttpMethods.GET:
			RestAssured.baseURI = resource.getRandomBaseURI();
			response = RestAssured.given()
					.contentType(ContentType.JSON)
					.log().all()
					.when()
					.get(request)
					.then().log().all()
					.extract()
					.response();
			break;
		case HttpMethods.POST:
			// TODO - kept for future references
		case HttpMethods.PUT:
			// TODO - Kept for future references
			break;
		case HttpMethods.PATCH:
			// TODO - Kept for future references
			break;
		case HttpMethods.DELETE:
			// TODO - Kept for future references
			break;
		case HttpMethods.DEFAULT:
			// TODO - Kept for future references
			break;
		}
		return response;
	}
}
