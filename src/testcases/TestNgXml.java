package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TestNgXml {
    WebDriver driver;
	
	@Test
	@Parameters({"author","searchKey"})
	public void xmlParameter(@Optional("Abc")String author,String searchKey) throws InterruptedException{
		
		driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		
		WebElement searchText;
		searchText=driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		
		System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
		 
        System.out.println("Thread will sleep now");
 
        Thread.sleep(3000);
        
        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
		
        Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
	}
	
}
