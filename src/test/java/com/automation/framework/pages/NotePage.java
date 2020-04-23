package com.automation.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.framework.utils.BasePage;

public class NotePage extends BasePage {

	public NotePage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = ".form-control")
	private WebElement txtTitle;

	@FindBy(name = "form-control")
	private WebElement txtUserName;
	
	public void clicknotebutton() {
	//	clickButton(loginButton);
	}

	public void fillTitle(String user) {
	//	enterText(txtUserName, user);
	}

	public void fillNote(String password) {
	//	enterText(txtPassword, password);
	}
	
	
	
}
