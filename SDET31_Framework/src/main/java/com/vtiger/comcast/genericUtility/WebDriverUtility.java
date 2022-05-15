package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * It is developed by using WebDriver libraries and contains reusable methods
 * @author Akshay
 *
 */
public class WebDriverUtility {

	/**
	 * It is used to launch different browsers Chrome Firefox MSEdge
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		} else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		} else if (browser.equals("msedge"))
		{
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		}
		System.out.println("Browser name not matched Launching Defaut browser");
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	
	/**
	 * It is used to wait for the element to be loaded in GUI 
	 * @param driver
	 */
	public void waitForElement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * It is used to wait for the particular element to be clickable in GUI & check for the 
	 * specific element every 500 milli second  
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}	
	
	/**
	 * It is used to switch the focus of driver to particular Window using window title
	 * @param driver
	 * @param windowTitle
	 */
	public void switchToWindowWithTitle(WebDriver driver, String partialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> itr = allId.iterator();
		while (itr.hasNext())
		{
			String windowId = itr.next();
			driver.switchTo().window(windowId);
			if(driver.getTitle().contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * It is used to switch the focus of driver to particular Window using window url
	 * @param driver
	 * @param currentWindowUrl
	 */
	public void switchToWindowWithUrl(WebDriver driver, String partialCurrentWindowUrl)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> itr = allId.iterator();
		while (itr.hasNext())
		{
			String windowId = itr.next();
			driver.switchTo().window(windowId);
			if(driver.getCurrentUrl().contains(partialCurrentWindowUrl))
			{
				break;
			}
		}
	}
	
	/**
	 * It is used to click on accept in alert popup
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Is is used to click on cancel in alert popup
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * It is used to switch to particular iframe based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * It is used to switch to particular iframe based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * It is used to switch to particular iframe based on webelement
	 * @param driver
	 * @param ele
	 */
	public void switchToFrame(WebDriver driver, WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	/**
	 * It is used to move the cursor to the particular Element
	 * @param driver
	 * @param ele
	 */
	public void moveMouseToElement(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	/**
	 * It is used to select options from list using index
	 * @param ele
	 * @param index
	 */
	public void selectFromList(WebElement ele, int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	/**
	 * It is used to select options from list using value
	 * @param ele
	 * @param value
	 */
	public void selectFromList(WebElement ele, String value)
	{
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	/**
	 * It is used to scroll the web page in x and y direction
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollPageBy(WebDriver driver, int x, int y)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	/**
	 * It is used to take screenshot of the current web page
	 * @param driver
	 * @param screenshotName
	 * @return 
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String dateAndTime = LocalDateTime.now().toString().substring(0, 23).replace(":","-");
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshot/"+screenshotName+dateAndTime+".png");
		FileUtils.copyFile(source, destination);
		return destination.getAbsolutePath();
	}
	
}

















