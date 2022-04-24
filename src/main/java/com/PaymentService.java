package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

	
	@PUT
	@Path("/update") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updatePayment(String PaymentData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject PaymentObject = new JsonParser().parse(PaymentData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String PaymentId = PaymentObject.get("PaymentId").getAsString(); 
	 String AccountNo = PaymentObject.get("AccountNo").getAsString();
	 String CardNum = PaymentObject.get("CardNum").getAsString(); 
	 String ExpiryDate= PaymentObject.get("ExpiryDate").getAsString(); 
	 String CCV = PaymentObject.get("CCV").getAsString(); 
	 String TelNo = PaymentObject.get("TelNo").getAsString(); 
	 String output =paymentObj.updatePayment(PaymentId, AccountNo, CardNum, ExpiryDate, CCV, TelNo); 
	return output; 
	}
	
	
	
}


