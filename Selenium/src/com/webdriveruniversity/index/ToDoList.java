package com.webdriveruniversity.index;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import commonFunctions.CommonFunctions;
import pageObjects.ToDoListObjects;

public class ToDoList extends CommonFunctions {
	String parentWindow;
	@Test(priority=0)
	public void ClickToDoList(){
		parentWindow = driver.getWindowHandle();
		PageFactory.initElements(driver, ToDoListObjects.class);
		ToDoListObjects.ToDoButton.click();
		ArrayList<String>newTabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTabs.get(1));
	}
	@Test(priority=1)
	public void ToDoListOperations(){
		PageFactory.initElements(driver, ToDoListObjects.class);
		Actions action = new Actions(driver);
		action.moveToElement(ToDoListObjects.PracticeText).click().build();
		
		action.moveToElement(ToDoListObjects.BuyText).click().build();

		action.moveToElement(ToDoListObjects.GoToPortionText).click().build();
		deleteList();
		
	}
	public void deleteList(){
		List<WebElement> lists= driver.findElements(By.xpath("//li"));
		int count=lists.size();
		for (int i = 1; i <= count; i++) {
			String TrashIcon="//*[@id='container']/ul/li["+i+"]/span/i";
			driver.findElement(By.xpath(TrashIcon)).click();
		}
	}
		@Test(priority=2)
		public void addToDoList() throws IOException{
			loadPropertyFile();
			/*PageFactory.initElements(driver, ToDoListObjects.class);
			ToDoListObjects.AddButton.click();*/
		    WebElement textarea=driver.findElement(By.xpath("//input"));
		    textarea.click();
			String checklist1= properties.getProperty("AddList1");
			String checklist2= properties.getProperty("AddList2");
			String checklist3= properties.getProperty("AddList3");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			textarea.sendKeys(checklist1,Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			textarea.sendKeys(checklist2,Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			textarea.sendKeys(checklist3,Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			deleteList();
			driver.close();
			driver.switchTo().window(parentWindow);
		}
	
}
