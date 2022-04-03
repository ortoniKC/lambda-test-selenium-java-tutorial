package windowAndFrames;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandling extends ConfigFile{
	
	@Test
	public void windows() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		System.out.println("Parent window: "+driver.getTitle());
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.findElement(By.linkText("Follow On Twitter")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(2));
		driver.close();
		String title = driver.getTitle();
		System.out.println("Child window: "+ title);
		System.out.println(title);
		
		// switch to parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Back to parent: "+driver.getTitle());
		driver.quit();
	}

}






