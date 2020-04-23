package com.automation.framework.utils.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.framework.utils.BaseTest;

public class MyListener extends BaseTest implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("Pruebas finalizadas");

	}

	public void onStart(ITestContext arg0) {
		System.out.println("Comenzando con las pruebas automatizadas");

	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test: " + arg0.getInstanceName() + " FAILED");
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test:" + arg0.getInstanceName() + " SKIPPED");

	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test: " + arg0.getName() + " PASSED");

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
