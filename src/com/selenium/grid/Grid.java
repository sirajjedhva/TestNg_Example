package com.selenium.grid;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Grid {

	WebDriver driver;
	
	@BeforeMethod
	public void f() throws MalformedURLException{
		DesiredCapabilities cp=DesiredCapabilities.firefox();
		
		driver=new RemoteWebDriver(new URL("http://192.168.1.162:5555/wd/hub"), cp);
	}
	
	@Test
	public void textType(){
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		TakesScreenshot sh=(TakesScreenshot) driver;
	File src=sh.getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(src, new File("grid.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
	}
	@AfterMethod
	public void quit(){
		driver.quit();
	}
}
