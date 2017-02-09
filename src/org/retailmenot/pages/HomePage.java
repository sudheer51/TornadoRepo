package org.retailmenot.pages;

import org.retailmenot.tests.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	public void browseCoupons(String coupounType)
	{		
										System         .out .println("selenium");
		driver.findElement(By.linkText(RetailMeNotTests.prop.getProperty("retailmenot.homepage.couponslink"))).click();
		driver.findElement(By.linkText(coupounType)).click();
	}

}
