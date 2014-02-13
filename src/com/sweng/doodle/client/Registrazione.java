package com.sweng.doodle.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Registrazione extends Composite implements ClickHandler{
	Button singup = new Button("Sing Up");
	Label nome= new Label("Nome:");
	Label nick= new Label("Nickname:");
	Label passw= new Label("Password:");
	Label rpassw= new Label("Ripeti Password:");
	Label mail = new Label("Indirizzo mail:");
	final TextBox tnome = new TextBox();
	final TextBox tnick = new TextBox();
	final TextBox tpassw = new TextBox();
	final TextBox trpassw = new TextBox();
	final TextBox tmail = new TextBox();
	VerticalPanel panel = new VerticalPanel();
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	
public Registrazione(TabPanel pannello) {
	
	panel.add(nome);
	panel.add(tnome);
	panel.add(nick);
	panel.add(tnick);
	panel.add(passw);
	panel.add(tpassw);
	panel.add(rpassw);
	panel.add(trpassw);
	panel.add(mail);
	panel.add(tmail);
	panel.add(singup);
	singup.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			if (((event.getSource() == singup)) && 
			   (tnome.getText().length() == 0) &&
			   (tnick.getText().length() == 0) &&
			   (tpassw.getText().length() == 0) &&
			   (trpassw.getText().length() == 0) &&
			   !(tpassw.getText().contentEquals(trpassw.getText())) &&
			   (tmail.getText().length() == 0)) return; 
//     		 	GreetingService.Registrazione(tnome.getText(),tnick.getText(),tpassw.getText(), tmail.getText(), new AsyncCallback<String>(){

//					@Override
//					public void onFailure(Throwable caught) {
//						 TODO Auto-generated method stub
//					Window.alert("Procedura Remota Fallita");
//					}
//
//					@Override
//					public void onSuccess(String result) {
//						 TODO Auto-generated method stub
//						Window.alert("Registrazione Effettuata");
//					}
				
				
			
		}
		
	});
	panel.getElement().setAttribute("align", "center");
	pannello.add(panel, "Registrazione");
     
	
}


@Override
public void onClick(ClickEvent event) {
	// TODO Auto-generated method stub
	
}
}	





	


	

	




