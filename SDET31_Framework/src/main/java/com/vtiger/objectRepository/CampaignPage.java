package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *This is campaign page object repository 
 * @author Akshay
 *
 */
public class CampaignPage {
	
	/*declaration*/
	@FindBy(css="img[title='Create Campaign...']")
	private WebElement createCampaignIconImage;
	
	/*initialisation*/
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getCreateCampaignIconImage() {
		return createCampaignIconImage;
	}
	
	/*business logic*/
	/**
	 * This method will click on create campaign image 
	 */
	public void clickOnCreateCampaign()
	{
		createCampaignIconImage.click();
	}
	

}
