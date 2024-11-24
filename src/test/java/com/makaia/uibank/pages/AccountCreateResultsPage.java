package com.makaia.uibank.pages;

import com.makaia.testng.apis.UiBankHooks;

public class AccountCreateResultsPage extends UiBankHooks {
	
	public AccountCreateResultsPage validateAccountCreation() {
		try {
			Thread.sleep(2000);
			System.out.println(getDriver().getCurrentUrl());
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
		return this;
	}

}
