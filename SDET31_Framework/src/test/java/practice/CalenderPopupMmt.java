package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CalenderPopupMmt {

	public static void main(String[] args) {
		String monthAndYear="March 2022";
		String date="14";
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.get("https://www.makemytrip.com/");
		Actions action=new Actions(d);
		action.moveByOffset(20,20).click().perform();
		d.findElement(By.className("langCardClose")).click();
		d.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		String calenderDateXpath="//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		d.findElement(By.xpath(calenderDateXpath)).click();
		d.quit();
		System.out.println("The date selected for the booking of the ticket is :"+date+"-"+monthAndYear);
	}
}
