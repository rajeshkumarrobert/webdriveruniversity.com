package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonFunctions.CommonFunctions;

public class ContactUsObjects extends CommonFunctions {
	
	@FindBy(id="contact-us")
	public static WebElement contactUSbutton;
	
	@FindBy(xpath="//input[@name='first_name']")
	public static WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	public static WebElement lastName;

	@FindBy(xpath="//input[@name='email']")
	public static WebElement email;
	
	@FindBy(xpath="//textarea[@name='message']")
	public static WebElement message;
	
	@FindBy(xpath="//input[@value='RESET']")
	public static WebElement reset;
	
	@FindBy(xpath="//input[@value='SUBMIT']")
	public static WebElement submit;
}
