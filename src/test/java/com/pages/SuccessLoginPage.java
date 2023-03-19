package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessLoginPage {
	private WebDriver driver = null;
	
	
	public SuccessLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void login(String username, String password) {
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys(username);
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(password);
	}
	public void clickLoginButtn() {
		
			WebElement loginButton = driver.findElement(By.id("login-button"));
			loginButton.click();
			
			
		
	}
	public boolean isAppLogoDisplayed() {
		WebElement appLogo = driver.findElement(By.className("app_logo"));
		return appLogo.isDisplayed();
	}
	public String getErrorMessageText() {
		WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
		return errorMessage.getText();
	}

}
