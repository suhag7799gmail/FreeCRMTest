package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	  
	// page-factory - OR;
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy (xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy (xpath = "//a[contains(text(),'Sign Up')]")
	
	WebElement signUpButton;
	
	@FindBy (xpath = "//img[@class='img-responsive']")
	public WebElement crmLogo;
	
	
	//intialize page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public boolean validateSignup() {
		return signUpButton.isDisplayed();
	}

	public HomePage login (String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		
		return new HomePage();
		
	}
	
	
	
	
	
}
