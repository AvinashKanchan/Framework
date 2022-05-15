package com.crm.vtiger.campaign;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;
import com.vtiger.objectRepository.ProductPopupWindowPage;

/**
 * It is used to create campaign with mandatory fields and by selecting product
 * @author Akshay
 *
 */
public class CreateCampaignSelectProductTest extends BaseClass{

		@Test(groups = "regressionTest")
		public void createCampaignSelectProduct() throws Throwable
		{
		/*fetching the data from excel sheet*/
		int ranNum=jLib.getRandomNumber();
		String productName=eLib.getExcelData("CampaignData", 2, 3)+ranNum;
		String campaignName=eLib.getExcelData("CampaignData", 1, 3)+ranNum;
		
		/*navigate to product*/
		HomePage hp=new HomePage(driver);
		hp.clickOnProduct();		
		
		/*click on create product*/
		ProductPage pp=new ProductPage(driver);
		pp.clickOnCreateProduct();
		
		/*create product*/
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.createProduct(productName);
		
		/*verify*/
		ProductInformationPage pip=new ProductInformationPage(driver);
		String productMsg=pip.captureProductText();
		Assert.assertEquals(productMsg.contains(productName), true);
		
		/********************************************************************************************************/
				
		/*navigate to campaign*/
		hp.clickOnCampaign(driver);
		
		/*click on create campaign*/
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnCreateCampaign();
		
		/*click on select product*/
		CreateNewCampaignPage cncp=new CreateNewCampaignPage(driver);
		cncp.clickOnProductSelectImage();
		
		/*switch to product popup window*/
		wdLib.switchToWindowWithTitle(driver, "Products&action");
		
		/*select the created product from popup window*/
		ProductPopupWindowPage ppwp=new ProductPopupWindowPage(driver);
		ppwp.selectProductFromPopup(driver, productName);
		
		/*switch to campaign window*/
		wdLib.switchToWindowWithTitle(driver, "Campaigns");
		
		/*enter campaign name and click on save*/
		cncp.createCampaign(campaignName);
		
		/*verify*/
		CampaignInformationPage cip=new CampaignInformationPage(driver);
		String campaignMsg=cip.captureCampaignText();
		String productMsg1=cip.captureProductText();
//		if(campaignMsg.contains(campaignName))
//		{
//			if(productMsg1.contains(productName))
//			{
//				System.out.println(campaignName+"  Campaign Created Successfully with product  "+productName+"  IntegrationValidation==Pass");
//			}
//			else
//			{
//				System.out.println(campaignName+"  Campaign Created but without Organization  "+productName+"  IntegrationValidation==Fail");
//			}
//		}
//		else
//		{
//			System.out.println("Campaign Not Created Validation==Fail");
//		}
		Assert.assertEquals(campaignMsg.contains(campaignName), true);
		Assert.assertEquals(productMsg1.contains(productName), true);
	}
}
