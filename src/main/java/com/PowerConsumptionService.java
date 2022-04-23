package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
			 				@FormParam("days") String days)
			 				
	 {
		 String output = consumeOb.InsertPowerConsumptionDetails(userID,account_Number,cus_name,units,days);
		 return output; 
	 }
}
