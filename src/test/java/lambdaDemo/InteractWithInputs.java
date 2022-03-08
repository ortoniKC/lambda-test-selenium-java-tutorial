package lambdaDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InteractWithInputs {
	RemoteWebDriver driver ;
	@BeforeTest()
	@Parameters("browser")
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "First run");
		capabilities.setCapability("name", "Interact with input");
		capabilities.setCapability("platform", "MacOS Monterey");
		capabilities.setCapability("browserName", "Safari");
		capabilities.setCapability("version","15.0");
		capabilities.setCapability("console","true");
		capabilities.setCapability("network",true);
		capabilities.setCapability("visual",true);
		try {
			driver = new RemoteWebDriver(new URL("https://koushik350:GhnFCYUK4IWo9j4f38tr2RoS3rwmJxaR0AozKsHvRjigNBDzlJ@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void myTest() {
		/*
		 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 * WebDriver driver = new ChromeDriver();
		 */
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		String title = driver.getTitle();
		System.out.println(title);
		WebElement aInput = driver.findElement(By.id("sum1"));
		String attribute = aInput.getAttribute("placeholder");
		System.out.println("Placeholder value: "+attribute);
		aInput.sendKeys("10");
		driver.findElement(By.id("sum2")).sendKeys("15");
		driver.findElement(By.xpath("//button[text()='Get values']")).click();
		String text = driver.findElement(By.id("addmessage")).getText();
		System.out.println("Result: "+text);
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
