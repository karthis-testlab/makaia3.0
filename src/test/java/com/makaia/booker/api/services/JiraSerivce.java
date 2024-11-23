package com.makaia.booker.api.services;

import java.io.File;

import org.hamcrest.Matchers;

import com.makaia.general.utils.PropertiesHandler;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JiraSerivce {
	
private String issueId;
	
	public JiraSerivce createIssue() {
		String url = "https://karthikeselene.atlassian.net/rest/api/3/issue";
		String payload = """
				{
                     "fields": {
                                "summary": "New Issue from REST API AUG Session",
                                "issuetype": {
                                           "id": "10012"
                                           },
                                  "project": {
                                            "id": "10003"
                                            }
                   }
                  }
				""";
		issueId = RestAssured.given()
		           .auth()
		           .preemptive()
		           .basic(PropertiesHandler.config("makaia.jira.username"), PropertiesHandler.secret("jira.api.token"))
	               .header("Content-Type", "application/json")
	               .when()
	               .body(payload)
	               .post(url)
	               .then()
	               .assertThat()
	               .statusCode(201)
	               .extract()
	               .jsonPath()
	               .getString("id");
		return this;	               
	}
	
	public JiraSerivce attachement(String filePath) {
		String url = "https://karthikeselene.atlassian.net/rest/api/3";
		RestAssured.given()
		           .auth()
		           .preemptive()
		           .basic(PropertiesHandler.config("makaia.servicenow.username"), PropertiesHandler.secret("jira.api.token"))
		           .header("X-Atlassian-Token", "no-check")
		           .pathParam("issueIdOrKey", issueId)
		           .log()
		           .all()
		           .when()		           
		           .multiPart(new File(filePath))
		           .post(url+"/issue/{issueIdOrKey}/attachments")
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(200)
		           .statusLine(Matchers.containsString("OK"))
		           .contentType(ContentType.JSON);
		return this;
	}

}