package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * It is developed by using java methods to handle properties file
 * @author Akshay
 *
 */
public class FileUtility {

	/**
	 * It is used to read the value from properties file based on key provided in argument
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.PROPERTYPATH);
		Properties pro_obj=new Properties();
		pro_obj.load(fis);
		String value = pro_obj.getProperty(key);
		return value;		
	}
}
