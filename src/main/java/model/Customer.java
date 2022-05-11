package model;

import java.sql.*; 

public class Customer {
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
	
	public String insertCustomer(String cus_name, String cus_address, String cus_phone_no, String cus_nic, String username, String password, String account_number) {
		
		String output = "";
		
		try {
			Connection con = connect();
			
			if (con == null)
			{return  "Error while connecting to the database for inserting.";}
			
			// create a prepared statement
			String query = "  insert into customer (`idcustomer`,`cus_name`,`cus_address`,`cus_phone_no`,`cus_nic`,`username`,`password`,account_number)" + " values (?, ?, ?, ?, ?,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			 // binding values
			 preparedStmt.setInt(1, 0); 
			 preparedStmt.setString(2, cus_name); 
			 preparedStmt.setString(3, cus_address); 
			 preparedStmt.setString(4, cus_phone_no); 
			 preparedStmt.setString(5, cus_nic);
			 preparedStmt.setString(6, username);
			 preparedStmt.setString(7, password);
			 preparedStmt.setString(8, account_number);
			 
			// execute the statement
			 
			 preparedStmt.execute(); 
			 con.close(); 
				String newCus = readCustomers();
				output = "{\"status\":\"success\", \"data\": \"" +newCus+ "\"}";
//			 output = "Inserted successfully"; 
		}
		catch (Exception e) {
//			 output = "Error while inserting the Customer.";
			output = "{\"status\":\"error\", \"data\":\"Error while Inserting the Customer.\"}";
			 System.err.println(e.getMessage()); 
		}
		
		return output;
	}
	
	public String readCustomers() {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			 // Prepare the html table to be displayed
			 output = "<table border='1' class='table table-hover'><tr><th>Customer Name</th><th>Customer Address</th>" +
			 "<th>Phone Number</th>" + 
			 "<th>NIC</th>" +
			 "<th>UserName</th>" +
			 "<th>Password</th>" +
			 "<th>Account Number</th>"+
			 "<th>Update</th><th>Remove</th></tr>";
			 
			 String query = "select * from customer"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
			 
			 while(rs.next()) {
				 String idcustomer = Integer.toString(rs.getInt("idcustomer")); 
				 String cus_name = rs.getString("cus_name"); 
				 String cus_address = rs.getString("cus_address"); 
				 String cus_phone_no = rs.getString("cus_phone_no"); 
				 String cus_nic = rs.getString("cus_nic"); 
				 String username = rs.getString("username");
				 String password = rs.getString("password");
				 String account_number = rs.getString("account_number");
				 
				 // Add into the html table
				 output += "<tr><td><input id='hididUpdate' name='hididUpdate' type='hidden' value=" + idcustomer + ">" + cus_name + "</td>";
				 output += "<td>" + cus_address + "</td>"; 
				 output += "<td>" + cus_phone_no + "</td>"; 
				 output += "<td>" + cus_nic + "</td>";
				 output += "<td>" + username + "</td>";
				 output += "<td>" + password + "</td>";
				 output += "<td>" + account_number + "</td>";
				 
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
							+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-idcustomer='"
							+ idcustomer + "'>" + "</td></tr>";
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
	
	public String updateCustomer(String idcustomer,String cus_name, String cus_address, String cus_phone_no, String cus_nic, String username,String password, String account_number) {
		
		String output = "";
		
		try {
			Connection con = connect();
			
			if (con == null)
			{return  "Error while connecting to the database for inserting.";}
			
			// create a prepared statement
			String query = "  UPDATE customer SET cus_name=?,cus_address=?,cus_phone_no=?,cus_nic=?,username=?,password=?, account_number=? WHERE idcustomer=?" ;
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			 // binding values
			 preparedStmt.setString(1, cus_name); 
			 preparedStmt.setString(2, cus_address); 
			 preparedStmt.setString(3, cus_phone_no); 
			 preparedStmt.setString(4, cus_nic);
			 preparedStmt.setString(5, username);
			 preparedStmt.setString(6, password);
			 preparedStmt.setString(7, account_number);
			 preparedStmt.setInt(8, Integer.parseInt(idcustomer)); 
			 
			// execute the statement
			 
			 preparedStmt.execute(); 
			 con.close(); 
			String newCus = readCustomers();
			output = "{\"status\":\"success\", \"data\": \"" +newCus+ "\"}";
//			 output = "Updated successful"; 
		}
		catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while Updating the Customer.\"}";
//			 output = "Error while Update the Customer."; 
			 System.err.println(e.getMessage()); 
		}
		
		return output;
	}
	
	public String deleteCustomer(String idcustomer) {
		 String output = ""; 
		 try {
			 Connection con = connect(); 
			 
			 if (con == null) 
			 {return "Error while connecting to the database for deleting."; }
			 
			 // create a prepared statement
			 String query = "delete from customer where idcustomer=?"; 
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(idcustomer)); 
			 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
				String newCus = readCustomers();
				output = "{\"status\":\"success\", \"data\": \"" +newCus+ "\"}";
//			 output = "Deleted successfully"; 
		 }
		 catch (Exception e) 
		 { 
			 output = "{\"status\":\"error\", \"data\":\"Error while Deleting the Customer.\"}";
//			 output = "Error while deleting the customer."; 
			 System.err.println(e.getMessage()); 
		 } 
		 
		 return output;
	}
}
