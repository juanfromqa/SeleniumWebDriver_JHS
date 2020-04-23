package com.automation.framework.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.framework.utils.BasePage;

public class LoginResultPage extends BasePage {

	public LoginResultPage(WebDriver pDriver) {
		super(pDriver);
	}

	@FindBy(css = "#my-notes-page button")
	private WebElement btnAddnote;

	public Boolean isBtnAddNoteDisplayed() {
		return btnAddnote.isDisplayed();
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
