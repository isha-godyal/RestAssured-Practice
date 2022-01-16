package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {

	// @Test
	public void testGet() {

		baseURI = "https://reqres.in/api";

		//testing Get method
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name", equalTo("George"))
				.body("data.first_name", hasItems("George", "Rachel"));
	}

	@Test
	public void testPost() {

		Map<String, Object> map = new HashMap<String, Object>();

		// map.put("name", "isha");
		// map.put("job", "automation");

		// System.out.println(map);

		// converting map into JSON Object

		// JSONObject request=new JSONObject(map);

		// another way directly used by JSON

		JSONObject request = new JSONObject();
		request.put("name", "isha");
		request.put("job", "automation");

		System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		
		given().
		   //header("Content-Type","application/json").
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		  body(request.toJSONString()).
		when().
		  post("/users").
		then().
		  statusCode(201)
		  .log().all();
	}

}
