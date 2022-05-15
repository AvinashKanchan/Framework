package com.crm.vtiger.organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;

/**
 * It is used to create organisation with mandatory fields and with industry type
 * @author Akshay
 *
 */
public class CreateOrganizationWithIndustryTypeTest extends BaseClass{

		@Test(groups = "regressionTest")
		public void createOrganizationWithIndustryType() throws Throwable
		{
		/*fetching the data from excel sheet*/
		int ranNum=jLib.getRandomNumber();
		String orgName=eLib.getExcelData("OrganizationData", 3, 3)+ranNum;
		String industryType=eLib.getExcelData("OrganizationData", 4, 3);
		
		/*navigate to organisation*/
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganization();
		
		/*click on create organisation*/
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrganization();
		
		/*create organisation*/
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganizationWithIndustry(orgName, industryType);
				
		/*verify*/
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String orgMsg = oip.captureOrganizationText();
		Assert.assertEquals(orgMsg.contains(orgName), true);
		
	}
}
