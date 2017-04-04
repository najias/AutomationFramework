package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class RegisterPage extends PageBase {

	@FindBy(name = "FirstName")
	public WebElement firstNameField;

	@FindBy(name = "LastName")
	public WebElement lastNameField;

	@FindBy(name = "Gender")
	public WebElement genderDropdownList;

	@FindBy(name = "DateOfBirth")
	public WebElement dateOfBirthField;

	@FindBy(name = "PhoneNo")
	public WebElement phoneNoField;

	@FindBy(name = "UserType")
	public WebElement userTypeDropdownList;

	@FindBy(name = "Email")
	public WebElement emailField;

	@FindBy(name = "Password")
	public WebElement passwordField;

	@FindBy(name = "ConfirmPassword")
	public WebElement confirmPasswordField;

	@FindBy(name = "Captcha")
	public WebElement captchaImageField;

	@FindBy(name = "Privacy")
	public WebElement privacyCheckBox;

	@FindBy(name = "Subscribe")
	public WebElement subscribeCheckBox;

	@FindBy(name = "submit")
	public WebElement submitButton;

	@FindBy(id = "error")
	public List<WebElement> errorMessage;
	
	public void processTextField(WebElement  element , String  text){
		element.clear();
		element.sendKeys(text);
		submitButton.click();
	}

}
