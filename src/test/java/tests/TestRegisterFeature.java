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
	@Test
	public void testLastNameWithTwoCharacter() {
		registerPage.processTextField(registerPage.lastNameField, "ab");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "*");
	}

	@Test
	public void testLastNameWithOneCharacter() {
		registerPage.processTextField(registerPage.lastNameField, "a");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "* LastName can not be less than 2 character.");
	}

	@Test
	public void testLastNameWithThirtyCharacter() {
		registerPage.processTextField(registerPage.lastNameField, "MynameisDewanNadiaSultanaShumi");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "*");

	}

	@Test
	public void testLastNameWithThirtyOneCharacter() {
		registerPage.processTextField(registerPage.lastNameField, "My name is Dewan Nadia Sultanaa");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(),
				"* LastName can not be greater than 30 character.");

	}

	@Test
	public void testLastNameWithEmptyField() {
		registerPage.processTextField(registerPage.lastNameField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "* LastName can not be empty.");

	}

	@Test
	public void testLastNameWithNumericData() {
		registerPage.processTextField(registerPage.lastNameField, "3452657893456712345678987653");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "LastName must be String");
	}
	
	@AfterClass
	public void classTearDown(){
		menuBar.jobSearchPageLink.click();
	}

}
