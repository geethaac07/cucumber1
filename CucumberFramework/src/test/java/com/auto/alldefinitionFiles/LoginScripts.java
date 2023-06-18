package com.auto.alldefinitionFiles;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScripts {

	WebDriver driver;
	WebDriverWait waitObj;
	
	@Given("user opens salesforce application")
	public void application_is_up_and_running() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
	}
	
	@When("I enter valid username only")
	public void i_enter_valid_username_only() {
		WebElement uName = driver.findElement(By.id("username"));
		if (uName.isEnabled()) {
			uName.clear();
			uName.sendKeys("geenalls@icloud.com");
			System.out.println("User Name is entered");
		} else
			System.out.println("User Name is NOT displayed");

	}

	@When("click on Login button")
	public void click_on_login_button() {
		WebElement btn_Login = driver.findElement(By.name("Login"));
		if (btn_Login.isDisplayed()) {
			btn_Login.click();
			System.out.println("Login button is clicked");
		} else
			System.out.println("Login button is NOT displayed");
	}

	@Then("verify error message \"Please enter your password.\"")
	public void i_should_see_error_message() {
		WebElement login_Error = driver.findElement(By.id("error"));
		String expected_ErrorMessage = "Please enter your password.";

		String actual_ErrorMessage = login_Error.getText();
		Assert.assertEquals(actual_ErrorMessage, expected_ErrorMessage);
		System.out.println("Error Message is displayed - TC passed");
		driver.close();
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {

		WebElement uName = driver.findElement(By.id("username"));
		if (uName.isEnabled()) {
			uName.clear();
			uName.sendKeys("geenalls@icloud.com");
			System.out.println("User Name is entered");
		} else
			System.out.println("User Name is NOT displayed");

		WebElement password = driver.findElement(By.id("password"));
		if (password.isEnabled()) {
			password.clear();
			password.sendKeys("123admin$");
			System.out.println("password is entered");
		} else
			System.out.println("Password field is NOT displayed");
	}

	@Then("verify Getting started heading")
	public void verify_getting_started_heading() {
		String expTitle = driver.getTitle();
		String actTitle = "Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals(actTitle, expTitle);
		driver.close();
	}

	@When("click remember me checkbox")
	public void click_remember_me_checkbox() {
		WebElement RememberMe_Checkbox = driver.findElement(By.xpath("//*[@id='rememberUn']"));
		if (RememberMe_Checkbox.isDisplayed())
			RememberMe_Checkbox.click();
		else
			System.out.println("Checkbox is not displayed");

	}

	@When("click logout")
	public void click_logout() {
		waitObj = new WebDriverWait(driver, 30);
		
		WebElement uMenu = driver.findElement(By.id("userNav-arrow")); // userNav"));
		waitObj.until(ExpectedConditions.visibilityOf(uMenu));
		if (uMenu.isDisplayed())
			uMenu.click();

		// userNavMenu
		WebElement sLogout = driver.findElement(By.linkText("Logout"));
		sLogout.click();
	}

	@Then("user should be logged out")
	public void user_should_be_logged_out() {
		String logoutPageTitle = "Login | Salesforce";
		String expTitle = driver.getTitle();
		System.out.println("Title" +expTitle);
		Assert.assertEquals(logoutPageTitle, expTitle);
	}

	@Then("username is entered in the text field")
	public void username_is_entered_in_the_text_field() {
		WebElement uNameValue = driver
				.findElement(By.xpath("//div[@id='idcard-container']//following::input[@id='username']"));

		String userValue = uNameValue.getAttribute("value");
		// System.out.println(userValue);
		String uName = "geenalls@icloud.com";
		if (uNameValue.equals(uName)) {
			System.out.println("User Name is entered in the text box - application remembered the username");
		} else
			System.out.println("Applicaion doesnt remember the username");
	}

}
