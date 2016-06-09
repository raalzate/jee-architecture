package co.com.techandsolve.creditcard.services;


import javax.inject.Inject;
import javax.jms.JMSException;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import co.com.techandsolve.creditcard.business.BillBusiness;
import co.com.techandsolve.creditcard.entities.Bill;

@Path("bill")
public class BillService {
	
	@Inject BillBusiness billBusiness;

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("register")
	@ValidateRequest
	public Response register(@Valid Bill bill) throws JMSException  {
		
		billBusiness.sendMessage(bill);
		
		return Response.status(201).header("SendMessage", 
				"Mensaje enviado").build();

	}
}
