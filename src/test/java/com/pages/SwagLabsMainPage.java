package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabsMainPage {
	private WebDriver driver;

	public SwagLabsMainPage(WebDriver driver) {
	    this.driver = driver;
	}

	public boolean isAppLogoDisplayed() {
	    Boolean logo = driver.findElement(By.className("app_logo")).isDisplayed();
		return logo;
	}

}


