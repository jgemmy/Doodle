package com.sweng.doodle.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.LinkedList;

import com.sweng.doodle.server.GreetingServiceImpl;
import com.sweng.doodle.server.QueryMethods;
import com.sweng.doodle.shared.Commento;
import com.sweng.doodle.shared.Evento;


public class JUnitTest {


	@org.junit.Test
	public void JUnitTest() {
		GreetingServiceImpl test = new GreetingServiceImpl();
		testRegistrazione(test);
		testLogin(test);	
//		testCreaevento(test);
		testeventi(test);
		testcommenti(test);

		/*Testing returned id always primary key*/


	}
	public void testRegistrazione(GreetingServiceImpl test){
		String id1 = test.registrazione("Giovanni", "Ricucci", "passw1", "abc@live.me");
		String id2 = test.registrazione("Giovanni", "Ascenzo", "passw2", "def@live.me");
		String id3 = test.registrazione("Giovanni", "Agnelli", "passw3", "ghi@live.me");
		//mi aspetto un utente già registrato quindi mi aspetto la stessa stringa di errore
		assertSame(id1, id2);
		assertSame(id2, id3);
		assertSame(id1, id3);
	}	

	public void testLogin(GreetingServiceImpl test){
		int id1 = Integer.parseInt(test.login("Ricucci", "passw1"));
		int id2 = Integer.parseInt(test.login("Ascenzo", "passw2"));
		int id3 = Integer.parseInt(test.login("Agnelli", "passw3"));
		assertNotSame(id1, id2);
		assertNotSame(id2, id3);
		assertNotSame(id1, id3);
		//Successo
		//mi aspetto un id diverso per ogni utente registrato che si logga, 
		//poiche corrisponde all sua primary key 

		int id4 = Integer.parseInt(test.login("Ricucci", "passw1"));
		int id5 = Integer.parseInt(test.login("Ricucci", "passw1"));
		//Falliento
		//mi aspetto un id uguale per id 4 e id 5
		assertSame(id4, id5);
	}

	public void testCreaevento(GreetingServiceImpl test){
		int id1 = Integer.parseInt(test.caricaevento("evento1", "luogo1", "descs1", "Sun Mar 09 00:00:00 CET 2014", "Sun Mar 09 00:00:00 CET 2014", "1", 1, " "));
		int id2 = Integer.parseInt(test.caricaevento("evento1", "luogo2", "descs2", "Sun Mar 09 00:00:00 CET 2014", "Sun Mar 09 00:00:00 CET 2014", "1", 1, ""));
		int id3 = Integer.parseInt(test.caricaevento("evento1", "luogo3", "descs3", "Sun Mar 09 00:00:00 CET 2014", "Sun Mar 09 00:00:00 CET 2014", "1", 1, ""));
		//mi aspetto un id diverso per ogni evento caricato dall utente/amministratore, 
		//poiche ogni evento e' gestito tramite il suo id 
		assertNotSame(id1, id2);
		assertNotSame(id2, id3);
		assertNotSame(id1, id3);

	}



	public void testeventi(GreetingServiceImpl test){
		LinkedList<Evento> id1 = test.getAllUserEvents("1");
		assertEquals(true, !id1.isEmpty());
		//mi aspetto una lista non vuota per l'utente id 1
		LinkedList<Evento> id2 = test.getAllUserEvents("-1");
		assertEquals(true, id2.isEmpty());
		//mi aspetto una lista vuota per l'utente id -1
	}

	public void testcommenti(GreetingServiceImpl test){
		LinkedList<Commento> id1 = test.getAllCommenti("1");
		assertEquals(true, !id1.isEmpty());
		//mi aspetto una lista di commenti non vuota per l'utente id 1
		LinkedList<Evento> id2 = test.getAllUserEvents("-1");
		assertEquals(true, id2.isEmpty());
		//mi aspetto una lista vuota per l'utente id -1
	}


}
