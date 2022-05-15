package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is organisation information page object repository
 * @author Akshay
 *
 */
public class OrganizationInformationPage {

	/*declaration*/
	@FindBy(className="dvHeaderText")
	private WebElement organizationText;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryText;
	
	/*initialisation*/
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getOrganizationText() {
		return organizationText;
	}

	public WebElement getIndustryText() {
		return industryText;
	}
	
	/*business logic*/
	/**
	 * This method will capture the organisation text from organisation information page
	 * @return
	 */
	public String captureOrganizationText()
	{
		return organizationText.getText();
	}
	

}
