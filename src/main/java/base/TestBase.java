package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase extends SauceLabs{
	
	@BeforeSuite
	public void setUp(){
		if(Boolean.valueOf(getProperty("saucelabs"))){
			setSauceLabs();
		}else{
			setDriver();
			
		}
		driver.get(getProperty("appUrl"));
		
		
		
	}
	
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}

}
