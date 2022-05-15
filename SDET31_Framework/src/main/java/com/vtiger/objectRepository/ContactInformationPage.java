package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is contact information page object repository
 * @author Akshay
 *
 */
public class ContactInformationPage {
	
	/*declaration*/
	@FindBy(className="dvHeaderText")
	private WebElement contactText;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement organizationText;
	
	/*initialisation*/
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getContactText() {
		return contactText;
	}

	public WebElement getOrganizationText() {
		return organizationText;
	}
	
	/*business logic*/
	/**
	 * This method will capture the contact text from contact information page
	 * @return
	 */
	public String captureContactText()
	{
		return contactText.getText();
	}
	
	/**
	 * This method will capture the organisation text from contact information page
	 * @return
	 */
	public String captureOrganizationText()
	{
		return organizationText.getText();
	}
}
