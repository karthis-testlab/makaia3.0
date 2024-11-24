package com.makaia.uibank.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.makaia.testng.apis.UiBankHooks;
import com.makaia.uibank.pages.LoginPage;

public class UIBankTest extends UiBankHooks {
	
	@BeforeTest
	public void beforeTest() {
		testcaseName = "UIBankTest";
		testDescription = "Validation of UiBank functionalities";
		authors = "Karthikeyan";
		category = "Smoke";
	}
	
	@Test
	public void userShouldAbleToLogin() {
		new LoginPage()
		    .enterUsername("FebApiuser") 
		    .enterPassword("Eagle@123")
		    .clickLoginButton()
		    .clickOnThePrivacyPolicyButton()
		    .clickApplyNewAccountButton()
		    .enterNickname("TEST Nick Name")
		    .selectAccountTypeAsSavings()
		    .clickOnTheApplyButton()
		    .validateAccountCreation();
	}

}