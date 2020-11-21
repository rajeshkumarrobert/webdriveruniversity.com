package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObjects {
	
	@FindBy(how=How.ID, using="text")
	public static WebElement userName;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(id="login-button")
	public static WebElement loginButton;
	
}
