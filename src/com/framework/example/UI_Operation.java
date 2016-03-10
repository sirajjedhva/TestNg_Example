package com.framework.example;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UI_Operation {

	WebDriver driver;
	
	public UI_Operation(WebDriver driver){
		this.driver=driver;
	}
	public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
	  switch(operation.toUpperCase()){
	  
	  case "CLICK":
		  driver.findElement(this.getObject(p,objectName,objectType)).click();
		  break;
		  
	  case "SETTEXT":
		  driver.findElement(this.getObject(p, objectName, objectType)).sendKeys(value);;
		  break;
		  
	  case "GOTOURL":
		  driver.get(p.getProperty(value));
		  break;
		  
	  case "GETTEXT":
		  driver.findElement(this.getObject(p, objectName, objectType)).getText();
		  break;
		  
	  default : 
	      break;	  
	  }
	}
	private By getObject(Properties p,String objectName,String objectType) throws Exception{
		
		//find XPath
		if(objectType.equalsIgnoreCase("XPATH")){
			return By.xpath(objectName);
		}
		//find Class
		else if(objectType.equalsIgnoreCase("CLASS")){
			return By.className(objectName);
		}
		//find name
		else if(objectType.equalsIgnoreCase("NAME")){
			return By.name(objectName);
		}
	
	   //find by css
	   else if(objectType.equalsIgnoreCase("CSS")){
		   return By.cssSelector(objectName);
	   }
		//find By link
		else if (objectType.equalsIgnoreCase("LINK")) {
			return By.linkText(objectName);
    	}
		//find by partialLink
		else if(objectType.equalsIgnoreCase("PARTIALLINK")){
			return By.partialLinkText(objectName);
		}else{
			throw new Exception("wrong Object Type");
		}
    }
}