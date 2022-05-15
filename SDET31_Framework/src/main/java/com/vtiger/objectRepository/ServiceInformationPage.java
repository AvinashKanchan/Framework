package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is service information page object repository
 * @author Akshay
 *
 */
public class ServiceInformationPage {
	
	/*declaration*/
	@FindBy(className="lvtHeaderText")
	private WebElement serviceText;
	
	/*initialisation*/
	public ServiceInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/
	public WebElement getServiceText() {
		return serviceText;
	}
	
	/*business logic*/
	/**
	 * This method will capture the service text from service information page
	 */
	public String captureServiceText()
	{
		return serviceText.getText();
	}

}
