package com.sweng.doodle.client;

import java.util.LinkedList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.sweng.doodle.shared.Evento;

public class AllEventi {

	ListGrid countryGrid = new ListGrid();  
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public AllEventi(final TabPanel pannello){

		VerticalPanel panel = new VerticalPanel();
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
		ListGridField checkField = new ListGridField("check", "Stato");
		countryGrid.setFields(new ListGridField[] {idField, nameField, placeField, descrField, fromField, toField,checkField});  
		greetingService.getAllEvents(new AsyncCallback<LinkedList<Evento>>() {
			
			@Override
			public void onSuccess(LinkedList<Evento> result) {
				// TODO Auto-generated method stub
				countryGrid.setData(CountrySampleData.getRecords(result));
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Procedura Fallita");
			}
		});
		panel.add(countryGrid);
		pannello.add(panel, "Eventi");
	}

}
