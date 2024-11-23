package com.makaia.booker.api.services;

import com.makaia.general.utils.PropertiesHandler;
import com.makaia.pojo.serialization.Token;
import com.makaia.rest.assured.base.RestAssuredBase;

import io.restassured.specification.RequestSpecification;

public class AuthService extends RestAssuredBase {
	
	private RequestSpecification setUp() {
		return requestSpec(PropertiesHandler.config("booker.base.uri"), 
				    PropertiesHandler.config("booker.auth.base.path"));
	}
	
	public String createToken(String userName, String password) {
		Token token = new Token();
		token.setUsername(userName);
		token.setPassword(password);
		return postMethod(setUp(), token).jsonPath().getString("token");
	}

}