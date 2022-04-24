package model;

import java.sql.*;

public class Bill {
	
	//connect to the DB
	private Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eg_online_system", "root", "admin123");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
// insert bill data	
	
public String insertBill(String userId,String customername, String month, String billType, String billamount) {
		
		String output = "";
		
		try {
			Connection con = connect();
			
			if (con == null)
			{return  "Error while connecting to the database for inserting.";}
			
			// create a prepared statement
			String query = "insert into bill (`idbill`,`userId`,`customername`,`month`,`billType`,`billamount`)" + " values (?, ?, ?, ?, ?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			 // binding values
			 preparedStmt.setInt(1, 0); 
			 preparedStmt.setString(2, userId); 
			 preparedStmt.setString(3, customername); 
			 preparedStmt.setString(4, month); 
			 preparedStmt.setString(5, billType);
			 preparedStmt.setString(6, billamount);
	
			 
			// execute the statement
			 
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Inserted successfully"; 
		}
		catch (Exception e) {
			 output = "Error while inserting the Bill."; 
			 System.err.println(e.getMessage()); 
		}
		
		return output;
	}


//read bill data	

	public String readBills() {
	
		String output = "";
	
		try {
		
			Connection con = connect();
		
			if(con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Bill ID</th><th>UserID</th><th>Customer Name</th>" +
			 "<th>Month</th>" + 
			 "<th>Bill Type</th>" +
			 "<th>Bill Amount</th></tr>";
			 
			 String query = "select * from bill"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
			 
			// iterate through the rows in the result set
			 while(rs.next()) {
				 String idbill = Integer.toString(rs.getInt("idbill")); 
				 String userId = rs.getString("userId"); 
				 String customername = rs.getString("customername"); 
				 String month = rs.getString("month"); 
				 String billType = rs.getString("billType"); 
				 String billamount = rs.getString("billamount");
				 
				 // Add into the html table
				 output += "<tr><td>" + idbill + "</td>";
				 output += "<td>" + userId + "</td>"; 
				 output += "<td>" + customername + "</td>"; 
				 output += "<td>" + month + "</td>"; 
				 output += "<td>" + billType + "</td>";
				 output += "<td>" + billamount + "</td>";
				 
			 }
			 con.close(); 
			 // Complete the html table
			 output += "</table>";
		}
		catch(Exception e)
		{
			 output = "Error while reading the bill."; 
			 System.err.println(e.getMessage()); 
		}
		
		return output;
	}
	
	

//update bill data	
	
	public String updateBill(String idbill, String userId,String customername, String month, String billType, String billamount) 
	{
		String output = "";
		
		try {
			Connection con = connect();
			
			if (con == null)
			{return  "Error while connecting to the database for updating.";}
			
			// create a prepared statement
			String query = "UPDATE bill SET userId=?, customername=?, month=?, billType=?, billamount=? WHERE idbill=?";
							
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			 // binding values
			 preparedStmt.setString(1, userId); 
			 preparedStmt.setString(2, customername); 
			 preparedStmt.setString(3, month); 
			 preparedStmt.setString(4, billType);
			 preparedStmt.setString(5, billamount);
			 preparedStmt.setInt(6, Integer.parseInt(idbill));
	
			 
			// execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 
			 output = "Updated successfully"; 
		}
		catch (Exception e) {
			 output = "Error while updating the Bill."; 
			 System.err.println(e.getMessage()); 
		}
		
		return output;
	} 
	
	
	
//delete bill data
	
	public String deleteBill(String idbill)
	{
		String output = "";
		
		 try
		 {
			 	Connection con = connect();
			 
			 	if (con == null)
			 	{return "Error while connecting to the database for deleting."; }
			 
				 // create a prepared statement
				 String query = "delete from bill where idbill=?";
				 
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(idbill));
				 
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
				 
				 output = "Deleted successfully";
		 
		 }
		 catch (Exception e)
		 {
			 output = "Error while deleting the item.";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
	}
	
}



