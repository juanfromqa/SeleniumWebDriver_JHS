package com.automation.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Juan Hernandez This class creates a base page for all the pages from
 *         the SUT
 */
public class BasePage extends Waits {
	public WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		this.wait = new WebDriverWait(pDriver, 10);
		this.driver = pDriver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	protected WebDriver getDriver() {
		return driver;
	}

	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Override
	public Waits waitForElementToBeDisplayed(WebDriver driver, final WebElement element) {
		return super.waitForElementToBeDisplayed(driver, element);
	}

}
