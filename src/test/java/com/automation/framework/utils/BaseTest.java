package com.automation.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.framework.pages.LoginPage;
import com.automation.framework.pages.PracticePage;

/**
 * 
 * @author Juan Hernandez All test classes should extend from this class
 *
 */
public class BaseTest {

	public MyDriver myDriver;
	public WebDriver webDriver;
	public LoginPage loginPage;
	public PracticePage practicePage;

	// alwawsRun annotation help us when we are using TestNG groups
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser", "isHeadless" })
	public void beforeSuite(@Optional String browser, @Optional Boolean isHeadless) {

		if (browser == null && isHeadless == null) {
			// Default values
			myDriver = new MyDriver("chrome", false);
		} else {
			myDriver = new MyDriver(browser, isHeadless);
		}
		this.webDriver = myDriver.getDriver();

	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public PracticePage getPracticePage() {
		return practicePage;
	}

	

	

}