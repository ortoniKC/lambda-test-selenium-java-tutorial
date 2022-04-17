package lambdaDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;	

public class HandleDropDown {
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
			driver = new RemoteWebDriver(new URL("https://userName:accessKey@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectDropdown() {
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		WebElement dayDropdown = driver.findElement(By.id("select-demo"));
		Select sel = new Select(dayDropdown);
		sel.selectByVisibleText("Friday");
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		System.out.println("Select dropdown value: " +firstSelectedOption.getText());
		//		sel.selectByIndex(0);
		//		sel.selectByValue("Sunday");

		// multiple dropdown

		WebElement multiDropdown = driver.findElement(By.id("multi-select"));
		Select countries = new Select(multiDropdown);
		countries.selectByIndex(2);
		countries.selectByValue("Texas");
		List<WebElement> allSelectedOptions = countries.getAllSelectedOptions();
		for (WebElement country : allSelectedOptions) {
			System.out.println("selected opt: "+country.getText());	
		}

	}	


	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
