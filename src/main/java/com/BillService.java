package com;

import model.Bill;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/Bills")
public class BillService {
	
Bill billObj = new Bill();
	
	// read (GET) method
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readBills()
	{
		return billObj.readBills();
	}
	
	// add (POST) method
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertBill(@FormParam("userId") String userId,
			 				@FormParam("customername") String customername,
			 				@FormParam("month") String month,
			 				@FormParam("billType") String billType,
			 				@FormParam("billamount") String billamount)
	 {
		 String output = billObj.insertBill(userId,customername, month, billType,billamount); 
		 return output; 
	 }
		
}
