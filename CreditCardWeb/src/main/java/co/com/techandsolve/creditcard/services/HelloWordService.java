package co.com.techandsolve.creditcard.services;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.techandsolve.creditcard.bean.CardBean;
import co.com.techandsolve.creditcard.business.HelloWordBusiness;

@Path("helloword")
public class HelloWordService {

	@Inject
	CardBean cardBean;
	
	@GET
	@Path("sayWS")
	public String saySW(){
		HelloWordBusiness helloWordBusiness = new HelloWordBusiness();
		return helloWordBusiness.say();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cards")
	public Response cards(){
		return null;
	}
}
