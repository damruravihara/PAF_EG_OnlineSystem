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
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertCustomer(@FormParam("cus_name") String cus_name,
			 				@FormParam("cus_address") String cus_address,
			 				@FormParam("cus_phone_no") String cus_phone_no,
			 				@FormParam("cus_nic") String cus_nic,
			 				@FormParam("username") String username,
			 				@FormParam("password") String password)
	 {
		 String output = customerObj.insertCustomer(cus_name, cus_address, cus_phone_no, cus_nic,username,password); 
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
}
