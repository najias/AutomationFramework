package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegisterFeature extends TestBase{
	
	@BeforeClass
	public void classSetUp(){
		menuBar.RegisterLink.click();
	}
	@Test
	public void testFirstNameWithTwoChar(){
		registerPage.processTextField(registerPage.firstNameField, "na");
		
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "*");
	}
	
	
	@Test
	public void testFirstNameWithOneChar(){
		registerPage.processTextField(registerPage.firstNameField, "a");
		

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "* FirstName can not be less than 2 character.");
	}
	@Test
	public void testFirstNameWithThirtyChar() {
		registerPage.processTextField(registerPage.firstNameField, "My name is Dewan Nadia Sultana");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "*");

	}

	@Test
	public void testFirstNameWithThirtyOneChar() {
		registerPage.processTextField(registerPage.firstNameField, "My name is Dewan Nadia Sultana S");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(),
				"* FirstName can not be greater than 30 character.");

	}

	@Test
	public void testFirstNameWithEmptyField() {
		registerPage.processTextField(registerPage.firstNameField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "* FirstName can not be empty.");
	}

	@Test
	public void testFirstNameWithNumericData() {
		registerPage.processTextField(registerPage.firstNameField, "345265789345678123456789876543");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "FirstName must be String");
	}
	
	@AfterClass
	public void classTearDown(){
		menuBar.jobSearchPageLink.click();
	}

}
