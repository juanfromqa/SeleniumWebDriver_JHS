package com.automation.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author Juan Hernandez WebDriver setup for testing
 *
 */
public class MyDriver {

	private WebDriver driver;
	ChromeOptions chromeOptions;

	public MyDriver(String browser, Boolean isHeadless) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/juan.hernandez/Documents/webdrivers/chromedriver");

			if (isHeadless) {
				chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				driver = new ChromeDriver(chromeOptions);
			} else {
				driver = new ChromeDriver();
			}
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "/Users/juan.hernandez/Documents/webdrivers/geckodriver" + "");
			driver = new FirefoxDriver();
			break;

		default:
			break;

		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}

}
