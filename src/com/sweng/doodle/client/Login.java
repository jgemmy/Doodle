package com.sweng.doodle.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login implements ClickHandler{
	Button Login = new Button("Log in");

	public Login(TabPanel pannello){
		
		
		Label user= new Label("User:");
		Label passw = new Label("Password:");
		TextBox users = new TextBox();
		TextBox passws = new TextBox();
		VerticalPanel panel = new VerticalPanel();
		panel.add(user);
		panel.add(users);
		panel.add(passw);
		panel.add(passws);		
		panel.add(Login);
		Login.addClickHandler(this);
		pannello.add(panel, "Log in");
		
		

	}

	@Override
	public void onClick(ClickEvent event) {
		if(event.getSource() == Login){
			Window.alert("Accesso Eseguito");
			Dio.pannello.selectTab(2);
		}
		
	}
	

}
