package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.MenuBar;

public class TestSigninFeature extends TestBase{
	
	@BeforeClass
	public void classSetUp(){
	menuBar.signInLink.click();
	}
	
	@Test
	public void testValidEmailAndValidPassword(){
		signinPage.signin(getProperty("employerEmail"), getProperty("employerPassword"));
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/profile"));
		
		menuBar.logoutLink.click();
		menuBar.signInLink.click();
	}
	@Test
	public void testWithValidEmailAndInvalidPassword(){
		signinPage.signin(getProperty("employerEmail"), "invalidPassword");
		
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage. errorMessage.get(0).getText(), "* Email or Password is incorrect.");
	
	}
	@Test
	public void testWithInValidEmailAndInvalidPassword(){
		signinPage.signin("Invalid@email.com", "invalidPassword");
		
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage. errorMessage.get(0).getText(), "* Email or Password is incorrect.");
	
	}
	@Test
	public void testWithEmptyEmailAndValidPassword(){
		signinPage.signin("",getProperty("employerPassword"));
		
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage. errorMessage.get(0).getText(), "* Email can not be empty.");
		
	}
	@Test
	public void testWithValidEmailAndEmptyPassword(){
		signinPage.signin(getProperty("employerEmail"),"");
		
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage. errorMessage.get(0).getText(), "* Email or Password is incorrect.");
		Assert.assertEquals(signinPage. errorMessage.get(1).getText(), "* Password can not be empty.");
	}
	
	@Test
	public void testWithEmptyEmailAndEmptyPassword(){
		signinPage.signin( "" , "" ) ;
		
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage. errorMessage.get(0).getText(), "* Email can not be empty.");
		Assert.assertEquals(signinPage. errorMessage.get(1).getText(), "* Password can not be empty.");
	}
	
	@AfterClass
	public void classTearDown(){
		menuBar.jobSearchPageLink.click();
	}

}
