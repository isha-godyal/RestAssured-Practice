package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestsExamples {

	@Test
	public void test_1() {
			
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println("Status Code :"+ response.getStatusCode());

		System.out.println("Time :"+ response.getTime());

		System.out.println("Response body :"+ response.getBody().asString());
		
		System.out.println("Status line"+response.getStatusLine());
		
		System.out.println("Header content Type :"+response.getHeader("content-type"));
		
		int statusCode= response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_2() {
		
		baseURI= "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
		body("data[1].id",equalTo(8))
		.log().all();
		
	}
}
