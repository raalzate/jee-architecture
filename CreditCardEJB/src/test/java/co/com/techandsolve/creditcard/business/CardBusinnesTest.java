package co.com.techandsolve.creditcard.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.creditcard.bean.CardBean;
import co.com.techandsolve.creditcard.entities.Card;
import co.com.techandsolve.creditcard.exception.LockedException;

@RunWith(MockitoJUnitRunner.class)
public class CardBusinnesTest {

	public static final String CEDULA = "1234";

	@Mock
	CardBean cardBean;

	@InjectMocks
	CardBusinnes cardBusiness;

	@Test
	public void cuandoEsMasDe_1Mll_AgregarBonificar_20M() throws LockedException {
		// arrange
		List<Card> expected = new ArrayList<Card>();

		Card card1 = new Card();
		card1.setMount(1000000);
		card1.setStatus(0);
		expected.add(card1);

		Card card2 = new Card();
		card2.setMount(1000000);
		card2.setStatus(0);
		expected.add(card2);

		Mockito.when(cardBean.getCardByCC(CEDULA)).thenReturn(expected);

		// act
		List<Card> lstResult = cardBusiness.addBonusAndValidateUser(CEDULA);

		// assert
		Assert.assertTrue(lstResult.get(0).getBonus() == 20000);
		Assert.assertTrue(lstResult.get(1).getBonus() == 20000);

	}

	@Test
	public void cuandoEsMasDe_700M_AgregarBonificar_10M() throws LockedException {
		// arrange
		List<Card> expected = new ArrayList<Card>();

		Card card1 = new Card();
		card1.setMount(700000);
		card1.setStatus(0);
		expected.add(card1);

		Mockito.when(cardBean.getCardByCC(CEDULA)).thenReturn(expected);

		// act
		List<Card> lstResult = cardBusiness.addBonusAndValidateUser(CEDULA);
		
		// assert
		Assert.assertTrue(lstResult.get(0).getBonus() == 10000);

	}

	@Test
	public void cuandoTieneBonos_noAgregarBonificacion() throws LockedException {
		// arrange
		List<Card> expected = new ArrayList<Card>();

		Card card1 = new Card();
		card1.setMount(1000000);
		card1.setBonus(10);
		card1.setStatus(0);
		expected.add(card1);

		Mockito.when(cardBean.getCardByCC(CEDULA)).thenReturn(expected);

		// act
		List<Card> lstResult = cardBusiness.addBonusAndValidateUser(CEDULA);

		// assert
		Assert.assertTrue(lstResult.get(0).getBonus() == 10);

	}

	@Test(expected = LockedException.class)
	public void cuandoEstaBloqueadaUnaTarjenta() throws LockedException {
		// arrange
		List<Card> expected = new ArrayList<Card>();

		Card card1 = new Card();
		card1.setMount(1000000);
		card1.setStatus(1);
		expected.add(card1);
		
		card1 = new Card();
		card1.setMount(1000000);
		card1.setStatus(0);
		expected.add(card1);


		Mockito.when(cardBean.getCardByCC(CEDULA)).thenReturn(expected);

		// act
		cardBusiness.addBonusAndValidateUser(CEDULA);

	
	}
	
	@Test
	public void cuandoSeCreaUnaTarjeta(){
		//arrange
		Card card = new Card();
		card.setLabel("Tarjeta Visa Express");
		card.setCedula("1115069076");
		card.setMount(5000000);
		card.setBonus(0);
		
		Mockito.when(cardBean.create(card)).thenReturn(true);
		
		//act
		cardBusiness.createCard(card);
		
		//assert
		
		Mockito.verify(cardBean).create(card);
	}
	
	@Test
	public void cuandoSeEliminaUnaTarjeta(){
		//arrange
		Card card = new Card();
		card.setId(1);
		
		Mockito.when(cardBean.delete(card)).thenReturn(true);
		
		//act
		cardBusiness.deleteCard(card);
		
		//assert
		Mockito.verify(cardBean).delete(card);
	}
	

}