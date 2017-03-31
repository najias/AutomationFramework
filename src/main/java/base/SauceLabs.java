package base;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs extends Driver {
	DesiredCapabilities caps;

	public void setSauceLabs() {
		String URL = "https://" + getSauceLabsProperty("userName") + ":" + getSauceLabsProperty("accessKey")
				+ "@ondemand.saucelabs.com:443/wd/hub";
		setCapabilities();

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}

	public void setCapabilities() {
		if (getSauceLabsProperty("browser").equalsIgnoreCase("Chrome")) {
			caps = DesiredCapabilities.chrome();
		} else if (getSauceLabsProperty("browser").equalsIgnoreCase("Firefox")) {
			caps = DesiredCapabilities.firefox();

		} else if (getSauceLabsProperty("browser").equalsIgnoreCase("Safari")) {
			caps = DesiredCapabilities.safari();

		} else if (getSauceLabsProperty("browser").equalsIgnoreCase("IE")) {
			caps = DesiredCapabilities.internetExplorer();

			caps.setCapability("platform", getSauceLabsProperty("operatingSystem"));
			caps.setCapability("version", getSauceLabsProperty("browserVersion"));

		}

	}
}
