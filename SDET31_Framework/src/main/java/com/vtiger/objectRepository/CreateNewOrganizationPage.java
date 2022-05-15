package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

/**
 * This is create new organisation page object Repository
 * @author Akshay
 *
 */
public class CreateNewOrganizationPage {
	
	WebDriverUtility wdLib=new WebDriverUtility();
	
	/*declaration*/
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryListbox;
	
	@FindBy(xpath="//b[text()='Organization Information']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@accessKey='S']")
	private WebElement saveButton;
	
	/*initialisation*/
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getIndustryListbox() {
		return industryListbox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	/**
	 * This method is used to create organisation with industry type
	 * @param organizationName
	 * @param industryName
	 */
	public void createOrganizationWithIndustry(String organizationName, String industryName)
	{
		organizationNameTextField.sendKeys(organizationName);
		wdLib.selectFromList(industryListbox, industryName);
		saveButton.click();
	}
	
	/**
	 * This method is use to create organisation with mandatory fields
	 * @param organizationName
	 */
	public void createOrganization(String organizationName)
	{
		organizationNameTextField.sendKeys(organizationName);
		saveButton.click();
	}
	
	
	
	
	
	
}
