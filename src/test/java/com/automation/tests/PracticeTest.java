package com.automation.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.framework.pages.PracticePage;
import com.automation.framework.utils.BaseTest;
import com.automation.framework.utils.CommonActions;

public class PracticeTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		practicePage = new PracticePage(webDriver);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		practicePage.dispose();
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest(ITestResult result) {
		// Uncomment this line:
		CommonActions.takeScreenShot(result.getStatus(), result.getName(), webDriver);
		System.out.println("* ScreenShot here *");

	}

	// dependsOnMethod defines execution order. If dependent test fails, this method
	// wont be executed
	@Test(enabled = false, groups = { "sanity" }, dependsOnMethods = { "test_comboBoxSelection" })
	public void test_clickRadioButtons() {
		practicePage.goToPracticePage();
		practicePage.selectRadioButton("benz");
		practicePage.selectRadioButton("honda");
		practicePage.selectRadioButton("bmw");

		assertTrue(practicePage.radioBmwRadioButton.isSelected());
		assertFalse(practicePage.radioHondaRadioButton.isSelected());
	}

	@Test(enabled = true)
	public void test_comboBoxSelection() throws InterruptedException {
		practicePage.goToPracticePage();
		practicePage.selectOneFromDropDownMenu("benz");
		practicePage.selectOneFromDropDownMenu("honda");
		practicePage.selectOneFromDropDownMenu("bmw");

	
	}

}
