package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.vtiger.comcast.genericUtility.WebDriverUtility;

/**
 * This is home page object repository
 * @author Akshay
 *
 */
public class HomePage {

	WebDriverUtility wdLib=new WebDriverUtility();
	
	/*declaration*/
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement logoutIconImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(linkText="Services")
	private WebElement serviceLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorLink;

	/*initialisation*/
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/*getters method*/
	public WebElement getOrganizationLink() {
		return organizationLink;
	}


	public WebElement getLogoutIconImage() {
		return logoutIconImage;
	}


	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
		
	public WebElement getProductLink() {
		return productLink;
	}


	public WebElement getContactLink() {
		return contactLink;
	}


	public WebElement getMoreLink() {
		return moreLink;
	}


	public WebElement getCampaignLink() {
		return campaignLink;
	}

	
	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}


	public WebElement getServicesLink() {
		return serviceLink;
	}


	public WebElement getVendorLink() {
		return vendorLink;
	}

	/*business logic*/
	/**
	 * This method will click on organisation link
	 */
	public void clickOnOrganization()
	{
		organizationLink.click();
	}
	
	/**
	 * This method will click on sign out link
	 * @param driver
	 */
	public void clickOnLogout(WebDriver driver)
	{
		wdLib.moveMouseToElement(driver, logoutIconImage);
		logoutLink.click();
	}
	
	/**
	 * This method will click on product link
	 */
	public void clickOnProduct()
	{
		productLink.click();
	}
	
	/**
	 * This method will click on contact link
	 */
	public void clickOnContact()
	{
		contactLink.click();
	}
	
	/**
	 * This method will click on campaign link
	 * @param driver
	 */
	public void clickOnCampaign(WebDriver driver)
	{
		wdLib.moveMouseToElement(driver, moreLink);
		campaignLink.click();
	}
	
	/**
	 * This method will click on purchase order link
	 * @param driver
	 */
	public void clickOnPurchaseOrder(WebDriver driver)
	{
		wdLib.moveMouseToElement(driver, moreLink);
		purchaseOrderLink.click();
	}
	
	/**
	 * This method will click on service link
	 * @param driver
	 */
	public void clickOnService(WebDriver driver)
	{
		wdLib.moveMouseToElement(driver, moreLink);
		serviceLink.click();
	}
	
	/**
	 * This method will click on vendor link
	 * @param driver
	 */
	public void clickOnVendor(WebDriver driver)
	{
		wdLib.moveMouseToElement(driver, moreLink);
		vendorLink.click();
	}
	
	
}







