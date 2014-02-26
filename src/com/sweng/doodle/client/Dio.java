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
		new CopyOfgestioneasydata(pannello);
//		new Sondaggio(pannello);
//		new GestioneEventi(pannello);
		
		
		pannello.getElement().setAttribute("align", "center");
		RootPanel.get().add(pannello);
		
		
	
}
}
