package com.vinayak.listners;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vinayak.base.BaseClass;


public class ExtendReportGenerator extends BaseClass {
	
	
	  public  ExtentReports getExtendReport() {
		
		ExtentReports report = new ExtentReports();
		
		Date date =new Date();
		String rdate=date.toString().replace(" ", "_").replace(":", "_");
		File extentReportFile= new File(System.getProperty("user.dir")+"\\ExtentReport\\"+rdate+"eReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimelineEnabled(true);
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
		//sparkReporter.config().setProtocol(Protocol.HTTPS);
		sparkReporter.config().setDocumentTitle("Extent Repot For Automation Test By Vinayak ");
		sparkReporter.config().setEncoding("uft-8");
		sparkReporter.config().setReportName("Vinayak Bhandurge");
		report.attachReporter(sparkReporter);
		
		return report;
		
	}

	

	
	
	

}
