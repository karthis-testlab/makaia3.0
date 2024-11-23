package com.makaia.booker.api.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.makaia.general.utils.PropertiesHandler;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class IncidentSerivce {

	private Response response;

	public IncidentSerivce getIncidentByNumber(String number) {
		String url = "https://dev262949.service-now.com/api/now/table/incident";
		response = RestAssured.given().auth()
				.basic(PropertiesHandler.config("makaia.servicenow.username"),
						PropertiesHandler.secret("service.now.instance.password"))
				.when().queryParam("sysparm_query", "number=" + number).get(url);
		return this;
	}

	public IncidentSerivce validateStatusCode(int statusCode) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		return this;
	}

	public IncidentSerivce validateStatusLine(String statusLine) {
		MatcherAssert.assertThat(response.getStatusLine(), Matchers.containsString(statusLine));
		return this;
	}

	public IncidentSerivce validateContentType(String contentType) {
		MatcherAssert.assertThat(response.getContentType(), Matchers.containsString(contentType));
		return this;
	}

}