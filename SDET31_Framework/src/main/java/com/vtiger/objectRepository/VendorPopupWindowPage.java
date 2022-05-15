package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is vendor popup window page object repository
 * @author Akshay
 *
 */
public class VendorPopupWindowPage {
	
	/*declaration*/
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(css="input[type='button']")
	private WebElement searchNowButton;
	
	/*initialisation*/
	public VendorPopupWindowPage(WebDriver driver)
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
	
	/*business logic*/
	/**
	 * This method will select the vendor from popup
	 * @param driver
	 * @param vendorName
	 */
	public void selectVendorFromPopup(WebDriver driver, String vendorName)
	{
		searchTextField.sendKeys(vendorName);
		searchNowButton.click();
		driver.findElement(By.linkText(vendorName)).click();
	}

}
