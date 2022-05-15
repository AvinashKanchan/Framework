package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

/**
 * This is service popup window page object repository
 * @author Akshay
 *
 */
public class ServicePopupWindowPage extends WebDriverUtility{
	
	/*declaration*/
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(css="input[type='button']")
	private WebElement searchNowButton;
	
	@FindBy(css="select[name='search_field']")
	private WebElement inListBox;
	
	/*initialisation*/
	public ServicePopupWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

	public WebElement getInListBox() {
		return inListBox;
	}

	/*business logic*/
	/**
	 * This method will select service from  service window popup
	 * @param driver
	 * @param serviceName
	 */
	public void selectServiceFromPopup(WebDriver driver, String serviceName)
	{
		searchTextField.sendKeys(serviceName);
		selectFromList(inListBox, "servicename");
		searchNowButton.click();
		driver.findElement(By.linkText(serviceName)).click();
	}
	
	
}
