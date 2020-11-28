package com.webdriveruniversity.index;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctions.CommonFunctions;
import pageObjects.ContactUsObjects;

public class ContactUS extends CommonFunctions{
	String parentWindow;
	
	@Test(priority=0)
	public void clickContactUS()
	{
		parentWindow = driver.getWindowHandle();
		PageFactory.initElements(driver,ContactUsObjects.class);
		ContactUsObjects.contactUSbutton.click();
		ArrayList<String>newTabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTabs.get(1));
	}
	@Test(priority=1)
	public void contactUsValues() throws IOException{
		loadPropertyFile();
		PageFactory.initElements(driver,ContactUsObjects.class);
		String firstName= properties.getProperty("FirstName");
		ContactUsObjects.firstName.sendKeys(firstName);
		
		String secondName=properties.getProperty("LastName");
		ContactUsObjects.lastName.sendKeys(secondName);
		
		String email=properties.getProperty("Email");
		ContactUsObjects.email.sendKeys(email);
		
		String message=properties.getProperty("Message");
		ContactUsObjects.message.sendKeys(message);
		
		ContactUsObjects.submit.click();
		String url=driver.getCurrentUrl();
		if (url.equals("http://webdriveruniversity.com/Contact-Us/contact-form-thank-you.html")){
			System.out.println("Success");
			Assert.assertEquals("Thank You for your Message!", driver.findElement(By.xpath("//div[@id='contact_reply']")).getText());
			driver.close();
			driver.switchTo().window(parentWindow);
		}else{
			System.out.println("failed");
			driver.close();
			driver.switchTo().window(parentWindow);
		}
	}

}
