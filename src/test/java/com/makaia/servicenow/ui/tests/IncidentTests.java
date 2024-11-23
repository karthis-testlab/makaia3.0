package com.makaia.servicenow.ui.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.makaia.general.utils.PropertiesHandler.*;

import com.makaia.booker.api.services.IncidentSerivce;
import com.makaia.servicenow.ui.pages.LoginPage;
import com.makaia.testng.apis.TestNGHooks;

public class IncidentTests extends TestNGHooks {
	
	@BeforeTest
	public void beforeTest() {
		testcaseName = "CreateIncident";
		testDescription = "Validation of create incident";
		authors = "Karthikeyan";
		category = "Smoke";
	}
	
	@Test
	public void testCreateNewIncident() {
		new LoginPage()
		    .enterUserName(config("makaia.servicenow.username"))
		    .enterPassword(secret("service.now.instance.password"))
		    .clickLoingButton()
		    .getIncidentNumber()
		    .enterCallerId("Service Desk")
		    .enterShortDescription("Sub")
		    .clickSubmitButton()
		    .filterByNumber()
		    .validateIncidentCreation();
		
	}
	
	@Test
	public void testCreateNewIncidentInApi() {
		new IncidentSerivce()
		    .getIncidentByNumber(incidentNumber)
		    .validateStatusCode(200)
		    .validateStatusLine("OK")
		    .validateContentType("application/json");
	}

}