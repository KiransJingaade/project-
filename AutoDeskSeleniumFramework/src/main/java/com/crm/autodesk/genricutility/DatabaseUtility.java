package com.crm.autodesk.genricutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {

	Connection connection;
	/**
	 * This method will establish the connection between java and database
	 * @throws SQLException
	 */
	public void connectToDatabase()  {
		
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			DriverManager.getConnection(IPathConstants.DATABASE_URL, IPathConstants.DB_USERNAME, IPathConstants.DB_PASSWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
	/**
	 * This method will close the database connection
	 * @throws SQLException 
	 */
	public void closeDatabase() throws SQLException {
	connection.close();
	}
	/**
	 *This method will return all the data from database
	 * @return 
	 * @throws SQLException 
	 */
	public ResultSet getAllData(String query) throws SQLException {
		
	 ResultSet result = connection.createStatement().executeQuery(query);
			return result;	
	}
	
	public boolean insertData(String query) throws SQLException {
		int result = connection.createStatement().executeUpdate(query);
		boolean flag=false;
		if(result==1) {
			System.out.println("data is added");
			flag=true;
			return flag;
		}else {
			System.out.println("data is not added");
		}
		return flag;
	}
	
}
