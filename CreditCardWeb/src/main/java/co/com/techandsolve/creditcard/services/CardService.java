package co.com.techandsolve.creditcard.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.techandsolve.creditcard.business.CardBusinnes;
import co.com.techandsolve.creditcard.entities.Card;

@Path("creditcard")
public class CardService {
	
	@Inject
	CardBusinnes cardBusinnes;
    

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cards/{cedula}")
	public List<Card> cards(@PathParam("cedula") String cedula) throws Exception{
		return cardBusinnes.addBonusAndValidateUser(cedula);
	}
}
