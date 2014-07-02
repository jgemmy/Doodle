package com.sweng.doodle.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.Date;
import java.util.LinkedList;

import com.sweng.doodle.server.GreetingServiceImpl;
import com.sweng.doodle.shared.Commento;
import com.sweng.doodle.shared.Evento;


public class JUnitTest {
	String id1;
	String id2;
	String id3;
	int idevento1;
	int idevento2;
	int idevento3;
	String idCommento1;
	String idCommento2;
	String idCommento3;
	@org.junit.Test
	public void JUnitTest() {
		GreetingServiceImpl test = new GreetingServiceImpl();
		testRegistrazione(test);
		testLogin(test);	
		testCreaevento(test);
		testeventi(test);
		test_ggiungi_commento(test);
		cleanDatabase(test);
		/*Testing returned id always primary key*/


	}
	public void testRegistrazione(GreetingServiceImpl test){
		id1 = test.registrazione("Giovanni", "Ricucci", "passw1", "abc@live.me");
		id2 = test.registrazione("Giovanni", "Ascenzo", "passw2", "def@live.me");
		id3 = test.registrazione("Giovanni", "Agnelli", "passw3", "ghi@live.me");
		//Successo
		//mi aspetto che la procedura vada a buon fine (iscrizione tre utenti)
		assertNotSame(id1, id2);
		assertNotSame(id2, id3);
		assertNotSame(id1, id3);
		String id4 = test.registrazione("Giovanni", "Ricucci", "passw1", "abc@live.me");
		String id5 = test.registrazione("Giovanni", "Ricucci", "passw2", "def@live.me");
		String id6 = test.registrazione("Giovanni", "Agnelli", "passw3", "ghi@live.me");
		//Fallimento
		//mi aspetto l'utente id5 registrato in precedenza (id4)
		assertSame(id4, id5);
		assertSame(id5, id6);
		assertSame(id4, id6);
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
		//mi aspetto un id uguale per gli utenti id4 e id5 (stesso) che si loggano
		assertSame(id4, id5);
	}

	public void testCreaevento(GreetingServiceImpl test){
		idevento1 = Integer.parseInt(test.caricaevento("evento1", "luogo1", "descs1", "Sun Mar 09 00:00:00 CET 2014", "Sun Mar 09 00:00:00 CET 2014", "1", 1, " "));
		idevento2 = Integer.parseInt(test.caricaevento("evento1", "luogo2", "descs2", "Sun Mar 09 00:00:00 CET 2014", "Sun Mar 09 00:00:00 CET 2014", "2", 1, ""));
		idevento3 = Integer.parseInt(test.caricaevento("evento1", "luogo3", "descs3", "Sun Mar 09 00:00:00 CET 2014", "Sun Mar 09 00:00:00 CET 2014", "3", 1, ""));
		//Successo
		//mi aspetto un id diverso per ogni evento caricato dall utente/amministratore, 
		assertNotSame(idevento1, idevento2);
		assertNotSame(idevento2, idevento3);
		assertNotSame(idevento1, idevento3);
	
	}


	public void testeventi(GreetingServiceImpl test){
		LinkedList<Evento> id1 = test.getAllUserEvents("1");
		assertEquals(true, !id1.isEmpty());
		//mi aspetto una lista non vuota per l'utente id1
		LinkedList<Evento> id2 = test.getAllUserEvents("-1");
		assertEquals(true, id2.isEmpty());
		//mi aspetto una lista vuota per l'utente id-1
	}

	public void test_ggiungi_commento(GreetingServiceImpl test){
		idCommento1 = test.insertcomm(""+idevento1, "commento1", ""+new Date(),""+id1);
		idCommento2 = test.insertcomm(""+idevento2, "commento2", ""+new Date(),""+id2);
		idCommento3 = test.insertcomm(""+idevento3, "commento3", ""+new Date(),""+id3);
	}

//	public void testcommenti(GreetingServiceImpl test){
//		LinkedList<Commento> id1 = test.getAllCommenti(id1);
//		assertEquals(true, !id1.isEmpty());
//		mi aspetto una lista di commenti non vuota per l'utente id 1
//		LinkedList<Evento> id2 = test.getAllUserEvents("-1");
//	assertEquals(true, id2.isEmpty());
//		mi aspetto una lista vuota per l'utente id -1
//	}

	public void cleanDatabase(GreetingServiceImpl test){


		rimuoviEvento(test);
		rimuoviCommenti(test);
		rimuoviUtenti(test);
	}

	public void rimuoviEvento(GreetingServiceImpl test)
	{
		test.rimuoviEvento(""+idevento1);
		test.rimuoviEvento(""+idevento2);
		test.rimuoviEvento(""+idevento3);
	}

	public void rimuoviCommenti(GreetingServiceImpl test)
	{
		test.rimuoviCommento(""+id1);
		test.rimuoviCommento(""+id2);
		test.rimuoviCommento(""+id3);
	}
	public void rimuoviUtenti(GreetingServiceImpl test)
	{
		test.rimuoviUtente(""+id1);
		test.rimuoviUtente(""+id2);
		test.rimuoviUtente(""+id3);
	}
}
