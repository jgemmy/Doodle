package com.sweng.doodle.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class UserSondaggio {
	Button togli = new Button("togli");
	Label id = new Label("ID:");
	TextBox idd = new TextBox();
	ListGrid countryGrid = new ListGrid(); 
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);


	public UserSondaggio(TabPanel pannello){

		VerticalPanel panel = new VerticalPanel();
		panel.add(countryGrid);
		panel.add(id);
		panel.add(idd);
		panel.add(togli);
		pannello.add(panel, "Amministrativo Eventi");

		countryGrid.setWidth(500);  
		countryGrid.setHeight(224);  
		countryGrid.setShowAllRecords(true);  
		countryGrid.setCanEdit(false);  
		countryGrid.setEditEvent(ListGridEditEvent.CLICK);  
		countryGrid.setModalEditing(false);  
		ListGridField idField = new ListGridField("id", "ID");
		ListGridField nameField = new ListGridField("nome", "Nome Evento");  
		ListGridField placeField = new ListGridField("luogo", "Luogo");  
		ListGridField descrField = new ListGridField("descrizione", "Descrizione");  
		ListGridField fromField = new ListGridField("dal", "Dal");  
		ListGridField toField = new ListGridField("al", "Al");
		countryGrid.setFields(new ListGridField[] {idField, nameField, placeField, descrField, fromField, toField});  
		countryGrid.setData(GridData.getRecords()); 
		





		togli.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String input = idd.getText();
				if (!input.matches("[0-9]*")) {
					Window.alert("Errore: inserire ID numerico");
					return;
				}
				if ((event.getSource() == togli) &&
						(!(idd.getValue().length() == 0)))  
					greetingService.cancellaevento(idd.getText(), Cookies.getCookie("MyCookies"),  new AsyncCallback<String>() {

						@Override
						public void onSuccess(String result) {
							// TODO Auto-generated method stub
							Window.alert("Evento Cancellato: "
									+ result);
						}

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							Window.alert("Evento non Cancellato");
						}
					});


			}
		});

	}
}
