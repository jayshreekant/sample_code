/**
 * 
 */
package generics;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * @author Jayshreekant_S
 *
 */
public class TestFile {


	public static void main(String[] args) {
		System.out.println("Hello World");
		
        int bs = 45;
		try
		{
			bs = bs/0;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("sdjkhfkjashfdksj");
		}
		System.out.println("Hello World");
		
	}
	public void sample (WebElement ele)
	{
		try 
		{
			ele.click();
		} 
		catch (TimeoutException e)
		{
			System.out.println(e.getMessage());
		}
		catch (StaleElementReferenceException e)
		{
			System.out.println(e.getMessage());
		}
		catch (NotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (WebDriverException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void browser (WebElement ele)
	{
		try 
		{
			ele.click();
		}
		catch (TimeoutException e)
		{
			e.getMessage();
		}
		catch (StaleElementReferenceException e)
		{
			e.getMessage();
		}
		catch (NotFoundException e) 
		{
			e.getMessage();
		}
		catch (WebDriverException e) 
		{
			e.getMessage();
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
		
	}


}
