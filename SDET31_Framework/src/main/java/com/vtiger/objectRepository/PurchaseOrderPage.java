package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is purchase order page object repository
 * @author Akshay
 *
 */
public class PurchaseOrderPage {
	
	/*declaration*/
	@FindBy(css="img[title='Create Purchase Order...']")
	private WebElement createPurchaseOrderIconImage;
	
	/*initialisation*/
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getCreatePurchaseOrderIconImage() {
		return createPurchaseOrderIconImage;
	}

	/*business logic*/
	/**
	 * This method will click on create purchase order image
	 */
	public void clickOnCreatePurchaseOrder()
	{
		createPurchaseOrderIconImage.click();
	}
	
}
