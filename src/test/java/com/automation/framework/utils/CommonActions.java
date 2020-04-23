package com.automation.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonActions extends BasePage {

	public CommonActions(WebDriver pDriver) {
		super(pDriver);
	}

	public void enterText(WebElement element, String text) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(text);
		} catch (Exception e) {
			System.err.println(element + " was not found, please verify.");
		}

	}

	public void clickButton(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public boolean isDisplayed(WebDriver driver, WebElement element) {
		waitForElementToBeDisplayed(driver, element);
		return element.isDisplayed();
	}

	public static void takeScreenShot(int testStatus, String testName, WebDriver driver) {

		String formattedDate = formatCurrentTime();
		String status = Constants.UNKNOWN;

		if (testStatus == 1) {
			status = Constants.SUCCESSFUL;
		} else if (testStatus == 2) {
			status = Constants.FAILED;
		}

		String fileName = String.format(Constants.FILENAME_FORMAT, status, testName, formattedDate);
		String directory = Constants.SCREENSHOTS_DIRECTORY;

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File(directory + fileName));
		} catch (IOException e) {
			System.out.println("Unable to take screenshot for " + testName + e.getMessage());
		}
	}

	private static String formatCurrentTime() {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH_mm_ss");
		Date date = new Date(System.currentTimeMillis());

		return formatter.format(date);
	}

	public String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = Constants.AZ09;

		for (int i = 0; i < length; i++) {
			int index = (int) Math.random() * characters.length();
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	public String getRandomChar(int length) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int index = (int) Math.random() * Constants.ASCII_CHARS.length();
			sb.append(Constants.ASCII_CHARS.charAt(index));
		}
		return sb.toString();
	}

}
