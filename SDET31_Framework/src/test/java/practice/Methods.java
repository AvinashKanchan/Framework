package practice;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Methods {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//a[text()='Explore All Offers']")).click();
		
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext()) {
			String id = it.next();
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains("offers/flight-offers"))
			{
				break;
			}
		}
		
		
		String msg=driver.findElement(By.xpath("//h1[text()='Find best deals and discounts on flight booking !']")).getText();
		System.out.println(msg);
		driver.quit();
	}
}
