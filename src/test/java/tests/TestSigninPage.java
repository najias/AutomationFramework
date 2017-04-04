package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.MenuBar;

public class TestSigninPage extends TestBase{
	
	@BeforeClass
	public void classSetUp(){
	menuBar.signInLink.click();
	}
	
	@Test
	public void testValidEmailAndValidPassword(){
		signinPage.signin(getProperty("employerEmail"), getProperty("employerPassword"));
		Assert.assertTrue(driver.getCurrentUrl().contains("/profile"));
		
		menuBar.logoutLink.click();
		menuBar.signInLink.click();
	}
	
	@AfterClass
	public void classTearDown(){
		menuBar.jobSearchPageLink.click();
	}

}
