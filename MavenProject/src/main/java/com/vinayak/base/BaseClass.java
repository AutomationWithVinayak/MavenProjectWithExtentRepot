package com.vinayak.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.vinayak.utility.Util;

public class BaseClass {

	public static final Logger log = LogManager.getLogger(new Object().getClass().getName());
	public static WebDriver driver ;
	public static Properties pros ;



	public BaseClass()  {

		try {
			String path = System.getProperty("user.dir");
			FileInputStream file = new FileInputStream (path+"\\Properties.text");
			pros = new Properties();
			pros.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*___________________________________________________________________________________________________________________________________________________*/   



	@SuppressWarnings("deprecation")
	public static void setup() {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.get(pros.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Util.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD, TimeUnit.SECONDS);

	}


	/*___________________________________________________________________________________________________________________________________________________*/   



	public static String takeScreenshot(String testName ) {

		Date date =new Date();
		String rdate=date.toString().replace(" ", "_").replace(":", "_");		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\Screenshot\\"+rdate+testName+".png");

		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dest.getAbsolutePath() ;

	}

	/*___________________________________________________________________________________________________________________________________________________*/   



	public void tempWaitInSec(int a) {

		int b =1000*a;

		try {
			Thread.sleep(b);
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}



}
