package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.pages.SuccessLoginPage;
import com.pages.SwagLabsMainPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLogin {
	private WebDriver driver;
	private SuccessLoginPage loginPage;
	private SwagLabsMainPage mainpage;
	
	public String url="https://www.saucedemo.com/";
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/DriverPackage/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	}
	
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String testName=scenario.getName();
			//take a screenshot
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//embeded screenshot into cucumber report
			scenario.attach(screenshot, "image/png", testName);
		}
		if(driver !=null) {
			driver.quit();
		}
		
		
	
	
	}
	
	
	@Given("I am on the Sauce Demo Login Page")
	public void i_am_on_the_sauce_demo_login_page() {
		System.out.println("Opening chrome browser");
		driver.get(url);
		loginPage = new SuccessLoginPage(driver);
	}

	@When("I fill the account information for account StandardUser into the Username field and the Password field")
	public void i_fill_the_account_information_for_account_standard_user_into_the_username_field_and_the_password_field() {

		// Write code here that turns the phrase above into concrete actions
		WebElement userName = driver.findElement(By.id("user-name"));
		userName.sendKeys("standard_user");
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("secret_sauce");

	}

	@When("I click the Login Button")
	public void i_click_the_login_button() {
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

	}

	@Then("I am redirected to the Sauce Demo Main Page")
	public void i_am_redirected_to_the_sauce_demo_main_page() {
		System.out.println("Redirected to sauce Demo main Page");
		assert driver.getCurrentUrl().contains("/inventory.html");
	}

	@Then("I verify the App Logo exists")
	public void i_verify_the_app_logo_exists() {
		// Write code here that turns the phrase above into concrete actions
		assert loginPage.isAppLogoDisplayed();
	}

	@When("I fill the account information for account LockedOutUser into the Username field and the Password field")
	public void i_fill_the_account_information_for_account_locked_out_user_into_the_username_field_and_the_password_field() {
		loginPage.login("locked_out_user", "secret_sauce");
	}

	@Then("I verify the Error Message contains the text {string}")
	public void i_verify_the_error_message_contains_the_text(String string) {
		assert loginPage.getErrorMessageText().contains("Sorry, this user has been banned.");
	}

	@Then("I close chrome browser")
	public void i_close_chrome_browser() {
		driver.close();
		driver.quit();

	}

	
}
