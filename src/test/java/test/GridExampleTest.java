/**
 * 
 */
package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExampleTest
{

	WebDriver driver;

	@Test
	public void test() throws MalformedURLException
	{
		WebDriver driver = new RemoteWebDriver(new URL("http://160.110.193.235:4444/wd/hub"), DesiredCapabilities.chrome());
		driver.get("http://www.google.com");
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium Grid Tutorial");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.quit();
	}
}
