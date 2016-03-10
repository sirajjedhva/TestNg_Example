package com.pms.script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PMS_Script {
	
	 WebDriver driver;
	
	@Test(priority=1)
	 public void browserOpen(){
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get("http://pms.inheritxserver.net/login");
	 }
	
	@Test(priority=2)
	public void pmsLogin() throws InterruptedException{
		driver.findElement(By.id("loginform-email")).sendKeys("siraj@inheritx.com");
		driver.findElement(By.id("loginform-password")).sendKeys("inx@!123");
		driver.findElement(By.xpath("//*[@id='login-form']/div[3]/button")).submit();
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#w1 > li:nth-child(3) > a")).click();
		
		String titile=driver.getTitle();
		System.out.println(titile);
	}
	
	@Test(priority=3)
	public void addTimesheet() throws InterruptedException{
	   driver.findElement(By.cssSelector("body > div.wrap > div > div.timesheet-index > p > a")).click();
	  
	   Select project=new Select(driver.findElement(By.id("timesheet-project_id")));
	   project.selectByVisibleText("Research & Development");
	   project.selectByIndex(8);
	   
	   Thread.sleep(5000);
	   Select milestone=new Select(driver.findElement(By.id("timesheet-milestone_id")));
 	   milestone.selectByVisibleText("Research & Development - Milestone");
 	   milestone.selectByIndex(1);
 	   
 	   Thread.sleep(6000);
 	   Select task=new Select(driver.findElement(By.id("timesheet-task_id")));
 	   task.selectByVisibleText("Research & Development - Task");
 	   task.selectByIndex(1);
 	   
 	   Thread.sleep(6000);
 	   Select task_type=new Select(driver.findElement(By.id("timesheet-task_type")));
 	   task_type.selectByVisibleText("Normal");
 	   task_type.selectByIndex(1);
 	   
 	   WebElement description=driver.findElement(By.id("timesheet-task_description"));
 	   description.sendKeys("QA for HappenShare-Android.");
	}
    @Test(priority=4)
	public void selectDate(){
		WebElement date=driver.findElement(By.id("timesheet-entry_date"));
		date.sendKeys("2016-02-25");
		
		WebElement hours=driver.findElement(By.id("timesheet-hours"));
		hours.sendKeys("02");
		
		WebElement minutes=driver.findElement(By.id("timesheet-minutes"));
		minutes.sendKeys("0");
		
		driver.findElement(By.xpath("//*[@id='w0']/div[11]/button")).click();
	}
}
