package com.makaia.testng.apis;

import org.testng.annotations.BeforeMethod;

import com.makaia.booker.api.services.AuthService;
import com.makaia.booker.api.services.BookingService;
import com.makaia.general.utils.PropertiesHandler;

public class BookerApiHooks {
	
	protected AuthService auth;
	protected BookingService booking;
	protected String token;
	
	@BeforeMethod
	public void beforeMethod() {
		auth = new AuthService();
		booking = new BookingService();
		token = auth.createToken(PropertiesHandler.config("booker.username"),
				                 PropertiesHandler.secret("booker.password"));
	}

}
