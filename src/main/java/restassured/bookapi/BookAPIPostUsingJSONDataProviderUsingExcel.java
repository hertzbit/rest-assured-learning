package restassured.bookapi;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.excelintegration.ExcelIntegrationDemo;
import restassured.request.BookAPI;

public class BookAPIPostUsingJSONDataProviderUsingExcel {

	public static String fileName = "/Users/chetankrishna/Downloads/BookAPITest.xlsx";
	public static String sheetName = "Post";
	public static String testCaseLiteral = "TestCases";
	public static String testCaseNameBookOne = "bookOne";
	public static String testCaseNameBookTwo = "bookTwo";
	
	@DataProvider (name = "addBooksDataProvider")
	public Object[][] getPostRequestData() throws Exception{
		
		Map<String, Integer> rowColumnMap = ExcelIntegrationDemo.
				searchForTestCase(fileName, sheetName, testCaseLiteral);
		
		ArrayList<Object> inputDataBookOne = ExcelIntegrationDemo.
				getDataForTestCase(rowColumnMap, fileName, sheetName, testCaseNameBookOne);
		System.out.println(inputDataBookOne);
		ArrayList<Object> inputDataBookTwo = ExcelIntegrationDemo.
				getDataForTestCase(rowColumnMap, fileName, sheetName, testCaseNameBookTwo);
		System.out.print(inputDataBookTwo);
		Object[] bookOne = inputDataBookOne.toArray();
		Object[] bookTwo = inputDataBookTwo.toArray();
		
		return new Object[][] {bookOne, bookTwo};
	}
	
	@Test (dataProvider = "addBooksDataProvider")
	public void testUserAPI(String authorName, String isbn, String title,  String yearPublished,
				String genre) {
		
		RestAssured.baseURI = "http://localhost:8088/api/";

		// POST Request
		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPOSTRequestBody(authorName, title, Integer.valueOf(yearPublished), genre, 
					isbn)).
		when()
			.post("books").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(201);
	}
}
