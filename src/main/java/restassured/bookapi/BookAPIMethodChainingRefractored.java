package restassured.bookapi;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.jsonutil.JsonPathUtil;
import restassured.request.BookAPI;

public class BookAPIMethodChainingRefractored {
	
	@BeforeTest
	public void initializeTests() {

		RestAssured.baseURI = "http://localhost:8088/api/";
	}
	
	@Test (priority = 1)
	public void testBookAPIPOST(ITestContext bookApiContext) {
		
		String responseBodyPOSTString =

		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPOSTRequestBody()).
		when()
			.post("books").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(201)
			.extract()
			.asString();

		// "09567332982017"
		String createdBookId = JsonPathUtil.getRequestedKeyFromResponse(responseBodyPOSTString, 
				"bookId");
		System.out.println(createdBookId);
		bookApiContext.setAttribute("bookId", createdBookId);
	}
	
	@Test (priority = 2)
	public void testBookAPIPUT(ITestContext bookApiContext) {
		
		String createdBookId = String.valueOf(bookApiContext.getAttribute("bookId"));
		
		String putResponse = 
		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPUTRequestBody())
			.pathParam("bookId", createdBookId).   //// "09567332982017"
		when().
			put("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.body()
			.asString();
		
		String newBookId = JsonPathUtil.getRequestedKeyFromResponse(putResponse, 
				"bookId");
		
		//bookApiContext.setAttribute("newBookId", newBookId);
		bookApiContext.setAttribute("bookId", newBookId);
	}
	
	@Test (priority = 3)
	public void testBookAPIGET(ITestContext bookApiContext) {
	
		String updatedBookId = String.valueOf(bookApiContext.getAttribute("newBookId"));
		
		String responseForGETRequest = 
		given()
			.log()
			.all()
			.pathParam("bookId", updatedBookId)
			.queryParam("delay", 2000)
			.queryParam("sortBy", "yearPublished").
		when()
			.get("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.asString();
		
		String expectedBookID = "09567332982020";
		String actualBookID = JsonPathUtil.getRequestedKeyFromResponse(responseForGETRequest,
									"bookId");
		assertEquals(actualBookID, expectedBookID);
	}
	
	@Test (priority = 4) 
	public void testBookAPIDELETE (ITestContext bookApiContext) {

		String bookID = String.valueOf(bookApiContext.getAttribute("newBookId"));
		given()
			.log()
			.all()
			.pathParam("bookId", bookID).
		when()
			.delete("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(204);
	
	}
	
	@Test (priority = 5) 
	public void testBookAPIGETAfterDELETE (ITestContext bookApiContext) {
		
		String bookID = String.valueOf(bookApiContext.getAttribute("newBookId"));
		given()
			.log()
			.all()
			.pathParam("bookId", bookID).
		when()
			.get("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(404);
	}
}
