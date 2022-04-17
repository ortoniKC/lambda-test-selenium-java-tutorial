package aui;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdvanceUserInteractions {
	RemoteWebDriver driver= null;

	@BeforeMethod
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "AUI");
		capabilities.setCapability("name", "Actions");
		capabilities.setCapability("platform", "Windows 11");
		capabilities.setCapability("browserName", "Chrome");
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
	
	// move to element
	@Test(enabled = false)
	public void move() {
		driver.get("https://www.lambdatest.com/");
		WebElement devs = driver.findElement(By.xpath("//button[text()='Developers ']"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(devs).perform();
		driver.findElement(By.xpath("(//h3[text()='API'])[2]")).click();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.lambdatest.com/support/api-doc/");
	}
	
	// Drag and drop
	@Test(enabled = false)
	public void dragDrop() {
		driver.get("https://letcode.in/dropable");
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(sourceEle, targetEle).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// drag and drop by
	@Test
	public void dragDropByLocation() {
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		Actions builder = new Actions(driver);
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		Point location = sourceEle.getLocation();
		int x = location.getX();
		int y = location.getY();
		builder.dragAndDropBy(sourceEle, x+30, y+20).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// other methods
}
