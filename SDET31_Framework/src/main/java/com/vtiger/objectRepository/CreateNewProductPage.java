package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is create new product page object repository
 * @author Akshay
 *
 */
public class CreateNewProductPage {

	/*declaration*/
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//b[text()='Product Information']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@accessKey='S']")
	private WebElement saveButton;
	
	/*initialisation*/
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	/**
	 * This method is used to create product with mandatory fields
	 * @param productName
	 */
	public void createProduct(String productName)
	{
		productNameTextField.sendKeys(productName);
		saveButton.click();
	}
	
}
