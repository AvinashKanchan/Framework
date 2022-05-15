package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is organisation popup window page object repository
 * @author Akshay
 *
 */
public class OrganizationPopupWindowPage {
	
	/*declaration*/
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(css="input[type='button']")
	private WebElement searchNowButton;
	
	/*initialisation*/
	public OrganizationPopupWindowPage(WebDriver driver)
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
	 * This method will select organisation from popup window
	 * @param driver
	 * @param orgName
	 */
	public void selectOrganizationFromPopup(WebDriver driver, String orgName)
	{
		searchTextField.sendKeys(orgName);
		searchNowButton.click();
		driver.findElement(By.linkText(orgName)).click();
	}
	

}
