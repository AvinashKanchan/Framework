package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is create new vendor page object repository
 * @author Akshay
 *
 */
public class CreateNewVendorPage {
	
	/*declaration*/
	@FindBy(name="vendorname")
	private WebElement vendorNameTextField;
	
	@FindBy(name="street")
	private WebElement streetTextField;
	
	@FindBy(name="city")
	private WebElement cityTextField;

	@FindBy(name="state")
	private WebElement stateTextField;
	
	@FindBy(name="country")
	private WebElement countryTextField;
	
	@FindBy(xpath="//b[text()='Vendor Information:']/preceding::input[@accessKey='S']")
	private WebElement saveButton;
	
	/*initialisation*/
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getVendorNameTextField() {
		return vendorNameTextField;
	}

	public WebElement getStreetTextField() {
		return streetTextField;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getStateTextField() {
		return stateTextField;
	}

	public WebElement getCountryTextField() {
		return countryTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	/**
	 * This method will create vendor with name and address
	 * @param vendorName
	 * @param streetName
	 * @param cityName
	 * @param stateName
	 * @param countryName
	 */
	public void createVendor(String vendorName, String streetName, String cityName, String stateName, String countryName)
	{
		vendorNameTextField.sendKeys(vendorName);
		streetTextField.sendKeys(streetName);
		cityTextField.sendKeys(cityName);
		stateTextField.sendKeys(stateName);
		countryTextField.sendKeys(countryName);
		saveButton.click();
	}
	
	
	
}
