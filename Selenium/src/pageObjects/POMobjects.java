package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonFunctions.CommonFunctions;

public class POMobjects extends CommonFunctions{
	@FindBy(id="page-object-model")
	public static WebElement POMButton;

	@FindBy(id="button-find-out-more")
	public static WebElement findOutButton;
	
	@FindBy(linkText="Our Products")
	public static WebElement OurProducts;
	
	@FindBy(id="container-special-offers")
	public static WebElement SpecialOffers;
	
	@FindBy(id="container-product1")
	public static WebElement Cameras;
	
	@FindBy(id="container-product2")
	public static WebElement NewLaptop;
	
	@FindBy(id="container-product3")
	public static WebElement UsedLaptop;
	
	@FindBy(id="container-product7")
	public static WebElement AudioSystem;

}
