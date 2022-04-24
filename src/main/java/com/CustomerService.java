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
}
