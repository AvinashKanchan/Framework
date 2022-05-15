package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is campaign information page object repository
 * @author Akshay
 *
 */
public class CampaignInformationPage {

	/*declaration*/
	@FindBy(className="dvHeaderText")
	private WebElement campaignText;
	
	@FindBy(id="mouseArea_Product")
	private WebElement productText;
	
	/*initialisation*/
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*getters method*/
	public WebElement getCampaignText() {
		return campaignText;
	}

	public WebElement getProductText() {
		return productText;
	}
	
	/*business logic*/
	/**
	 * This method will capture campaign text from campaign information page
	 * @return
	 */
	public String captureCampaignText()
	{
		return campaignText.getText();
	}
	
	/**
	 * This method will capture product text from campaign information page
	 * @return
	 */
	public String captureProductText()
	{
		return productText.getText();
	}
	
	
	
}
