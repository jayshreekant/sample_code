package generics;

import java.io.File;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class Sel_utility
{

	/**** Generic Method to handle listbox ****/
	static public void wait(int time)
	{
		try
		{
			Thread.sleep(time);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/** Generic method to wait for the Element to be clickable **/

	static public void waitForElementTobeClickable(WebDriver driver, int waitTime, WebElement we)
	{
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(we));
	}

	/** Generic method to check if element present **/

	/******** using the Java Script method to click *******/
	public void safeJavaScriptClick(WebElement element) throws Exception
	{
		try
		{
			if (element.isEnabled() && element.isDisplayed())
			{
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) new FirefoxDriver()).executeScript("arguments[0].click();", element);
			}
			else
			{
				System.out.println("Unable to click on element");
			}
		}
		catch (StaleElementReferenceException e)
		{
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		}
		catch (Exception e)
		{
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}

	/*** Generic method to move to element ***/
	public static void movetoElement(WebElement we)
	{
		Actions act = new Actions(new FirefoxDriver());
		act.moveToElement(we).perform();

	}

	/**** Generic Method to handle listbox ***/
	public static void selectByIndexDropDown(WebElement listBox, int index)
	{
		new Select(listBox).selectByIndex(index);
	}

	public static void selectByValueDropDown(WebElement listBox, String value)
	{
		new Select(listBox).selectByValue(value);
	}

	/**** generic to hilight the element ***/
	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
	}

	/******** Generic Method to check whether element is present or not ********/
	public static boolean isPresentAndDisplayed(final WebElement element)
	{
		try
		{
			return element.isDisplayed();
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
	
	/*************************Generic Method to take screenshot*********************************/
	
	public static void captureScreenshot(WebDriver driver,String screenshotName)
	{
	 
	try 
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	}
	
	

}
