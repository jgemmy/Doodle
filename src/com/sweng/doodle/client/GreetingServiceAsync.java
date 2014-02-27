package com.sweng.doodle.client;



import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
	void registrazione(String nome, String nick, String passw,String mail, AsyncCallback<String> callback) throws IllegalArgumentException;
	void login(String nome, String passw, AsyncCallback<String> callback) throws IllegalArgumentException;
	void caricaevento(String snome, String sluogo, String sdescs, String ifrom,	String ito,  AsyncCallback<String> callback);
}