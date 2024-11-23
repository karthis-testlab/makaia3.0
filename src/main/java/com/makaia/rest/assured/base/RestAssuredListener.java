package com.makaia.rest.assured.base;

import java.util.logging.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RestAssuredListener implements Filter {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(RestAssuredListener.class.getName());

	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		Response response = ctx.next(requestSpec, responseSpec);
		LOGGER.info("HTTP Method ==> "+requestSpec.getMethod());		
		LOGGER.info("URI ==> "+requestSpec.getURI());
		LOGGER.info("Request Body ==> "+requestSpec.getBody());
		LOGGER.info("Response Body ==> "+response.getBody().asPrettyString());
		return response;
	}

}