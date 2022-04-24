package com;

import model.Customer;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Customer")
public class CustomerService {
	Customer customerObj = new Customer();
	
	 @GET
	 @Path("/") 
	 @Produces(MediaType.TEXT_HTML) 
	 public String readItems() 
	  { 
		  return customerObj.readCustomers(); 
	  }
	 
	 
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertCustomer(String insertData)
	 {
			//Convert the input string to a JSON object 
		 JsonObject insertObject = new JsonParser().parse(insertData).getAsJsonObject();
		 
		 String cus_name = insertObject.get("cus_name").getAsString();
		 String cus_address = insertObject.get("cus_address").getAsString();
		 String cus_phone_no = insertObject.get("cus_phone_no").getAsString();
		 String cus_nic = insertObject.get("cus_nic").getAsString();
		 String username = insertObject.get("username").getAsString();
		 String password = insertObject.get("password").getAsString();
		 String account_number = insertObject.get("account_number").getAsString();


		 String output = customerObj.insertCustomer(cus_name, cus_address, cus_phone_no, cus_nic,username,password,account_number); 
		 return output; 
	 }
	 
	 @GET
	 @Path("/login")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String loginCustomer(String loginData)
	 {
			//Convert the input string to a JSON object 
		 JsonObject loginObject = new JsonParser().parse(loginData).getAsJsonObject();
		 
		 String username = loginObject.get("username").getAsString(); 
		 String password = loginObject.get("password").getAsString(); 

		 String output = customerObj.loginCustomer(username, password);
		 return output;
	 }
	 
	 @PUT
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String updateCustomer(String updateCustomerData)
	 {
		 JsonObject updateObject = new JsonParser().parse(updateCustomerData).getAsJsonObject();
		 
		 String idcustomer = updateObject.get("idcustomer").getAsString();
		 String cus_name = updateObject.get("cus_name").getAsString();
		 String cus_address = updateObject.get("cus_address").getAsString();
		 String cus_phone_no = updateObject.get("cus_phone_no").getAsString();
		 String cus_nic = updateObject.get("cus_nic").getAsString();
		 String username = updateObject.get("username").getAsString();
		 String account_number = updateObject.get("account_number").getAsString();
		 
		 String output = customerObj.updateCustomer(idcustomer, cus_name, cus_address, cus_phone_no, cus_nic, username, account_number);
		 return output;
	 }
}
