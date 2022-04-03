package windowAndFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingFrames extends ConfigFile {
	
	@Test
	public void frames() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		// frame
//		driver.switchTo().frame("firstFr");
//		driver.switchTo().frame(1);
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@src='frameUI']"));
		driver.switchTo().frame(frameEle);
		driver.findElement(By.name("fname")).sendKeys("Koushik");
		driver.findElement(By.name("lname")).sendKeys("Chatterjee");
		// nested frame
		WebElement innerFrames = driver.findElement(By.cssSelector("iframe.has-background-white"));
		driver.switchTo().frame(innerFrames);
		driver.findElement(By.name("email")).sendKeys("some@some.com");
		
		// parent frame
		driver.switchTo().parentFrame();
		driver.findElement(By.name("fname")).sendKeys("Letcode");
		
		// default content
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Log in")).click();
//		driver.quit();
	}

}
