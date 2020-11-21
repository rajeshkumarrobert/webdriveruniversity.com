package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonFunctions.CommonFunctions;

public class ButtonObjects extends CommonFunctions {
	
	@FindBy(id="button-clicks")
	public static WebElement button;
	
	@FindBy(id="button1")
	public static WebElement firstButton;
	
	@FindBy(id="button2")
	public static WebElement secondButton;
	
	@FindBy(id="button3")
	public static WebElement thirdButton;

}
