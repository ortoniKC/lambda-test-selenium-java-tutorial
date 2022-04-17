package popup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HandleAuthenticationPopup {
	
	RemoteWebDriver driver= null;
	
	@Parameters({"browsername", "testName"})
	@BeforeMethod
	public void setUp(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Handle Auth");
		capabilities.setCapability("name", testName);
		capabilities.setCapability("platform", "Windows 11");
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version","98.0");
		try {
			driver = new RemoteWebDriver(new URL("https://userName:accessKey@hub.lambdatest.com/wd/hub"),
					capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@Test
	public void handleAuth() {
		String username = "admin";
		String password = "admin";
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");

		//		driver.switchTo().alert().sendKeys("admin");
		
		String text = driver.findElement(By.cssSelector("div#content>div>p")).getText();
		System.out.println(text);
		String expected = "Congratulations! You must have the proper credentials.";
		Assert.assertEquals(text.trim(), expected);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

}
