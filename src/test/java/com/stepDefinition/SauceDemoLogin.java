package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLogin {
	private WebDriver driver;
	
	public String url="https://www.saucedemo.com/";
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "");
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
		
		@Given("I am on the Sauce Demo Login Page")
		public void i_am_on_the_sauce_demo_login_page() {
		    System.out.println("hi");
		}

		@When("I fill the account information for account DtandardUser into the Username field and the Password filed")
		public void i_fill_the_account_information_for_account_dtandard_user_into_the_username_field_and_the_password_filed() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@When("I click the Login Button")
		public void i_click_the_login_button() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("I am redirected to the sauce Demo Main Page")
		public void i_am_redirected_to_the_sauce_demo_main_page() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("I vverify the App Logo Exists")
		public void i_vverify_the_app_logo_exists() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Given("I am on the sauce Demo Login Page")
		public void i_am_on_the_sauce_demo_login_page() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@When("I filled account infromation for account LockedOutUser into the Username field and the password field")
		public void i_filled_account_infromation_for_account_locked_out_user_into_the_username_field_and_the_password_field() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@When("I clicked the login button")
		public void i_clicked_the_login_button() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("I verify the error Message contains the text {string}")
		public void i_verify_the_error_message_contains_the_text(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("I close chrome browser")
		public void i_close_chrome_browser() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

	}

	private void i_am_on_the_sauce_demo_login_page() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
