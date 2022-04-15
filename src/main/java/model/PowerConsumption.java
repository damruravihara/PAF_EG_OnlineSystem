package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 

public class PowerConsumption {
	
	private Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eg_online_system", "root", "pafproject");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}	

public String InsertPowerConsumptionDetails(String customerName, int accountNumber, int units, int days) {
 
	String output = "";
	try {
		Connection con = connect();
		
		if (con == null)
		{return  "Error while connecting to the database for inserting.";}
		
		// create a prepared statement
		String query = "  insert into customer (`accountNumber`,`customerName`,`units`,`days`)" + " values (?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		 // binding values
		 preparedStmt.setInt(1, 0); 
		 preparedStmt.setInt(2, accountNumber);
		 preparedStmt.setString(3, customerName); 
		 preparedStmt.setInt(4, units); 
		 preparedStmt.setInt(5, days);
	
		 
		// execute the statement
		 
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Inserted successfully"; 
	}
	catch (Exception e) {
		 output = "Error while inserting the Customer."; 
		 System.err.println(e.getMessage()); 
	}
	
	return output;
	}
}
