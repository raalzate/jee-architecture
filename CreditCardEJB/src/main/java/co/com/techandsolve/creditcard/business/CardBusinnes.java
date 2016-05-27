package co.com.techandsolve.creditcard.business;

import java.util.List;

import javax.inject.Inject;

import co.com.techandsolve.creditcard.bean.CardBean;
import co.com.techandsolve.creditcard.entities.Card;
import co.com.techandsolve.creditcard.exception.LockedException;

/*
 * Propiedades: Numero_tarjeta, Id_cliente, Bonificacion, Monto, Estado, Fecha-Corte
 * 
 * Las bonificaciones se manejan de la siguiente manera: 
 * 
 * Cuando tenga mas de 1 millon en el monto de las tarjetas añadir 20000 de 
 * bonificación para cada tarjeta
 * 
 * Cuando sea de 700 mill a 1 millon añadir 10000 de bonificación para cada tarjeta, 
 * 
 * Siempre que el cliente tenga bonificación en por lo menos una tarjeta no se puede añadir bonificación.
 * 
 * 
 * Cuando la tarjeta este bloqueada enviar un mensaje al usuario diciendo 
 * que tiene tarjeta bloqueada
 */
public class CardBusinnes {

	private static final double SUM_MOUNT_1MLL = 1000000;
	private static final double SUM_MOUNT_700M = 700000;
	private static final double MOUNT_10M = 10000;
	private static final double MOUNT_20M = 20000;

	
	@Inject
	private CardBean cardBean;


	public List<Card> addBonusAndValidateUser(String cedula) throws LockedException{
		List<Card> listCard = cardBean.getCardByCC(cedula);
		
		double sumMount = 0;
		boolean hasBonus = false;
		boolean hasLocked = false;
		
		for(Card card : listCard) {
			sumMount += card.getMount();
			hasBonus |= card.getBonus() > 0;
			hasLocked  |= card.getStatus() ==1;
		}
		
		if(hasLocked) {
			throw new LockedException("locked card");
		}
		
		if(!hasBonus) {
			validSumMountAndAddBonus(sumMount, listCard);
		}
		
		return listCard;
	}
	

	
	private void validSumMountAndAddBonus(double sumMount, List<Card> listCard){
		if(sumMount > SUM_MOUNT_1MLL) {
			addBonus(listCard,MOUNT_20M);
		} else
		if(sumMount <= SUM_MOUNT_1MLL && sumMount >= SUM_MOUNT_700M) {
			addBonus(listCard,MOUNT_10M);
		}
	}
	
	private void addBonus(List<Card> listCard, double bonus){
		for(int i = 0; i< listCard.size(); i++) {
			listCard.get(i).setBonus(bonus);
		}
	}



	public boolean createCard(Card card) {
		return cardBean.create(card);
	}



	public boolean deleteCard(Card card) {
		return cardBean.delete(card);
		
	}
	
	
}
