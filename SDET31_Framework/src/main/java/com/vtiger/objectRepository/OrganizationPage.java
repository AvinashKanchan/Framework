package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is organisation page object repository
 * @author Akshay
 *
 */
public class OrganizationPage {

	/*declaration*/
	@FindBy(css="img[title='Create Organization...']")
	private WebElement createOrganizationImage;
	
	/*initialisation*/
	public OrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getCreateOrganizationImage() {
		return createOrganizationImage;
	}
	
	/*business logic*/
	/**
	 * This method will click on create organisation
	 */
	public void clickOnCreateOrganization()
	{
		createOrganizationImage.click();
	}
	
}
