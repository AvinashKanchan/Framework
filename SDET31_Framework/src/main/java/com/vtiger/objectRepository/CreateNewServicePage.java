package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is create new service page object repository
 * @author Akshay
 *
 */
public class CreateNewServicePage {
	
	/*declaration*/
	@FindBy(name="servicename")
	private WebElement serviceNameTextField;
	
	@FindBy(xpath="//b[text()='Service Information']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@accessKey='S']")
	private WebElement saveButton;
	
	@FindBy(name="unit_price")
	private WebElement priceTextField;
	
	/*initialisation*/
	public CreateNewServicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/	
	public WebElement getServiceNameTextField() {
		return serviceNameTextField;
	}


	public WebElement getPriceTextField() {
		return priceTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	/**
	 * This method will create service with mandatory fields
	 * @param serviceName
	 */
	public void createService(String serviceName, String price)
	{
		serviceNameTextField.sendKeys(serviceName);
		priceTextField.sendKeys(price);
		saveButton.click();
	}
	

}
