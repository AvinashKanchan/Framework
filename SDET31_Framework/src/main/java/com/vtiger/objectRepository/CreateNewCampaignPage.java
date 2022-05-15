package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

/**
 * This is create new campaign page object repository
 * @author Akshay
 *
 */
public class CreateNewCampaignPage {

	WebDriverUtility wdLib=new WebDriverUtility();
	
	/*declaration*/
	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(css="img[alt='Select']")
	private WebElement productSelectIconImage;
	
	@FindBy(xpath="//b[text()='Campaign Information']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@accessKey='S']")
	private WebElement saveButton;
	
	/*initialisation*/
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getOrganizationNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getProductSelectIconImage() {
		return productSelectIconImage;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	/**
	 * This method will create campaign with mandatory fields
	 * @param campaignName
	 */
	public void createCampaign(String campaignName)
	{
		campaignNameTextField.sendKeys(campaignName);
		saveButton.click();
	}
	
	/**
	 * This method will click on product select icon image
	 */
	public void clickOnProductSelectImage()
	{
		productSelectIconImage.click();
	}
	
	
}
