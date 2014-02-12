package com.sweng.doodle.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Registrazione implements ClickHandler{
	Button singup = new Button("Sing Up");

public Registrazione(TabPanel pannello) {
	
	Label nome= new Label("Nome:");
	Label nick= new Label("Nickname:");
	Label passw= new Label("Password:");
	Label mail = new Label("Indirizzo mail:");
	TextBox tnome = new TextBox();
	TextBox tnick = new TextBox();
	TextBox tpassw = new TextBox();
	TextBox tmail = new TextBox();
	VerticalPanel panel = new VerticalPanel();
	panel.add(nome);
	panel.add(tnome);
	panel.add(nick);
	panel.add(tnick);
	panel.add(passw);
	panel.add(tpassw);
	panel.add(mail);
	panel.add(tmail);
	panel.add(singup);
	singup.addClickHandler(this);
	panel.getElement().setAttribute("align", "center");
	pannello.add(panel, "Registrazione");
	
	}

@Override
public void onClick(ClickEvent event) {
	// TODO Auto-generated method stub
	if (event.getSource()== singup){
		Window.alert("Registazione Effettuata");
		Dio.pannello.selectTab(2);
	}
}
}


