package com.sweng.doodle.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	String registrazione(String nome, String nick, String password, String mail) throws IllegalArgumentException;
	String login(String nick, String passw) throws IllegalArgumentException;
	String caricaevento(String nome, String luogo, String descs,String dal,String al,int dalle,int alle) throws IllegalArgumentException;
}
