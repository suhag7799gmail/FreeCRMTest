package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactpage;
	
	String sheetName = "Contacts";
	
		
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
			initialization();
			testutil = new TestUtil();
			loginpage = new LoginPage();
			contactpage = new ContactsPage();
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			testutil.switchtoFrame();
			
			
	}
	
	@Test (priority=2)
	public void verifycontactcheckbox() throws InterruptedException {
		contactpage = homepage.clickonContactslinks();	
		Assert.assertTrue(contactpage.selectContactscheckbox());
				Thread.sleep(5000);
		/*System.out.println(driver.getTitle());
		Assert.assertTrue(contactpage.contactcheckbox.isDisplayed(),"Checkbox is displayed");
		ContactsPage.contactcheckbox.click();
		Thread.sleep(5000);
			*/	
				contactpage.contactcheckbox.click();
				
	}
	
	@Test (priority=1)
	public void verifyContactPageLabel() {
		contactpage = homepage.clickonContactslinks();
		Assert.assertTrue(contactpage.verifyContactsLabel(), "Contact label is missing on the page");
	}
	
	@DataProvider
	public Object [][] getCRMTestData() {
		Object data [][]=  TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test (priority = 3, dataProvider="getCRMTestData")
	
	public void validateCreateNewContact(String title, String firstname, String	lastname, String company)   {
		homepage.clickOnNewContactlink();
		//contactpage.fillNewContactPage("Mr.", "Nikki", "Tamboli", "boss");
		contactpage.fillNewContactPage(title, firstname, lastname, company);
		System.out.println("Records added successfully");
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
