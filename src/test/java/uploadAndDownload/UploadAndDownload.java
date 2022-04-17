package uploadAndDownload;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UploadAndDownload {
	
	
RemoteWebDriver driver= null;
	
	@Parameters({"browsername", "testName"})
//	@BeforeMethod
	public void setUp(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Upload");
		capabilities.setCapability("name", testName);
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version","98.0");
		try {
			driver = new RemoteWebDriver(new URL("https://userName:accessKey@hub.lambdatest.com/wd/hub"),
					capabilities);
			driver.setFileDetector(new LocalFileDetector());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@Test
	public void main() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions option = new  ChromeOptions();
		HashMap<String, Object> prefs = new  HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		option.setExperimentalOption("prefs", prefs);
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		upload();
		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=101.0.4951.15/");
		driver.findElement(By.linkText("chromedriver_win32.zip")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void upload() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		WebElement uploadEle = driver.findElement(By.xpath("//input[@type='file']"));
		File file = new File("./logo.png");
		System.out.println(file.getAbsolutePath());
		uploadEle.sendKeys(file.getAbsolutePath());
		driver.findElement(By.xpath("//span[.='Start upload']")).click();
		boolean displayed = driver.findElement(By.cssSelector("button[data-type='DELETE']")).isDisplayed();
		assertTrue(displayed);
	}

	

}
