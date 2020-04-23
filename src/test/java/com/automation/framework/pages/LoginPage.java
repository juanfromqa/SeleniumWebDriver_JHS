package com.automation.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.utils.CommonActions;

public class LoginPage extends CommonActions {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "button[onclick=\"App.showLoginPage();\"]")
	private WebElement welcomeLoginButton;
	
	@FindBy(css = "button[onclick=\"App.login()\"]")
	private WebElement loginButton;
	
	@FindBy(css = "button[onclick=\"App.showWelcomePage()\"]")
	private WebElement cancelButton;

	@FindBy(css = "input[placeholder=\"Username\"].form-control")
	private WebElement txtUserName;

	@FindBy(css = "input[placeholder=\"Password\"].form-control")
	private WebElement txtPassword;
	
	@FindBy(id = "login-error-message")
	private WebElement errorInvalidCredentials;

	public void clickWelcomeLogin() {
		clickButton(welcomeLoginButton);
	}
	
	public void goToLoginPage() {
		driver.get("http://testapp.galenframework.com/");
	}
	
	public void clickLogin() {
		clickButton(loginButton);
	}

	public void fillUserName(String user) {
		enterText(txtUserName, user);
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password);
	}

	public LoginResultPage login() {
		clickButton(loginButton);
		return new LoginResultPage(driver);
	}
	
	public WebElement getInvalidCredentialsError() {
		return errorInvalidCredentials;
	}

	public void clickCancel() {
		clickButton(cancelButton);
	}
	
}
