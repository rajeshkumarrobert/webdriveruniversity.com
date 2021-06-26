package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	public static WebDriver driver;
	public static Properties properties=null;
	
	Logger logger = Logger.getLogger(CommonFunctions.class);
	
	public Properties loadPropertyFile() throws IOException{
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		
		properties = new Properties();
		properties.load(fileInputStream);
		return properties;
		//Added to check jenkins operation
	}
	@BeforeSuite
	public void launchBrowser() throws IOException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Execution of webdriveruniversity application");
		logger.info("Property File loaded");
		loadPropertyFile();
		String url= properties.getProperty("url");
		String browser=properties.getProperty("browser");
		String driverLocation=properties.getProperty("DriverLocation");
		
		if(browser.equalsIgnoreCase("Chrome")){
			logger.info("Chrome Browser Launched");
			System.setProperty("webdriver.chrome.driver", driverLocation);
		    driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			logger.info("Firefox Browser Launched ");
			System.setProperty("webdriver.gecko.driver", driverLocation);
		    driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		logger.info("Navigating to the URL");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
