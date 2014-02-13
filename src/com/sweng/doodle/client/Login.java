package com.sweng.doodle.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login implements ClickHandler{
	Button Login = new Button("Log in");

	public Login(TabPanel pannello){
		
		
		Label user= new Label("User:");
		Label passw = new Label("Password:");
		final TextBox tuser = new TextBox();
		final TextBox tpassw = new TextBox();
		VerticalPanel panel = new VerticalPanel();
		panel.add(user);		
		panel.add(tuser);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(passw);		
		panel.add(tpassw);		
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(Login);
		panel.getElement().setAttribute("align", "center");
		pannello.add(panel, "Log in");
		Login.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
					if ((event.getSource() == Login) && 
					   !(tuser.getText().length() == 0) &&
					   !(tpassw.getText().length() == 0)) 
//						chiamata server
						Window.alert("Accesso Eseguito");
						Dio.pannello.selectTab(2);
						if ((event.getSource() == Login) && 
								   (tuser.getText().length() == 0) ||
								   (tpassw.getText().length() == 0)) 
//									chiamata server
									Window.alert("username e/o password errati");
									Dio.pannello.selectTab(0);
					}
		
		});
		
		
		
		
		
		

	}

	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}


	}
	


