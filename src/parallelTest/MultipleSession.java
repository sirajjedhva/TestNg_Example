package parallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class MultipleSession {
	
	@Test
	public void executeSessionOne(){
		//First session of WebDriver
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"/chromedriver/chromedriver.exe" );
		
		WebDriver driver=new ChromeDriver();
		 //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
		
		
	}
	
	public void executeSessionTwo(){
		//second session WebDriver
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"/chromedriver/chromedriver.exe" );
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/V4/");
		
	}

}
