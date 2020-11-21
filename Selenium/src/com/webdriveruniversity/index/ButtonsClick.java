package com.webdriveruniversity.index;


import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import commonFunctions.CommonFunctions;
import pageObjects.ButtonObjects;

public class ButtonsClick extends CommonFunctions{
	String OldWindow;
	Logger logger=Logger.getLogger(ButtonsClick.class);
	@Test(priority=0)
	public void clickButton()
	{
		OldWindow= driver.getWindowHandle();
		logger.info("Button operation test case Execution started");
		PageFactory.initElements(driver,ButtonObjects.class);
		ButtonObjects.button.click();
		logger.info("Switching to New tab for button operations");
		ArrayList<String>newTabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTabs.get(1));
	}
	
	@Test(priority=1)
	public void buttonOperations(){
		PageFactory.initElements(driver,ButtonObjects.class);
		ButtonObjects.firstButton.click();
	
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath
				("//h4[contains(text(),'Congratulations')]/preceding-sibling::button"))).click();
		
		ButtonObjects.secondButton.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath
				("//h4[contains(text(),'It')]/preceding-sibling::button"))).click();
		
		ButtonObjects.thirdButton.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath
				("//h4[contains(text(),'Well done')]/preceding-sibling::button"))).click();
		driver.close();
		driver.switchTo().window(OldWindow);
	}

}
