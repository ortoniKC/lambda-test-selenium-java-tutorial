package windowAndFrames;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ConfigFile {
	
	public RemoteWebDriver driver ;
	@BeforeTest()	
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Windows & Frames");
		capabilities.setCapability("name", "Interact with windows & frames");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", "MicrosoftEdge");
		capabilities.setCapability("version","97.0");
		capabilities.setCapability("console","true");
		capabilities.setCapability("network",true);
		capabilities.setCapability("visual",true);
		try {
			driver = new RemoteWebDriver(new URL("https://koushik350:GhnFCYUK4IWo9j4f38tr2RoS3rwmJxaR0AozKsHvRjigNBDzlJ@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
