package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import runner.Test_Runner;

public class Browser_Helper {

	private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	public static void initializeDriver(String browser)
	{
		threadLocalDriver.set(getDriver(browser));
	}
	
	public static WebDriver getDriver() 
	{
		return threadLocalDriver.get();
	}
	
	public static WebDriver getDriver(String browser)
	{
		switch(browser.toLowerCase())
		{
			case "chrome":
				return getChromeDriver();
			default:
				return getEdgeDriver();				
		}
	}
	
	public static WebDriver getChromeDriver()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--no-sandbox");
		options.addArguments("--guest");
		options.addArguments("--disable-blink-features=AutomationControlled");
		
		if(Test_Runner.isHeadless == true)
		{
			options.addArguments("--headless");
		}
		
		return new ChromeDriver(options);
	}
	
	public static WebDriver getEdgeDriver()
	{
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--no-sandbox");		
		options.addArguments("--guest");
		options.addArguments("--disable-blink-features=AutomationControlled");
		
		if(Test_Runner.isHeadless == true)
		{
			options.addArguments("--headless");
		}
		
		return new EdgeDriver(options);
	}
	
	public static void quitDriver()
	{
		WebDriver driver = Browser_Helper.getDriver();
		if(driver != null)
		 {
			driver.quit();
			threadLocalDriver.remove();
		 }
	}
}