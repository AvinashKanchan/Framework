package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is service page object repository
 * @author Akshay
 *
 */
public class ServicePage {
	
	/*declaration*/
	@FindBy(css="img[title='Create Service...']")
	private WebElement createServiceIconImage;
	
	/*initialisation*/
	public ServicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getCreateServiceIconImage() {
		return createServiceIconImage;
	}
	
	/*business logic*/
	/**
	 * This method will click on create service image
	 */
	public void clickOnCreateService()
	{
		createServiceIconImage.click();
	}
	

}
