package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is product popup window page object repository
 * @author Akshay
 *
 */
public class ProductPopupWindowPage {
	
	/*declaration*/
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(css="input[type='button']")
	private WebElement searchNowButton;
	
	/*initialisation*/
	public ProductPopupWindowPage(WebDriver driver)
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
	 * This method will select the product from popup
	 * @param driver
	 * @param productName
	 */
	public void selectProductFromPopup(WebDriver driver, String productName)
	{
		searchTextField.sendKeys(productName);
		searchNowButton.click();
		driver.findElement(By.linkText(productName)).click();

	}
	

}
