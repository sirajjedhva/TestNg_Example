package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestNg_Pbasic {
	String author="guru99";
	String searchKey="india";
	WebDriver driver;
	
	@Test(priority=1)
	public void noParameter() throws InterruptedException{
		
		driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		
		WebElement search;
		search=driver.findElement(By.name("q"));
		search.sendKeys(searchKey);
		
		System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
		System.out.println("Thread is sleeping now");
		
		Thread.sleep(3000);
		
		System.out.println("Value in searchbox "+search.getAttribute("value")+"value give by input" +searchKey);
		
		
     Assert.assertTrue(search.getAttribute("value").equalsIgnoreCase(searchKey));
		
	}
	@Test(priority=2)
    public void quiteBrowser(){
    	driver.close();
    }
}
