package com.webdriveruniversity.index;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.POMobjects;

public class POM extends CommonFunctions {
	String ParentWindow;
	
	@Test(priority=0)
	public void POMactions(){
		ParentWindow=driver.getWindowHandle();
		PageFactory.initElements(driver, POMobjects.class);
		POMobjects.POMButton.click();
		ArrayList<String>newTabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTabs.get(1));
	}

	@Test(priority=1)
	public void FindOut(){
		PageFactory.initElements(driver, POMobjects.class);
		POMobjects.findOutButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
	}
	
	@Test(priority=2)
	public void OurProducts() throws InterruptedException{
		PageFactory.initElements(driver, POMobjects.class);
		POMobjects.OurProducts.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		POMobjects.UsedLaptop.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		POMobjects.Cameras.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		POMobjects.NewLaptop.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		POMobjects.SpecialOffers.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		POMobjects.AudioSystem.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		driver.close();
		driver.switchTo().window(ParentWindow);
	}
}
