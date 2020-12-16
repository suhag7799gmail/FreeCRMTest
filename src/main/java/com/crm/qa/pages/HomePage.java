package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy (xpath="//td[contains(text(),'User: Sam Pat')]")
	public static WebElement usernameLabel;
	
	@FindBy (xpath= "//a[contains(text(),'Contacts')]")
	public  WebElement contactlinks;
	
	@FindBy (xpath = "//a[contains(text(),'New Contact')]")
	public WebElement newContactlinks;
	
	@FindBy (xpath = "//a[Contains(text(),'Deals')]")
	WebElement dealslinks;
	
	@FindBy (xpath = "//a[Contains(text(),'Tasks')]")
	WebElement taskslinks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName()
	{
		return usernameLabel.isDisplayed();
		
	}
	
	
	public ContactsPage clickonContactslinks()
	{
		contactlinks.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickonDealslinks()
	{
		dealslinks.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickonTaskslinks()
	{
		taskslinks.click();
		return new TasksPage();
		
	}
	
	public void clickOnNewContactlink()   {
		
		Actions action = new Actions(driver);
		action.moveToElement(contactlinks).build().perform();
		System.out.println("move over finished");
		//Thread.sleep(2000);
		newContactlinks.click();
		
	}
	
	
}

	