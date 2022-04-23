package model;

import java.sql.*;  

public class PowerConsumption {
	
	
	private Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eg_online_system", "root", "rusiru123");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}	

	//column name
public String InsertPowerConsumptionDetails(String userID, String account_Number, String cus_name, String units, String days) {
 
	String output = "";
	try {
		Connection con = connect();
		
		if (con == null)
		{return  "Error while connecting to the database for inserting.";}
		
		// create a prepared statement
		//column name
		String query = "  insert into power_consumption (`idpower_consumption`,`userID`,`account_Number`,`cus_name`,`units`,`days`)" + " values (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		 // binding values
		 preparedStmt.setInt(1, 0); 
		 preparedStmt.setString(2, userID);
		 preparedStmt.setString(3, account_Number);
		 preparedStmt.setString(4, cus_name); 
		 preparedStmt.setString(5, units); 
		 preparedStmt.setString(6, days);
	
		 
		// execute the statement
		 
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Inserted successfully"; 
	}
	catch (Exception e) {
		 output = "Error while inserting the Power Consumption."; 
		 System.err.println(e.getMessage()); 
	}
	
	return output;
	}

public String readPwerConsumption() {
	
	String output = "";
	
	try {
		
		Connection con = connect();
		
		if(con == null) {
			return "Error while connecting to the database for reading.";
		}
		
		 // Prepare the html table to be displayed
		 output = "<table border='1'>"
		 		+ "<tr>"
		 		+ "<th>Customer ID</th>"
		 		+ "<th>Account Number</th>" +
		 		  "<th>CustomerName</th>" + 
		 		  "<th>Units</th>" +
		 		  "<th>Days</th>" +		 		  
		 		  "<th>Update</th>"+
		 		  "<th>Remove</th></tr>";
		 
		 String query = "select * from power_consumption"; 
		 Statement stmt = con.createStatement(); 
		 ResultSet rs = stmt.executeQuery(query); 
		 
		 while(rs.next()) {
			 
			 String userID = rs.getString("userID");
			 String account_Number = rs.getString("account_Number"); 
			 String cus_name = rs.getString("cus_name"); 
			 String units = rs.getString("units"); 
			 String days = rs.getString("days"); 
			
			 
			 // Add into the HTML table
			 output += "<tr><td>" + userID + "</td>"; 
			 output += "<td>" + account_Number + "</td>";
			 output += "<td>" + cus_name + "</td>"; 
			 output += "<td>" + units + "</td>"; 
			 output += "<td>" + days + "</td>";
			 
			 
			 // buttons
			 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>" + "<td><form method='post' action='customer.jsp'>"
			 + "<input name='btnRemove' type='submit' value='Delete'class='btn btn-danger'>"
			 + "<input name='idcustomer' type='hidden' value='" + account_Number + "'>" + "</form></td></tr>"; 
		 }
		 con.close(); 
		 // Complete the html table
		 output += "</table>";
	}
	catch(Exception e)
	{
		 output = "Error while reading the customer."; 
		 System.err.println(e.getMessage()); 
	}
	
	return output;
}
}
