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
	 public String InsertPowerConsumptionDetails(@FormParam("accountNumber") String accountNumber,
			 				@FormParam("customerName") String customerName,
			 				@FormParam("units") String units,
			 				@FormParam("days") String days)
			 				
	 {
		 String output = consumeOb.InsertPowerConsumptionDetails(accountNumber,customerName,units,days);
		 return output; 
	 }
}
