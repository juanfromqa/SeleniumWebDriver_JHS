package com.automation.framework.dataproviders;

import org.testng.annotations.DataProvider;

public class StaticProvider {
	@DataProvider(name = "validCredential")
	public static Object[][] createData() {
		return new Object[][] { { "testuser@example.com", "test123" } };
	}
	
	@DataProvider(name = "invalidCredentials")
	public static Object[][] invalidCredentials() {
		return new Object[][] { { "testuser@example.com", "" }, { "", "" }, { "", "test123" }};
	}
}