package tests;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {

//	@Test
	public void get() {

		baseURI = "http://localhost:3000";

		given().get("/users").then().statusCode(200).log().all();
	}

//	@Test
	public void post() {

		JSONObject request = new JSONObject();
		request.put("first_name", "Rohit");
		request.put("last_name", "Kundgar");
		request.put("subjectId", "4");

		baseURI = "http://localhost:3000";

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
				.post("/users")
				.then()
				.statusCode(201);
	}

//	@Test
	public void put() {

		JSONObject request = new JSONObject();
		request.put("first_name", "Shravani");
		request.put("last_name", "Shetty");
		request.put("subjectId", "6");

		baseURI = "http://localhost:3000";

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
				.put("/users/4")
				.then()
				.statusCode(200);
	}

//	@Test
	public void patch() {

		JSONObject request = new JSONObject();
		request.put("last_name", "Shetty");

		baseURI = "http://localhost:3000";

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
				.patch("/users/1")
				.then()
				.statusCode(200);
	}
	
	@Test
	public void delete() {

		
		baseURI = "http://localhost:3000";

		
		when()
				.delete("/users/2")
				.then()
				.statusCode(200);
	}
}
