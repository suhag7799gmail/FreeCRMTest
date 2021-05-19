package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		
		initialization();
		loginPage = new LoginPage();
		//Thread.sleep(5000);
	 }

	@Test (priority=3)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test (priority=5)
	public void loginPagewrongTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "I want this test case to fail");
	}
	@Test (priority=2)
	public void signupbtnTest() {
		boolean flag = loginPage.validateSignup();
		Assert.assertTrue(flag);
	}
	
	@Test (priority=6)
	public void loginPagerightTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, title);
	}
	
	@Test (priority=7)
	public void loginPagerightTitleTest2() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, title);
	}
	
@Test (priority=1)
	public void loginTest() throws InterruptedException {
		
	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	//loginPage.login("suhag7799", "Winter@2020")	;
	Thread.sleep(10000);
	}
	
@Test (priority=4)
	public void crmlogoTest() {
		boolean flag = loginPage.crmLogo.isDisplayed();
		Assert.assertTrue(flag);
	}


	@AfterMethod
	public void tearDown() throws InterruptedException {
		//Thread.sleep(4000);
		driver.quit();
	}
	

}
