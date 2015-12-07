package ExcelFile_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InxPms_Login {
	//WebDriver driver;
	
	WebDriver driver;
	
	@Test(dataProvider="dataFromSheet")
	public void Login(String username,String password){
		driver=new FirefoxDriver();
		driver.get("http://pms.inheritxserver.net");
		driver.findElement(By.id("loginform-email")).sendKeys(username);
		driver.findElement(By.id("loginform-password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login-form']/div[3]/button")).click();
		
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		Assert.assertTrue(driver.getTitle().contains("My Yii"),"got incorrect title");
		System.out.println("Successful login");
	}
	@AfterMethod
	public void browserQuit(){
		System.out.println("Browser is closed");
		driver.quit();
	}
	@DataProvider(name="dataFromSheet")
	public Object[][] getData(){
		String path=System.getProperty("user.dir");
		System.out.println(path+"/excelfile/TestData.xls");
		ExcelData ed=new ExcelData(path+"/excelfile/TestData.xls");
		int rows=ed.getRowCount(0);
		Object[][] data=new Object[rows][2];
		
		for(int i=0;i<rows;i++){
			data[i][0]=ed.getData(0, i,0);
		    data[i][1]=ed.getData(0, i, 1);
		}
		return data;
	}

}
