package com.webdriveruniversity.index;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObjects.LoginPageObjects;


public class LoginCases extends CommonFunctions{
	WebElement UserName,Password,loginBtn;
	String OldWindow;
	String [][] data=null;
	Logger logger=Logger.getLogger(LoginCases.class);
	@DataProvider(name="loginData")
	public  String[][] loginDataProvider() throws BiffException, IOException{
		data=getExcelData();
		return data;
	}
	
	public String[][] getExcelData() throws BiffException, IOException{
		FileInputStream excel = new FileInputStream("C:\\Users\\Indium Software\\Downloads\\TestValue.xls");

		Workbook workbook = Workbook.getWorkbook(excel);

		Sheet sheet = workbook.getSheet(0);
		int RowsCount = sheet.getRows();
		int ColumnsCount=sheet.getColumns();

		String testData[][] = new String[RowsCount-1][ColumnsCount];
		for (int i = 1; i < RowsCount; i++) 
		{
			for (int j = 0; j < ColumnsCount; j++) {
				testData[i-1][j]=sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}

	@Test(priority=0)
	public void ClickLoginButton(){
		OldWindow= driver.getWindowHandle();
		logger.info("Clicking Login Button in index page");
		WebElement Loginbtn=driver.findElement(By.xpath("//*[@id='login-portal']/div/div[1]"));
		Loginbtn.click();
		logger.info("Switching to New Login Tab");
		ArrayList<String>newTabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTabs.get(1));
	}
	@Test(priority=1,dataProvider="loginData")
	public void CorrectUsername(String uName, String pword) {
		logger.info("Executing different type of data");
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.userName.sendKeys(uName);
		LoginPageObjects.password.sendKeys(pword);
		LoginPageObjects.loginButton.click();

		Alert normalAlert = driver.switchTo().alert();
		normalAlert.accept();
		
	}
	@Test(priority=2)
	public void switchTab(){
		logger.info("Execution of Logincase is Done");
		driver.close();
		driver.switchTo().window(OldWindow);
		System.out.println(driver.getCurrentUrl());
	}
}


