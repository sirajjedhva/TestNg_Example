package facebook;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLogin {
	
	ChromeDriver driver;
	
	@Test(dataProvider="FacebookData")
	public void openBrowser(String username,String password){
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"/Chrome/chromedriver" );
		driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='u_0_v']")).click();
	  
          try{
    	     Thread.sleep(5000);
    	 
            }catch(Exception e){
    	      e.printStackTrace();
        }
       Assert.assertTrue(driver.getTitle().contains("Facebook"),"Got Incorrect");
       System.out.println("Successfully login");
     }
	
	
	@AfterMethod
	public void logout(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(By.id("userNavigationLabel")));
				element.click();
		try{
		 System.out.println("Wait for 6 sec");
		  Thread.sleep(6000);
		  WebElement cls = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='_54nc']/span/span[contains(text(), 'Log Out')]")));
		  
		 cls.click();
		 System.out.println("Logout Successfully");
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	
	
	@AfterMethod
	public void quit(){
		System.out.println("Browser is closed");
		driver.quit();
		}
	
	
	@DataProvider(name="FacebookData")
	public Object[][] getData(){
		String path=System.getProperty("user.dir");
		System.out.println(path+"/excelfile/facebook.xls");
		FacebookData excel=new FacebookData(path+"/excelfile/facebook.xls");
		int rows=excel.getRowCount(0);
		Object[][] data=new Object[rows][2];
		for(int i=0;i<rows;i++){
			data[i][0]=excel.getExcel(0, i, 0);
			data[i][1]=excel.getExcel(0, i, 1);
		}
		return data;
		
	}
}
