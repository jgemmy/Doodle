package com.sweng.doodle.client;

import java.util.LinkedList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.sweng.doodle.shared.Evento;

public class UserSondaggio {
	Button delete = new Button("Cancella Evento");
	Label id = new Label("Inserire evento ID da cancellare");
	TextBox idd = new TextBox();
	Button close = new Button("Chiudi Evento");
	Label id1 = new Label("Inserire evento ID da chiudere");
	TextBox tid = new TextBox();
	ListGrid countryGrid = new ListGrid(); 
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	//	public static LinkedList<Evento> evento ;
	//	CellTable<Evento> table = new CellTable<Evento>();

	public UserSondaggio(final TabPanel pannello){

		VerticalPanel panel = new VerticalPanel();
		panel.add(countryGrid);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(id);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(idd);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(delete);												//doppioclick
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(id1);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(tid);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(close);
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
		greetingService.getAllUserEvents(Dio.idKey,new AsyncCallback<LinkedList<Evento>>() {

			@Override
			public void onSuccess(LinkedList<Evento> result) {
				
				countryGrid.setData(CountrySampleData.getRecords(result));
				pannello.selectTab(0);
				Window.alert("Benvenuto nei tuoi eventi");


			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Procedura Fallita");
			}
		});





		delete.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String input = idd.getText();
				if (!input.matches("[0-9]*")) {
					Window.alert("Errore: inserire ID numerico");
					return;
				}
				if ((event.getSource() == delete) &&
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



