package com.makaia.rest.assured.base;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredBase {
	
	public RequestSpecification requestSpec(String baseUri, String basePath, String userName, String password) {
		return new RequestSpecBuilder()
		    .setBaseUri(baseUri)
		    .addFilter(new RestAssuredListener())
		    .setBasePath(basePath)
		    .setAuth(basic(userName, password))
		    .build();
	}
	
	public RequestSpecification requestSpec(String baseUri, String basePath) {
		return new RequestSpecBuilder()
		    .setBaseUri(baseUri)
		    .addFilter(new RestAssuredListener())
		    .setBasePath(basePath)
		    .build();
	}
	
	public Response getMethod(RequestSpecification requestSpecification) {
		return given()
				.spec(requestSpecification)
				.when()
				.get();
	}
	
	public Response getMethod(RequestSpecification requestSpecification, Map<String, String> pathParams) {
		return given()
				.spec(requestSpecification)
				.pathParams(pathParams)
				.when()
				.get();
	}
	
	public Response getMethod(RequestSpecification requestSpecification, Map<String, String> pathParams, String pathResource) {
		return given()
				.spec(requestSpecification)
				.pathParams(pathParams)
				.when()
				.get(pathResource);
	}
	
	public Response getMethod(RequestSpecification requestSpecification, Map<String, String> pathParams, Map<String, String> queryParams) {
		return given()
				.spec(requestSpecification)
				.pathParams(pathParams)
				.queryParams(queryParams)
				.when()
				.get();
	}
	
	public Response getMethodWithQuery(RequestSpecification requestSpecification, Map<String, String> queryParams) {
		return given()
				.spec(requestSpecification)
				.queryParams(queryParams)
				.when()
				.get();
	}
	
	public Response postMethod(RequestSpecification requestSpecification, Map<String, String> pathParams) {
		return given()
				.spec(requestSpecification)
				.pathParams(pathParams)
				.header("Content-Type", "application/json")
				.when()
				.post();
	}
	
	public Response postMethod(RequestSpecification requestSpecification, Object requstPayload) {
		return given()
				.spec(requestSpecification)				
				.header("Content-Type", "application/json")
				.when()
				.body(requstPayload)
				.post();
	}
	
	public Response postMethod(RequestSpecification requestSpecification, Map<String, String> pathParams, Object requestPayload) {
		return given()
				.spec(requestSpecification)
				.pathParams(pathParams)
				.header("Content-Type", "application/json")
				.when()
				.body(requestPayload)
				.post();
	}
	
	public Response putMethod(RequestSpecification requestSpecification, Object requestPayload) {
		return given()
				.spec(requestSpecification)
				.header("Content-Type", "application/json")
				.when()
				.body(requestPayload)
				.put();
	}
	
	public Response putMethod(RequestSpecification requestSpecification, Map<String, String> headers, Map<String, String> params, Object requestPayload) {
		return given()
				.spec(requestSpecification)
				.headers(headers)
				.pathParams(params)
				.when()
				.body(requestPayload)
				.put("/{id}");
	}
	
	public Response putMethod(RequestSpecification requestSpecification) {
		return given()
				.spec(requestSpecification)
				.header("Content-Type", "application/json")
				.when()
				.put();
	}
	
	public Response putMethod(RequestSpecification requestSpecification, String pathResource) {
		return given()
				.spec(requestSpecification)
				.header("Content-Type", "application/json")
				.when()
				.put(pathResource);
	}
	
	public Response deleteMethod(RequestSpecification requestSpecification, Map<String, String> pathParams) {
		return given()
				.spec(requestSpecification)
				.pathParams(pathParams)
				.when()
				.delete();
	}
	
	public Response deleteMethod(RequestSpecification requestSpecification, Map<String, String> pathParams, String pathResource) {
		return given()
				.spec(requestSpecification)
				.pathParams(pathParams)
				.when()
				.delete(pathResource);
	}
	
	public ResponseSpecification expectResponse(int statusCode, String statusLine, ContentType contentType) {
		ResponseSpecification expect = RestAssured.expect();
		expect.statusCode(statusCode);
		expect.statusLine(containsString(statusLine));
		expect.contentType(contentType);
		return expect;
	}

}