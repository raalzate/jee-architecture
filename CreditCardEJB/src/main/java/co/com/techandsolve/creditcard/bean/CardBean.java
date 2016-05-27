package co.com.techandsolve.creditcard.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import co.com.techandsolve.creditcard.entities.Card;

@Stateless
public class CardBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Card> getCardByCC(String cedulaCliente) {
		
		TypedQuery<Card> query= entityManager
				.createQuery("Select p From Card p Where p.cedula = :cedula", Card.class);
		
	    query.setParameter("cedula", cedulaCliente);
	   
		return query.getResultList();
		
	}


	public List<Card> addBonus(String cedula, double bonus) {
		TypedQuery<Card> query= entityManager
				.createQuery("Update Card set bonus = :bonus Where p.cedula = :cedula And mount > 1000000", Card.class);
		
	    query.setParameter("cedula", cedula);
	    query.setParameter("bonus", bonus);

		return query.getResultList();
	}


	
	

}
