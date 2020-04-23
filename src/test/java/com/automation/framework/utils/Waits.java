package com.automation.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

  public Waits waitForElementToBeClickable(WebDriver driver, WebElement element) {
    WebDriverWait wait =new WebDriverWait(driver,2);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    return this;
  }

  public Waits waitForElementToBeDisplayed(WebDriver driver,final WebElement element) {
    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver d) {
        return element.isDisplayed();
      }
    });
    return this;
  }
  
  

}
