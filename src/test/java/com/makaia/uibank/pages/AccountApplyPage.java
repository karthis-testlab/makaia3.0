package com.makaia.uibank.pages;

import com.makaia.selenium.api.design.Locators;
import com.makaia.testng.apis.UiBankHooks;

public class AccountApplyPage extends UiBankHooks {
	
	public AccountApplyPage enterNickname(String nickName) {
		type(locateElement(Locators.ID, "accountNickname"), nickName);
		return this;
	}
	
	public AccountApplyPage selectAccountTypeAsSavings() {
		dropdownSelectByValue(locateElement(Locators.ID,"typeOfAccount"), "savings");
		return this;
	}
	
	public AccountCreateResultsPage clickOnTheApplyButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Apply']"));
		return new AccountCreateResultsPage();
	}

}