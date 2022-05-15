package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is product page object repository 
 * @author Akshay
 *
 */
public class ProductPage {

	/*declaration*/
	@FindBy(css="img[title='Create Product...']")
	private WebElement createProductImage;
	
	/*initialisation*/
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getCreateProductImage() {
		return createProductImage;
	}
	
	/*business logic*/
	/**
	 * This method will click on create product
	 */
	public void clickOnCreateProduct()
	{
		createProductImage.click();
	}
	

}
