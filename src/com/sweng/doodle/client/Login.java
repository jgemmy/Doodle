package com.sweng.doodle.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login{
	VerticalPanel panel ;
	TabPanel pannello;
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	Button Login = new Button("Log in");
	public Login(final TabPanel pannello){
		this.pannello = pannello;
		final Button logout = new Button();
		Label user= new Label("User:");
		Label passw = new Label("Password:");
		final PasswordTextBox tuser = new PasswordTextBox();
		final PasswordTextBox tpassw = new PasswordTextBox();
		panel = new VerticalPanel();
		panel.add(user);		
		panel.add(tuser);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(passw);		
		panel.add(tpassw);		
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(Login);
		panel.getElement().setAttribute("align", "center");
		pannello.add(panel, "Log in");
		logout.setText("LOG OUT");
		RootPanel.get().add(logout);
		
		logout.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.Location.reload();
				
			}
		});
		Login.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
					if ((event.getSource() == Login) && 
					   !(tuser.getText().length() == 0) &&
					   !(tpassw.getText().length() == 0)) 
						greetingService.login(tuser.getText(), tpassw.getText(), new AsyncCallback<String>() {
							
							@Override
							public void onSuccess(String result) {
								// TODO Auto-generated method stub
								if(result.contentEquals("empty") ){

									Dio.pannello.selectTab(0);
									Window.alert("username e/o password errati");
								} else {
									Dio.pannello.selectTab(2);
									Window.alert("Benvenuto: " + result);
									loggato(result);
								}
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}
							
					
						
		});}
			});
		
	}
	
	public void loggato(String result){
		pannello.setVisible(true);
		pannello.remove(1);
		pannello.remove(0);
	}
	public void nonloggato(String result){
		pannello.remove(2);
	}
}
		
		
		
	
		



	
	


