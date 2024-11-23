package com.makaia.booker.api.services;

import java.util.HashMap;
import java.util.Map;

import com.makaia.general.utils.PropertiesHandler;
import com.makaia.rest.assured.base.RestAssuredBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingService extends RestAssuredBase {
	
	private Response response;
	private Map<String, String> headers = new HashMap<>();
	private Map<String, String> params = new HashMap<>();
	
	private RequestSpecification setUp() {
		return requestSpec(PropertiesHandler.config("booker.base.uri"), 
				    PropertiesHandler.config("booker.booking.base.path"));
	}
	
	public void getBookingById() {
		response = getMethod(setUp());
	}
	
	public void validateGetBookingByIdEndpoint() {
		response.then()
		        .spec(expectResponse(200, "OK", ContentType.JSON));
	}
	
	public void getBooking() {
		
	}
	
	public void createBooking() {
		
	}
	
	public void updateBooking(String token, String bookingId, Object requestPayload) {
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("Cookie", "token="+token);
		params.put("id", bookingId);
		response = putMethod(setUp(), headers, params, requestPayload);
	}
	
	public void validateUpdateBookingEndpoint() {
		response.then()
		        .spec(expectResponse(200, "OK", ContentType.JSON));
	}
	
	public void deleteBooking() {
		
	}

}