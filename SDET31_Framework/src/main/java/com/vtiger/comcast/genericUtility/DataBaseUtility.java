package com.vtiger.comcast.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods to connect, close connection, fetch the data , insert data from
 * MySql Database
 * @author Akshay
 *
 */
public class DataBaseUtility {
	
	Connection conn;
	
	public void connectToDataBase()
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(IPathConstant.DATABASE_URL, IPathConstant.DATABASE_USERNAME, IPathConstant.DATABASE_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeDataBaseConn()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet getDataFromDataBase(String query)
	{
		ResultSet result = null;
		try {
			result = conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insertDataToDataBase(String query)
	{
		boolean flag=false;
		try {
			int result = conn.createStatement().executeUpdate(query);
			if(result==1)
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
