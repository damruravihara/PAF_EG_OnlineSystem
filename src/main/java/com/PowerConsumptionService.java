package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.PowerConsumption;

@Path("/consume")
public class PowerConsumptionService {
	
	
	PowerConsumption consumeOb = new PowerConsumption();
	
	 @GET
	 @Path("/") 
	 @Produces(MediaType.TEXT_HTML) 
	 public String readItems() 
	  { 
		  return consumeOb.readPwerConsumption(); 
	  }
	 
	 
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String InsertPowerConsumptionDetails(@FormParam("userID") String userID,
			 				@FormParam("account_Number") String account_Number,
			 				@FormParam("cus_name") String cus_name,
			 				@FormParam("units") String units,
			 				@FormParam("days") String days,
	 						@FormParam("generated_date") String generated_date)
			 				
	 {
		 String output = consumeOb.InsertPowerConsumptionDetails(userID,account_Number,cus_name,units,days,generated_date);
		 return output; 
	 }
	 
	 @PUT
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String updateConsumption(String updateCondumptionDetails)
	 {
		 JsonObject updateCons = new JsonParser().parse(updateCondumptionDetails).getAsJsonObject();
		 
		 String userID = updateCons.get("userID").getAsString();
		 String account_Number = updateCons.get("account_Number").getAsString();
		 String cus_name = updateCons.get("cus_name").getAsString();
		 String units = updateCons.get("units").getAsString();
		 String days = updateCons.get("days").getAsString();
		 String generated_date = updateCons.get("generated_date").getAsString();
		 String idpower_consumption = updateCons.get("idpower_consumption").getAsString();
		 
		 String output = consumeOb.updateConsumption(idpower_consumption, userID, account_Number, cus_name, units, days, generated_date);
		 return output;
	 }
	 
	 @DELETE
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String deleteConsume(String deleteConsumeDetails)
	 {
		 JsonObject updateCons = new JsonParser().parse(deleteConsumeDetails).getAsJsonObject();
		 
		 String userID = updateCons.get("userID").getAsString();
		 
		 String output = consumeOb.deleteConsume(userID);
		 return output;

	 }
}
