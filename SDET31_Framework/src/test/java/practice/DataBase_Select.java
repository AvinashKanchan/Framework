package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
public class DataBase_Select {
public static void main(String[] args) throws SQLException {
	Connection conn =null;
	try {
	 // step 1-register the database
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	//step 2-set the path of the database/connect to the database
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
	// step-3-issue sql query
	Statement stat = conn.createStatement();
	//step-4-execute Query
	String query="select * from students_info";
	ResultSet result = stat.executeQuery(query);
	while(result.next()) {
		System.out.println(result.getInt(1) + "\t" + result.getString(2)+  "\t" + result.getString(3)+  "\t" + result.getString(4));
	}
	}
	 catch (Exception e) {
	}
	 finally {
		//step -5 close the connection
			conn.close();
	}
	}
}
