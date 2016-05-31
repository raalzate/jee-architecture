package co.com.techandsolve.creditcard.services;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import co.com.techandsolve.creditcard.business.CardBusinnes;
import co.com.techandsolve.creditcard.entities.Card;
import co.com.techandsolve.creditcard.exception.LockedException;

@Path("creditcard")
public class CardService {
	
	@Inject
	CardBusinnes cardBusinnes;
    

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cards/{cedula}")
	public List<Card> cardList(@PathParam("cedula") String cedula) throws LockedException{
		return cardBusinnes.addBonusAndValidateUser(cedula);
	}


	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("card")
	@ValidateRequest
	public boolean cardSave(@Valid Card card) {
		return cardBusinnes.createCard(card);
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("card")
	public boolean cardDelete(Card card) {
		return cardBusinnes.deleteCard(card);
	}
}