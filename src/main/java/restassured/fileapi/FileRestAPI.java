package restassured.fileapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import java.io.File;

public class FileRestAPI {
	
	@Test
	public void testFileUploadOk () {
		
		RestAssured.baseURI = "http://localhost:8088";
		
		String responseBody = 
		given()
			.log()
			.all()
			.contentType(ContentType.MULTIPART)
			.multiPart("fileName", new File("invite.ics")).
		when()
			.post("/api/files/upload/database").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.response()
			.asString();
		
		JsonPath jsonPath = new JsonPath(responseBody);
		Boolean uploadStatus = jsonPath.getBoolean("uploadStatus");
		assertTrue(uploadStatus);
	}
	
	@Test
	public void testFileUploadBadRequest () {
		
		RestAssured.baseURI = "http://localhost:8088";
		
		given()
			.log()
			.all()
			.contentType(ContentType.MULTIPART)
			.multiPart("fileName", new File("wallpaper.jpg")).
		when()
			.post("/api/files/upload/database").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(400);
	}
}
