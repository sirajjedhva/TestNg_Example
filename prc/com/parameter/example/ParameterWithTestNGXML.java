package com.parameter.example;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterWithTestNGXML {
 
	WebDriver driver;
	
	@Test
	@Parameters({"author","searchKey"})
	public void testWithParameter(@Optional("Abc")String author,String searchKey){
		
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		
		WebElement serchkey=driver.findElement(By.name("q"));
		serchkey.sendKeys(searchKey);
		
		System.out.println("WelCome " + author + " Your serch key " +searchKey);
		
		System.out.println("Value in google box "+(serchkey.getAttribute("value"))+" ::: value is given by input" +serchkey);
		
		Assert.assertTrue(serchkey.getAttribute("value").equalsIgnoreCase(searchKey));
		
	}
	@AfterTest
	public void quit(){
		driver.quit();
	}
}
