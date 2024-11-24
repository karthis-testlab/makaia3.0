package com.makaia.uibank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.makaia.selenium.api.design.Locators;
import com.makaia.testng.apis.UiBankHooks;

public class AccountsPage extends UiBankHooks {
	
	public AccountApplyPage clickApplyNewAccountButton() {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Apply For New Account')]")));
		click(locateElement(Locators.XPATH, "//div[contains(text(),'Apply For New Account')]"));
		return new AccountApplyPage();
	}

}