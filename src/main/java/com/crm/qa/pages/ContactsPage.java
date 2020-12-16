package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy (xpath ="//input[@name='contact_id']")
	public  WebElement contactcheckbox;
	
	@FindBy (xpath = "//td[contains(text(),'Contacts')]")
	 WebElement contactLabel;
	@FindBy (id="first_name")
	WebElement firstName;
	
	@FindBy (id="surname")
	WebElement lastName;
	
	@FindBy (name="client_lookup")
	WebElement company;
	
	@FindBy (xpath ="//input[@type='submit' and @value='Save']")
	public  WebElement savebtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactLabel.isDisplayed();
	}
	
	public boolean selectContactscheckbox() {
		
		 boolean flag = contactcheckbox.isDisplayed();
		 return flag;
	}
	
	public void fillNewContactPage(String title, String fname, String lname, String comp ) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		System.out.println("NAme entered");
		savebtn.click();
	}
	

}
