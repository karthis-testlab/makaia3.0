package com.makaia.uibank.pages;

import com.makaia.selenium.api.design.Locators;
import com.makaia.testng.apis.UiBankHooks;

public class LoginPage extends UiBankHooks {
	
	public LoginPage enterUsername(String username) {
		type(locateElement(Locators.ID, "username"), username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		type(locateElement(Locators.ID, "password"), password);
		return this;
	}

	public LoginPage clickLoginButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Sign In']"));
		return this;
	}
	
	public AccountsPage clickOnThePrivacyPolicyButton() {
		click(locateElement(Locators.XPATH, "//button[contains(text(), 'I agree to the Privacy Policy')]"));
		return new AccountsPage();
	}

}