package com.vinayak.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.vinayak.base.BaseClass;

public class MyListners extends BaseClass  implements ITestListener {


	ExtentReports report = new ExtendReportGenerator().getExtendReport();
	ExtentTest test;




	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		test = report.createTest(testName);
		test.log(Status.INFO, testName+ " Execution Started...... ");

	}



	public void onTestSuccess(ITestResult result) {

		String testName=result.getName();
		test.log(Status.PASS, testName+ " Got Successfully Executed  ");

	}



	public void onTestFailure(ITestResult result) {

		String testName=result.getName();
		test.log(Status.FAIL, testName+ " Got Fail ! ");
		test.addScreenCaptureFromPath(takeScreenshot(testName),testName);
		test.log(Status.INFO, result.getThrowable());

	}


	public void onTestSkipped(ITestResult result) {

		String testName=result.getName();
		test.log(Status.SKIP, testName+ " Got Skipped ");
		test.log(Status.INFO, result.getThrowable());


	}


	public void onFinish(ITestContext context) {
		
		test.log(Status.INFO, "\n"
				+ "------------------------------------"+'\n'
				+ "---------VINAYAK-FRAMEWORK----------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "--------Execution_Completed---------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "----------Guru-Ranjeet--------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "----------------*-------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+"------------------------------------"+'\n'
				+"------------------------------------");
		
		log.info("\n"
				+ "------------------------------------"+'\n'
				+ "---------VINAYAK-FRAMEWORK----------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "--------Execution_Completed---------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "-----------Guru-Ranjeet-------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "----------------*-------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+"------------------------------------"+'\n'
				+"------------------------------------");

		report.flush();

	}





}
