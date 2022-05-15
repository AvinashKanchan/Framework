package com.crm.vtiger.purchaseorder;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.objectRepository.CreateNewPurchaseOrderPage;
import com.vtiger.objectRepository.CreateNewServicePage;
import com.vtiger.objectRepository.CreateNewVendorPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.PurchaseOrderPage;
import com.vtiger.objectRepository.ServiceInformationPage;
import com.vtiger.objectRepository.ServicePage;
import com.vtiger.objectRepository.ServicePopupWindowPage;
import com.vtiger.objectRepository.VendorInformationPage;
import com.vtiger.objectRepository.VendorPage;
import com.vtiger.objectRepository.VendorPopupWindowPage;

@Listeners(com.vtiger.comcast.genericUtility.ListenerImplementationClass.class)
public class CreatePurchaseOrderWithItemServicesDownwardSymbolTest extends BaseClass{
	
		@Test(groups = "regressionTest")
		public void createPurchaseOrderWithItemServicesDownwardSymbol() throws Throwable
		{
		/*fetching the data from excel sheet*/
		int ranNum=jLib.getRandomNumber();
//		String poSubject=eLib.getExcelData("PurchaseOrderData", 1, 3)+ranNum;
		String vendorName=eLib.getExcelData("PurchaseOrderData", 2, 3)+ranNum;
		String streetName=eLib.getExcelData("PurchaseOrderData", 3, 3);
		String cityName=eLib.getExcelData("PurchaseOrderData", 4, 3);
		String stateName=eLib.getExcelData("PurchaseOrderData", 5, 3);
		String countryName=eLib.getExcelData("PurchaseOrderData", 6, 3);
		String serviceName=eLib.getExcelData("PurchaseOrderData", 7, 3)+ranNum;
		String price=eLib.getExcelData("PurchaseOrderData", 8, 3);
		
		/*navigate to services*/
		HomePage hp=new HomePage(driver);
		hp.clickOnService(driver);
		
		/*click on create service*/
		ServicePage sp=new ServicePage(driver);
		sp.clickOnCreateService();
		
		/*create service*/
		CreateNewServicePage cnsp=new CreateNewServicePage(driver);
		cnsp.createService(serviceName, price);
		
		/*verify*/
		ServiceInformationPage sip=new ServiceInformationPage(driver);
		String serviceMsg=sip.captureServiceText();
		Assert.assertEquals(serviceMsg.contains(serviceName), true);
		
		/****************************************************************************************/
		
		/*navigate to vendor*/
		hp.clickOnVendor(driver);
		
		/*click on create vendor*/
		VendorPage vp=new VendorPage(driver);
		vp.clickOnCreateVendor();
		
		/*create vendor*/
		CreateNewVendorPage cnvp=new CreateNewVendorPage(driver);
		cnvp.createVendor(vendorName, streetName, cityName, stateName, countryName);
		
		/*verify*/
		VendorInformationPage vip=new VendorInformationPage(driver);
		String vendorMsg=vip.captureVendorText();
		Assert.assertEquals(vendorMsg.contains(vendorName), true);
		
		/****************************************************************************************/
		
		/*navigate to purchase order*/
		hp.clickOnPurchaseOrder(driver);
		
		/*click on create purchase order*/
		PurchaseOrderPage pop=new PurchaseOrderPage(driver);
		pop.clickOnCreatePurchaseOrder();
		
		/*create purchase order*/
		CreateNewPurchaseOrderPage cnpop=new CreateNewPurchaseOrderPage(driver);
		cnpop.clickOnVendorImage();
		
		/*switch to vendor window popup*/
		wdLib.switchToWindowWithTitle(driver, "Vendors&action");
		
		/*select the created service from popup window*/
		VendorPopupWindowPage vwpp=new VendorPopupWindowPage(driver);
		vwpp.selectVendorFromPopup(driver, vendorName);
		
		/*switch to purchase order window*/
		wdLib.switchToWindowWithTitle(driver, "PurchaseOrder&action");
		
		/*add and click on services*/
		cnpop.addAndClickOnService();
		
		/*switch to service window popup*/
		wdLib.switchToWindowWithTitle(driver, "Services&action");
		
		/*select the created service from popup window*/
		ServicePopupWindowPage spwp=new ServicePopupWindowPage(driver);
		spwp.selectServiceFromPopup(driver, serviceName);
		
		/*switch to purchase order window*/
		wdLib.switchToWindowWithTitle(driver, "PurchaseOrder&action");
		
		cnpop.getItemDownwardArrowImage().click();
		cnpop.getFirstItemNameIconImage().click();
		
		/*switch to window popup*/
		wdLib.switchToWindowWithTitle(driver, "Popup&html");
		
		/*verify*/
		Assert.assertEquals(driver.getCurrentUrl().contains("Services&action"), true);
		
		driver.close();
		/*switch to purchase order window*/
		wdLib.switchToWindowWithTitle(driver, "PurchaseOrder&action");
		
	}

}
