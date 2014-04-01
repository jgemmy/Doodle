package com.sweng.doodle.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Doodle_Main extends Composite{
	HorizontalPanel hPanel = new HorizontalPanel();
	public static String idKey="";
	final Button logout = new Button("Log Out");
	Button Login = new Button("Login");
	Button Registrazione = new Button("Registrazione");
	static TabPanel pannello = new TabPanel();
	TabPanel tab = new TabPanel();
	TabPanel log = new TabPanel();
	TabPanel reg = new TabPanel();

static VerticalPanel panta = new VerticalPanel();

	public Doodle_Main(){

		pannello.setAnimationEnabled(true);  
		if (!(Cookies.getCookie("MyCookies").contentEquals("-1"))){
			//			Window.alert("Welcome user with id: "+Cookies.getCookie("MyCookies"));
			idKey = Cookies.getCookie("MyCookies");
			new IMieiEventi(pannello);
			new TuttiGliEventi(pannello);
			pannello.getElement().setAttribute("align", "center");			
			new CreaEventi(tab);
			panta.add(logout);
			
			hPanel.add(panta);
panta.setSpacing(10);
			hPanel.add(new HTML("<br />"));
			hPanel.add(new HTML("<br />"));
			hPanel.add(new HTML("<br />"));
			hPanel.add(pannello);
			hPanel.getElement().setAttribute("align", "left");
			panta.getElement().setAttribute("align", "left");
			hPanel.setSpacing(35);
			hPanel.add(tab);
			tab.selectTab(0);
			tab.addStyleName("tabKey");
			RootPanel.get().add(hPanel);
		} else {
			new TuttiGliEventiAnonimo(pannello);
			new Login(log);
			new Registrazione(reg);
			hPanel.add(log);
			log.selectTab(0);
			hPanel.add(pannello);
			hPanel.add(reg);
			reg.selectTab(0);
			hPanel.setSpacing(30);
			RootPanel.get().add(hPanel);
			pannello.selectTab(0);	

		}


pannello.addSelectionHandler(new SelectionHandler<Integer>() {
	  @Override
	  public void onSelection(SelectionEvent<Integer> event) {
	    if (event.getSelectedItem() == 0) {
	    	if(panta.getWidgetCount() >=2){	
	    		panta.remove(1);
	    	}
	    }
	  }
	});


		logout.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Cookies.setCookie("MyCookies","-1");
				Window.Location.reload();
				Window.alert("Logout Eseguito");

			}
		});


	}
}


