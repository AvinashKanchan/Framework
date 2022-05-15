package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

/**
 * This is create new purchase order page object repository
 * @author Akshay
 *
 */
public class CreateNewPurchaseOrderPage extends WebDriverUtility{
	
	/*declaration*/
	@FindBy(name="subject")
	private WebElement subjectTextField;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif' and contains(@onclick,'Vendors')]")
	private WebElement vendorSelectIconImage;
	
	@FindBy(xpath="//input[@value='Add Service']")
	private WebElement addServiceButton;
	
	@FindBy(id="searchIcon2")
	private WebElement serviceIconImage;
	
	@FindBy(id="qty2")
	private WebElement quantityTextField;
	
	@FindBy(css="img[src='themes/images/up_layout.gif']")
	private WebElement itemUpwardArrowImage;
	
	@FindBy(css="img[src='themes/images/down_layout.gif']")
	private WebElement itemDownwardArrowImage;
	
	@FindBy(css="img[src='themes/images/delete.gif']")
	private WebElement itemDeleteImage;
	
	@FindBy(xpath="//b[text()='Purchase Order Information']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@accessKey='S']")
	private WebElement saveButton;
	
	@FindBy(xpath="//table[@id='proTab']/tbody/tr[3]/td[2]/descendant::img[@align='absmiddle']")
	private WebElement firstItemNameIconImage;

	/*initialisation*/
	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*getters method*/	
	public WebElement getSubjectTextField() {
		return subjectTextField;
	}

	public WebElement getFirstItemNameIconImage() {
		return firstItemNameIconImage;
	}

	public WebElement getVendorSelectIconImage() {
		return vendorSelectIconImage;
	}

	public WebElement getAddServiceButton() {
		return addServiceButton;
	}

	public WebElement getServiceIconImage() {
		return serviceIconImage;
	}

	public WebElement getQuantityTextField() {
		return quantityTextField;
	}

	public WebElement getItemUpwardArrowImage() {
		return itemUpwardArrowImage;
	}

	public WebElement getItemDownwardArrowImage() {
		return itemDownwardArrowImage;
	}

	public WebElement getItemDeleteImage() {
		return itemDeleteImage;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	/**
	 * This method will enter subject name and click on save
	 * @param poName
	 */
	public void createPurchaseOrder(String poSubject)
	{
		subjectTextField.sendKeys(poSubject);
		saveButton.click();
	}
	
	/**
	 * This method will click on add vendor image
	 */
	public void clickOnVendorImage()
	{
		vendorSelectIconImage.click();
	}
	
	/**
	 * This method will add service and click on service image
	 */
	public void addAndClickOnService()
	{
		addServiceButton.click();
		serviceIconImage.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
