package co.com.techandsolve.creditcard.business;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.creditcard.entities.Bill;

@RunWith(MockitoJUnitRunner.class)
public class BillBusinessTest {
	
	@Mock QueueConnectionFactory queueConnectionFactory;
	@Mock Queue queue;
	@Mock Connection connection;
	@Mock Session session;
	@Mock MessageProducer messageProducer;
	@Mock ObjectMessage objectMessage;
	
	@InjectMocks BillBusiness billBusinnes;
	
	Bill bill;
	
	@Before
	public void setUp(){
		bill = new Bill("Cuenta de cobro", "valor por prestaciones", 500000);
	}
	
	@Test 
	public void debeEnviarUnMensaje() throws JMSException{
		
		Mockito.when(queueConnectionFactory.createConnection())
		.thenReturn(connection);
		
		Mockito.when(connection.createSession(false, Session.AUTO_ACKNOWLEDGE))
		.thenReturn(session);
		
		Mockito.when(session.createProducer(queue))
		.thenReturn(messageProducer);
		
		Mockito.when(session.createObjectMessage())
		.thenReturn(objectMessage);
		
		billBusinnes.sendMessage(bill);
		
		Mockito.verify(queueConnectionFactory).createConnection();
		Mockito.verify(connection).createSession(false, Session.AUTO_ACKNOWLEDGE);
		Mockito.verify(session).createProducer(queue);
		Mockito.verify(session).createObjectMessage();
		Mockito.verify(messageProducer).send(objectMessage);
		Mockito.verify(connection).close();;


	}
	
	

}
