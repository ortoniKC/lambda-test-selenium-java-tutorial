package screenshots;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScreenShots {
RemoteWebDriver driver= null;
	
	@Parameters({"browsername", "testName"})
	@BeforeMethod
	public void setUp(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Screenshot");
		capabilities.setCapability("name", testName);
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version","98.0");
		try {
			driver = new RemoteWebDriver(new URL("https://koushik350:GhnFCYUK4IWo9j4f38tr2RoS3rwmJxaR0AozKsHvRjigNBDzlJ@hub.lambdatest.com/wd/hub"),
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
	public void screenshots() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotAs, new File("./snaps/img1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ele = driver.findElement(By.id("showInput"));
		File src = ele.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./snaps/ele.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
