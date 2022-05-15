package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboGetHotelsName {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.get("https://www.goibibo.com/");
		d.findElement(By.xpath("//ul[@class='happy-nav']/descendant::a[@href='/hotels/']")).click();
		d.findElement(By.xpath("//h4[.='India']/preceding::input[@name='CountryType']")).click();
		d.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys("leh");
		Thread.sleep(2000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		d.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']/h4")).click();
		String path="//span[.='March 2022']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[.='31']";
		d.findElement(By.xpath(path)).click();
		d.findElement(By.xpath("//li[@data-testid='date_li_1_3_2022']/child::span[.='1']")).click();
		d.findElement(By.xpath("//input[@value='2 Adults | 0 Child | 1 Room ']")).click();
		String path2="//span[.='(0-12 yr)']/ancestor::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/descendant::span[.='+']";
		d.findElement(By.xpath(path2)).click();
		d.findElement(By.xpath(path2)).click();
		d.findElement(By.xpath(path2)).click();
			}
}
