package com.makaia.servicenow.ui.pages;

import static com.makaia.general.utils.PropertiesHandler.config;
import com.makaia.selenium.api.design.Locators;
import com.makaia.testng.apis.TestNGHooks;

public class LoginPage extends TestNGHooks {
	
	public LoginPage() {
		loadUrl(config("makaia.aut.url"));
	}
	
	public LoginPage enterUserName(String userName) {
		type(locateElement(Locators.ID, "user_name"), userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		type(locateElement(Locators.ID, "user_password"), password);
		return this;
	}

	public IncidentPage clickLoingButton() {
		click(locateElement(Locators.ID, "sysverb_login"));
		return new IncidentPage();
	}

}