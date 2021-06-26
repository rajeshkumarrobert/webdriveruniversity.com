package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonFunctions.CommonFunctions;

public class ToDoListObjects extends CommonFunctions {
	
	@FindBy(id="to-do-list")
	public static WebElement ToDoButton;
     
	@FindBy(xpath="//li[contains(text(),'Go')]")
	public static WebElement GoToPortionText;
	
	@FindBy(xpath="//li[contains(text(),'Buy')]")
	public static WebElement BuyText;
	
	@FindBy(xpath="//li[contains(text(),'Practice')]")
	public static WebElement PracticeText;
	
	@FindBy(id="plus-icon")
	public static WebElement AddButton;
}
