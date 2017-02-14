package org.retailmenot.pages;

import org.retailmenot.tests.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	Logger logger = Logger.getLogger("HomePage.class");
	 
	

	WebDriver driver;
	public void browseCoupons(String coupounType)
	{	
		 
		logger.info("");
									 
		driver.findElement(By.linkText(RetailMeNotTests.prop.getProperty("retailmenot.homepage.couponslink"))).click();
		driver.findElement(By.linkText(coupounType)).click();
	}

}
