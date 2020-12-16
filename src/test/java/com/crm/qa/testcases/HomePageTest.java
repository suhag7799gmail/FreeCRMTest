package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactpage;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
			initialization();
			testutil = new TestUtil();
			loginpage = new LoginPage();
			contactpage = new ContactsPage();
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homepagetitle);
		//driver.switchTo().frame("mainpanel");
	//	driver.switchTo().frame(1);
		//Assert.assertTrue(HomePage.usernameLabel.isDisplayed());
		
		//driver.switchTo().frame(0);
		//Assert.assertTrue(HomePage.contactlinks.isDisplayed());
			
	}
	
	@Test(priority=2)
	public void verifyUsernameTest()
	{
		testutil.switchtoFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test (priority=3)
	public void verifyContactslinksTest() {
		testutil.switchtoFrame();
		contactpage = homepage.clickonContactslinks();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}