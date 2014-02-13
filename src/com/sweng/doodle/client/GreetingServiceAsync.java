package com.sweng.doodle.client;



import java.sql.Date;
import java.util.LinkedList;

import com.smartgwt.client.bean.types.DateValueType;
import com.sweng.doodle.shared.Utils;
import com.google.appengine.datanucleus.query.DatastoreQuery.NowProvider;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
//	void login(String nome, String passw, new AsyncCallback<String> callback) throws IllegalArgumentException;
//	void registazione(String nome, String nick, String passw, String mail, new AsyncCallback<String> callback) throws IllegalArgumentException;
//	void caricaevento(String nome, String luogo, String descs,Date dal,Date al,int dalle,int alle,new AsyncCallback<String> callback) throws IllegalArgumentException;
//	void sondaggio(String nome,String luogo,String descs,Date from,Date to,int dore, int aore,new AsyncCallback<String> callback) throws IllegalArgumentException;
}  
