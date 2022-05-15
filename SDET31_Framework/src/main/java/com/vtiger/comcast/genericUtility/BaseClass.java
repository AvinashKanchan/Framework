package com.vtiger.comcast.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver = null;
	public static WebDriver listenerDriver=null;
	
	/*object creation of utilities*/
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wdLib=new WebDriverUtility();
	
	@BeforeSuite(groups = {"smokeTest","sanityTest","regressionTest","intergationTest"})
	public void bs()
	{
		System.out.println("Connection to the database has done");
	}
	
	@BeforeTest(groups = {"smokeTest","sanityTest","regressionTest","intergationTest"})
	public void bt()
	{
		System.out.println("Execute script in parallel mode");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","sanityTest","regressionTest","intergationTest"})
	public void launchBrowser() throws Exception
	{	
		/*@Optional("chrome") this we will pass in method argument when using parameter
		/*fetching the data from properties file*/
		//String browserName=System.getProperty("browser");
		String browserName=fLib.getPropertyKeyValue("browser");
		String url=fLib.getPropertyKeyValue("url");		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("msedge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		} 
		else {
			throw new Exception("Browser not compatible");
		}
		wdLib.waitForElement(driver);
		listenerDriver=driver;
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@BeforeMethod(groups = {"smokeTest","sanityTest","regressionTest","intergationTest"})
	public void login() throws IOException
	{
		/*fetching the data from properties file*/
		String username=fLib.getPropertyKeyValue("username");
		String password=fLib.getPropertyKeyValue("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
	}
	
	@AfterMethod(groups = {"smokeTest","sanityTest","regressionTest","intergationTest"})
	public void logout()
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnLogout(driver);
	}
	
	@AfterClass(groups = {"smokeTest","sanityTest","regressionTest","intergationTest"})
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterTest(groups = {"smokeTest","sanityTest","regressionTest","intergationTest"})
	public void at()
	{
		System.out.println("Parallel execution closed");
	}
	
	@AfterSuite(groups = {"smokeTest","sanityTest","regressionTest","intergationTest"})
	public void as()
	{
		System.out.println("Database connection closed");
	}

}
