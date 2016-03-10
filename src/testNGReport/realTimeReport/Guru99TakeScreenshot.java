package testNGReport.realTimeReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Guru99TakeScreenshot {
	
	@Test
	public void takeScreenshot() throws IOException{
	
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.guru99.com/V4/");
		this.takeSnapShot(driver,"/home/inheritx_sales/Desktop/test.png");
	}

	private void takeSnapShot(WebDriver webdriver, String filePath) throws IOException {
		// TODO Auto-generated method stub
		
		 //Convert web driver object to TakeScreenshot
		TakesScreenshot sh=((TakesScreenshot) webdriver);
		
		//Call getScreenshotAs method to create image file
		File srcFile=sh.getScreenshotAs(OutputType.FILE);
		 //File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		File srcfile1=new File(filePath);
		FileUtils.copyFile(srcFile, srcfile1);
	}
	

}
