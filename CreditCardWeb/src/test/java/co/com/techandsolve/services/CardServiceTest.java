package co.com.techandsolve.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.creditcard.business.CardBusinnes;
import co.com.techandsolve.creditcard.entities.Card;
import co.com.techandsolve.creditcard.services.CardService;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {

	private static final String CEDULA = "1234";

	@Mock
	private CardBusinnes cardBusinnes;

	@InjectMocks
	private CardService cardService;

	@Test
	public void debeListarLasTarjetas() throws Exception {
		// arrange

		List<Card> expected = new ArrayList<Card>();

		Card card1 = new Card();
		card1.setMount(1000000);
		expected.add(card1);

		Mockito.when(cardBusinnes.addBonusAndValidateUser(CEDULA)).thenReturn(
				expected);

		// act

		List<Card> resultList = cardService.cardList(CEDULA);
		// asserts

		Assert.assertEquals(expected, resultList);
		Mockito.verify(cardBusinnes).addBonusAndValidateUser(CEDULA);
	}

	@Test
	public void debeCrearTarjeta() {

		// arrange
		Card card = new Card();
		card.setBonus(0);
		card.setStatus(0);
		card.setLabel("Tarjeta Visa Express");
		card.setMount(58000000);
		card.setCedula("1115069076");

		Mockito.when(cardBusinnes.createCard(card)).thenReturn(true);
		// act

		boolean isNew = cardService.cardSave(card);
		// assert

		Mockito.verify(cardBusinnes).createCard(card);
		Assert.assertTrue(isNew);
	}

	@Test
	public void debeEliminarTarjeta() {
		// arrange
		Card card = new Card();
		card.setId(1);

		Mockito.when(cardBusinnes.deleteCard(card)).thenReturn(true);

		// act
		boolean isDeleted = cardService.cardDelete(card);

		// assert
		Mockito.verify(cardBusinnes).deleteCard(card);
		Assert.assertTrue(isDeleted);
	}
}