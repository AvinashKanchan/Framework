package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is product information page object repository
 * @author Akshay
 *
 */
public class ProductInformationPage {

	/*declaration*/
	@FindBy(className = "lvtHeaderText")
	private WebElement productText;
	
	/*initialisation*/
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getProductText() {
		return productText;
	}
	
	/*business logic*/
	/**
	 * This method fetch the product text from product information page
	 */
	public String captureProductText()
	{
		return productText.getText();
	}
	

}
