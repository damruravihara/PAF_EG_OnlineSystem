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
	 
	 
	// update (PUT) method
		 @PUT
		 @Path("/")
		 @Consumes(MediaType.APPLICATION_JSON)
		 @Produces(MediaType.TEXT_PLAIN)
		 public String updateBill(String billData)
		 {
			//Convert the input string to a JSON object
			 JsonObject billObject = new JsonParser().parse(billData).getAsJsonObject();
			 
			//Read the values from the JSON object
			 String idbill = billObject.get("idbill").getAsString();
			 String userId = billObject.get("userId").getAsString();
			 String customername = billObject.get("customername").getAsString();
			 String month = billObject.get("month").getAsString();
			 String billType = billObject.get("billType").getAsString();
			 String billamount = billObject.get("billamount").getAsString();
			 
			 String output = billObj.updateBill(idbill,userId,customername,month,billType,billamount);
			 
			return output; 
		 } 
		
		  
	//delete (DELETE) method
		 
		 @DELETE
		 @Path("/")
		 @Consumes(MediaType.APPLICATION_XML)
		 @Produces(MediaType.TEXT_PLAIN)
		 public String deleteBill(String billData)
		 {
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(billData, "", Parser.xmlParser());

			//Read the value from the element <itemID>
			 String idbill = doc.select("idbill").text();
			 
			 String output = billObj.deleteBill(idbill);
			 
			return output;
		 }
		
}
