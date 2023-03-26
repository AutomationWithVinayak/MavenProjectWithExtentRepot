package com.vinayak.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vinayak.base.BaseClass;

@Listeners(com.vinayak.listners.MyListners.class)
public class Test1 extends BaseClass {



	@BeforeMethod
	public void m1() {

		setup();
	}


	@Test
	public void m2() {

		driver.findElement(By.id("email")).sendKeys("123456");
		driver.findElement(By.id("pass")).sendKeys("456789");

	}

	@Test
	public void m4() {

		driver.findElement(By.id("email")).sendKeys("123456");
		driver.findElement(By.id("pas")).sendKeys("456789");

	}


	@AfterMethod
	public void m3() {
        tempWaitInSec(3);
        driver.quit();
		
	}

}
