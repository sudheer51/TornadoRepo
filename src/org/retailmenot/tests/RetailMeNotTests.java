package org.retailmenot.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.retailmenot.pages.HomePage;
import org.retailmenot.pages.ProductDealsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RetailMeNotTests {
	
	WebDriver driver;
	static Logger logger ;
	public static Properties prop;
	@Parameters({"browserType"})
	@BeforeClass
	public void setUp(String browserType) throws IOException
	{
		logger = Logger.getLogger("RetailMeNotTests.class");
		PropertyConfigurator.configure("log4j.properties");
		
		FileInputStream fis = new FileInputStream(new File("RM.properties"));
		prop = new Properties();
		prop.load(fis);

		if(browserType.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver","ChromeDriver.exe");
			driver = new ChromeDriver();
		}		
		driver.get("http://retailmenot.com");
	}
	@Test
	public void validateProductDealsCount()
	{
		
		HomePage hPage =new HomePage();
		hPage.browseCoupons("Electronics");
		ProductDealsPage dealsPage = new ProductDealsPage();
		dealsPage.jumpToDealType("Electronics");
		int actual = dealsPage.getDealsCount("Electronics");
		int expected = 40;
		Assert.assertEquals(actual, expected);
				
	}

}
