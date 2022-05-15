package practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class picks todays date and Prints all the flight options present on the page
 * @author Avishek
 *
 */
public class MmtTodaysDate {

	public static void main(String[] args) {
		LocalDateTime dateAndTime=LocalDateTime.now();
		int date=dateAndTime.getDayOfMonth();
		String month=dateAndTime.getMonth().toString();
		int year=dateAndTime.getYear();
		String actualMonth=month.substring(0, 1)+month.substring(1).toLowerCase();
	String monthAndYear=actualMonth+" "+year;
	//String calenderDateXpath="//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.get("https://www.makemytrip.com/");
		Actions action=new Actions(d);
		action.moveByOffset(4,4).click().perform();
		d.findElement(By.className("langCardClose")).click();
		WebElement fromCityListBox = d.findElement(By.id("fromCity"));
		fromCityListBox.click();
		d.findElement(By.xpath("//p[.='Paris, France']")).click();
		d.findElement(By.xpath("//p[.='Bangalore, India']")).click();
		String path="//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		d.findElement(By.xpath(path)).click();
		d.findElement(By.xpath("//a[.='Search']")).click();
		List<WebElement> allAirlines = d.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		for( WebElement flights:allAirlines) {
			System.out.println(flights.getText());
		}
		d.close();
	}
}
