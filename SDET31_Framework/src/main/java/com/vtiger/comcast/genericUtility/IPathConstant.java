package com.vtiger.comcast.genericUtility;

/**
 * This interface contains constant values used in entire framework
 * @author Akshay
 *
 */
public interface IPathConstant {
	
	String CHROMEKEY="webdriver.chrome.driver";
	String CHROMEVALUE="./src/main/resources/chromedriver.exe";
	
	String FIREFOXKEY="webdriver.gecko.driver";
	String FIREFOXVALUE="./src/main/resources/geckodriver.exe";
	
	String EDGEKEY="webdriver.edge.driver";
	String EDGEVALUE="./src/main/resources/msedgedriver.exe";
	
	String PROPERTYPATH="./src/main/resources/commondata/credentials.properties";
	String EXCELPATH="./src/main/resources/testdata/TestData.xlsx";

	String DATABASE_URL="jdbc:mysql://localhost:3306/testyantra";
	String DATABASE_USERNAME="root";
	String DATABASE_PASSWORD="root";
}
