package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is vendor information page object repository 
 * @author Akshay
 *
 */
public class VendorInformationPage {
	
	
	/*declaration*/
	@FindBy(className="lvtHeaderText")
	private WebElement vendorText;

	/*initialisation*/
	public VendorInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getVendorText() {
		return vendorText;
	}
	
	/*business Logic*/
	/**
	 * This method will capture vendor text from vendor information page
	 * @return
	 */
	public String captureVendorText()
	{
		return vendorText.getText();
	}
	
	
}
