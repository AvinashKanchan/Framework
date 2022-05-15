package com.crm.vtiger.contact;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;

/**
 * It is used to create contact with mandatory fields
 * @author Akshay
 *
 */
public class CreateContactTest extends BaseClass{

		@Test(groups = "smokeTest")
		public void createContact() throws Throwable
		{
		/*fetching the data from excel sheet*/
		int ranNum=jLib.getRandomNumber();
		String contactName=eLib.getExcelData("ContactData", 1, 3)+ranNum;
		
		/*navigate to organisation*/
		HomePage hp=new HomePage(driver);
		hp.clickOnContact();
		
		/*click on create contact*/
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContact();
		
		/*create contact*/
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContact(contactName);
		
		/*verify*/
		ContactInformationPage cip=new ContactInformationPage(driver);
		String contactMsg=cip.captureContactText();
		Assert.assertEquals(contactMsg.contains(contactName), true);
		
	}

}
