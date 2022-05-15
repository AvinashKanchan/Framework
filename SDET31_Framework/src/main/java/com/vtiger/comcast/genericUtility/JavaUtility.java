package com.vtiger.comcast.genericUtility;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * It is developed by using java libraries
 * @author Akshay
 *
 */
public class JavaUtility {
	
	/**
	 * It is used to get the random number starting with 0 to 10000
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int ranNum = r.nextInt(10000);
		return ranNum;
	}
	
	/**
	 * It is used to get the current date in YYYY-MM-DD format
	 * @return
	 */
	public String getTodaysDate()
	{
//		Date date=new Date();
//		String dateAndTime=date.toString();
//		String year=dateAndTime.split(" ")[5];
//		String day=dateAndTime.split(" ")[2];
//		int month=date.getMonth()+1;
		String YYYYMMDD = LocalDateTime.now().toString().substring(0, 10);
		return YYYYMMDD;
	}

}
