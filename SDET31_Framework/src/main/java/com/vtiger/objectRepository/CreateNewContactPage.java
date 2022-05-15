package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is create new contact page object repository
 * @author Akshay
 *
 */
public class CreateNewContactPage {
	
	/*declaration*/
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//b[text()='Contact Information']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@accessKey='S']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif' and contains(@onclick,'contact_account')]")
	private WebElement organizationSelectIconImage;

	/*initialisation*/
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrganizationSelectIconImage() {
		return organizationSelectIconImage;
	}
	
	/*business logic*/
	/**
	 * This method will create contact will mandatory fields
	 * @param contactName
	 */
	public void createContact(String contactName)
	{
		lastNameTextField.sendKeys(contactName);
		saveButton.click();
	}
	
	/**
	 * This method will click on select organisation image
	 */
	public void clickOnOrganizationImage()
	{
		organizationSelectIconImage.click();
	}
	
	
}
