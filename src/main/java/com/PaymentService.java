package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Payment;

@Path("/Pay") 
public class PaymentService {
	
	Payment paymentObj = new Payment();
	
	@POST
	@Path("/insert") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertPayment(@FormParam("AccountNo") String AccountNo, 
	 @FormParam("CardNum") String CardNum, 
	 @FormParam("ExpiryDate") String ExpiryDate, 
	 @FormParam("CCV") String CCV,
	 @FormParam("TelNo") String TelNo) 
	{ 
	 String output = paymentObj.insertPayment(AccountNo, CardNum, ExpiryDate, CCV, TelNo); 
	return output; 
	}
	
	@GET
	@Path("/read") 
	@Produces(MediaType.TEXT_HTML) 
	public String readPayment() 
	 { 
	 return paymentObj.readPayment(); 
	}

}
