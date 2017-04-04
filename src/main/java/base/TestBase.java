package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import pages.MenuBar;
import pages.SigninPage;

@Listeners(listener.EliteListener.class)
public class TestBase extends SauceLabs {

	public static MenuBar menuBar;
	public static SigninPage signinPage;

	@BeforeSuite
	public void setUp() {
		if (Boolean.valueOf(getProperty("saucelabs"))) {
			setSauceLabs();
		} else {
			setDriver();
		}
		driver.get(getProperty("appUrl"));
		
		menuBar = PageFactory.initElements(driver, MenuBar.class);
		signinPage = PageFactory.initElements(driver, SigninPage.class);

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
