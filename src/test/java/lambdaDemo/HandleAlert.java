package lambdaDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleAlert {
	
	RemoteWebDriver driver ;
	@BeforeTest()	
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "DropDown");
		capabilities.setCapability("name", "Interact with Select");
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
	@Test
	public void handleAlert() {
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
//		driver.findElement(By.xpath("//div[text()='Java Script Alert Box']/following-sibling::button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
//		alert.accept();
		driver.findElement(By.xpath("(//button[text()='Click Me'])[2]")).click();
		alert.dismiss();
		driver.findElement(By.xpath("(//button[text()='Click Me'])[3]")).click();
		alert.sendKeys("Koushik");
		alert.accept();
		
	}	


	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
