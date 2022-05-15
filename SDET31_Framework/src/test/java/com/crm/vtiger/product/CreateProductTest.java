package com.crm.vtiger.product;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;

/**
 * It is used to create product with mandatory fields
 * @author Akshay
 *
 */
public class CreateProductTest extends BaseClass{

		@Test(groups = "smokeTest", retryAnalyzer = com.vtiger.comcast.genericUtility.RetryAnalyzerImplementationClass.class)
		public void createProduct() throws Throwable
		{
		
		/*fetching the data from excel sheet*/
		int ranNum=jLib.getRandomNumber();
		String productName=eLib.getExcelData("ProductData", 1, 3)+ranNum;
				
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
				
	}
}
