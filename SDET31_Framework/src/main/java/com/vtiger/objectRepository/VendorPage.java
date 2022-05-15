package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is vendor page object repository
 * @author Akshay
 *
 */
public class VendorPage {
	
	/*declaration*/
	@FindBy(css="img[title='Create Vendor...']")
	private WebElement createVendorIconImage;
	
	/*initialisation*/
	public VendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getCreateVendorIconImage() {
		return createVendorIconImage;
	}

	/*business logic*/
	/**
	 * This method will click on create vendor image
	 */
	public void clickOnCreateVendor()
	{
		createVendorIconImage.click();
	}
	
}
