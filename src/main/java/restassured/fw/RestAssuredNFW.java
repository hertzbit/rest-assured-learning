package restassured.fw;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssuredNFW {
	
	@Test
	public void testBookerAppGET() {
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking");
		
		Response response = requestSpecification.get();
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
	}
}
