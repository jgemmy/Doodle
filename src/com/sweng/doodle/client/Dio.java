package com.sweng.doodle.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class Dio extends Composite{
	
	Button Login = new Button("Login");
	Button Registrazione = new Button("Registrazione");
	static TabPanel pannello = new TabPanel();
	
	public Dio(){
		new Login(pannello);
		new Registrazione(pannello);
		new GestioneEventi(pannello);
		new Sondaggio(pannello);
		
		pannello.getElement().setAttribute("align", "center");
		RootPanel.get().add(pannello);
		
		
	
}
}
//panel.add(new HTML("<text>Inserisci ID Cliente:</text>"));