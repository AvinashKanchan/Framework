package com.crm.vtiger.contact;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;
import com.vtiger.objectRepository.OrganizationPopupWindowPage;

/**
 * It is used to create contact with mandatory fields and by selecting organisation 
 * @author Akshay
 *
 */
@Listeners(com.vtiger.comcast.genericUtility.ListenerImplementationClass.class)
public class CreateContactSelectOrgTest extends BaseClass{

		@Test(groups = "regressionTest")
		public void createContactSelectOrg() throws Throwable
		{
		/*fetching the data from excel sheet*/
		int ranNum=jLib.getRandomNumber();
		String contactName=eLib.getExcelData("ContactData", 3, 3)+ranNum;
		String orgName=eLib.getExcelData("ContactData", 4, 3)+ranNum;
		
		/*navigate to organisation*/
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganization();
		
		/*click on create organisation*/
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrganization();
		
		/*create organisation*/
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);
		
		/*verify*/
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String orgMsg = oip.captureOrganizationText();
		Assert.assertEquals(orgMsg.contains(orgName), true);
		
		/*************************************************************************************************************/
				
		/*navigate to contact*/
		hp.clickOnContact();
		
		/*click on create contact*/
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContact();
		
		/*click on add organisation*/
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.clickOnOrganizationImage();
		
		/*switch to popup window*/
		wdLib.switchToWindowWithTitle(driver, "Accounts&action=Popup&popuptype");
		
		/*select the created organisation from popup window*/
		OrganizationPopupWindowPage opwp=new OrganizationPopupWindowPage(driver);
		opwp.selectOrganizationFromPopup(driver, orgName);
		
		/*switch to main window*/
		wdLib.switchToWindowWithTitle(driver, "Contacts");
		
		/*enter contact name and click on save*/
		cncp.createContact(contactName);
		
		/*verify*/
		ContactInformationPage cip=new ContactInformationPage(driver);
		String contactMsg=cip.captureContactText();
		String orgMsg1=cip.captureOrganizationText();
//		if(contactMsg.contains(contactName))
//		{
//			if(orgMsg1.contains(orgName))
//			{
//				System.out.println(contactName+"  Contact Created Successfully with Organization  "+orgName+"  IntegrationValidation==Pass");
//			}
//			else
//			{
//				System.out.println(contactName+"  Contact Created but without Organization  "+orgName+"  IntegrationValidation==Fail");
//			}
//		}
//		else
//		{
//			System.out.println(contactName+"  Contact Not Created Validation==Fail");
//		}
		Assert.assertEquals(orgMsg1.contains(orgName), true);
		Assert.assertEquals(contactMsg.contains(contactName), true);
		
	}

}
