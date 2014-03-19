package com.sweng.doodle.client;

import java.util.LinkedList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.sweng.doodle.shared.Evento;
import com.sweng.doodle.shared.User;

public class AllEventi {
	String idevento ;
	String motivi ;
	

	ListGrid countryGrid = new ListGrid();  
	ListGrid userGrid = new ListGrid(); 
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	Label info = new Label("Doppio click sull evento per visualizzare le info: ");
	Label lnome = new Label("Nome:");
	Label lusers = new Label("Lista utenti inscritti all evento: ");
	Label lcomm = new Label("Inserire qui eventuali commenti:");

	Label disp = new Label("Disponibilita:");
	TextBox tnome = new TextBox();
	
	CheckBox yes = new CheckBox("Yes");
	CheckBox no = new CheckBox("No");
	TextBox commenti = new TextBox();
	Button salva = new Button("Salva");	




	public AllEventi(final TabPanel pannello){

		final DetailViewer detailViewer = new DetailViewer();  
		detailViewer.setWidth(500);  
		detailViewer.setFields(  
				new DetailViewerField("id", "ID"),  
				new DetailViewerField("nome", "Nome Evento"),  
				new DetailViewerField("luogo", "Luogo"),
				new DetailViewerField("descrizione", "Descrizione"),
				new DetailViewerField("dal", "Dal"),
				new DetailViewerField("al", "Al"),
				new DetailViewerField("check", "Stato"),
				new DetailViewerField("causechiuso", "Motivi")); 


		final VerticalPanel panel = new VerticalPanel();
		countryGrid.setWidth(700);  
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
		ListGridField causeField = new ListGridField("causechiuso", "Motivi");
		countryGrid.setFields(new ListGridField[] {idField, nameField, placeField, descrField, fromField, toField,checkField, causeField});
		userGrid.setWidth(224);  
		userGrid.setHeight(224);  
		userGrid.setShowAllRecords(true);  
		userGrid.setCanEdit(false);  
		userGrid.setEditEvent(ListGridEditEvent.CLICK);  
		userGrid.setModalEditing(false);  
		ListGridField nomeField = new ListGridField("nome", "Nome");
		userGrid.setFields(new ListGridField[] {nomeField});
		panel.setSpacing(20);
		countryGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {

			@SuppressWarnings("deprecation")
			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				// TODO Auto-generated method stub
				ListGridRecord record = (ListGridRecord)event.getRecord(); 
				detailViewer.setData(countryGrid.getSelection());
				idevento = record.getAttribute("id");
				motivi = record.getAttribute("causechiuso");
				//				tnome.setText(username);?????????????????????????????????????????????????????????????????????nnva
				inListJoiners();
				if (record.getAttribute("check").contentEquals("chiuso")){
					Window.alert("Evento Chiuso");}
				else{
					
					panel.add(userGrid);
					panel.add(lusers);
					panel.add(lnome);
					panel.add(tnome);
					panel.add(lcomm);
					panel.add(commenti);
					panel.add(disp);
					panel.add(yes);
					panel.add(no);
					panel.add(salva);
				}
				salva.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						if ((event.getSource() == salva) && (!(tnome.getText().length() == 0)) && (yes.isEnabled()))
							inInsertJoin();	
//						if ((event.getSource() == salva) && (!(tnome.getText().length() == 0)) && (no.isEnabled()))
//							inDeleteJoin();
					}
				});

			}
		});
		inGetAllEvents();
		panel.add(countryGrid);
		panel.add(info);
		panel.add(detailViewer);
		pannello.add(panel, "Eventi");


	}
	public void inInsertJoin(){
		greetingService.insertJoin(idevento, tnome.getText(), tnome.getText(), commenti.getText(), 1, new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Window.alert("Inscrizione: " + result);
				Window.Location.reload();
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Iscrizione fallita");
			}
		});


	}

	public void inDeleteJoin(){
		greetingService.deleteJoin(idevento, tnome.getText(), new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Window.alert("Disponibilita Rimossa");
				Window.Location.reload();
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Disponibilita non Rimossa");
			}
		});



	};
	public void inListJoiners(){
		greetingService.getAllUsersJoin(idevento, new AsyncCallback<LinkedList<User>>() {
			
			@Override
			public void onSuccess(LinkedList<User> result) {
				// TODO Auto-generated method stub
				System.out.println(result);
				userGrid.setData(UserGridData.getRecords(result));
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("UserGrid non creata");
			}
		});


		
		
		
	}

	public void inGetAllEvents(){
		greetingService.getAllEvents(new AsyncCallback<LinkedList<Evento>>() {

			@Override
			public void onSuccess(LinkedList<Evento> result) {
				countryGrid.setData(CountrySampleData.getRecords(result));
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Procedura Fallita");
			}
		});
	}
}
