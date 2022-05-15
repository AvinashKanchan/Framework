package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is contact page object repository
 * @author Akshay
 *
 */
public class ContactPage {
	
	/*declaration*/
	@FindBy(css="img[title='Create Contact...']")
	private WebElement createContactIconImage;
	
	/*initialisation*/
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getCreateContactIconImage() {
		return createContactIconImage;
	}
	
	/*business logic*/
	/**
	 * This method will click on create contact image
	 */
	public void clickOnCreateContact()
	{
		createContactIconImage.click();
	}

}
