package com.sweng.doodle.client;

import java.util.LinkedList;

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
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.sweng.doodle.shared.Evento;
import com.sweng.doodle.shared.User;

public class UserSondaggio {
	Button delete = new Button("Cancella Evento");
	Label lcause = new Label("Inserire cause chiusura evento :");
	Label lusers = new Label("Lista utenti inscritti all evento: ");
	TextBox tcause = new TextBox();
	Button close = new Button("Chiudi Evento");
	ListGrid countryGrid = new ListGrid(); 
	ListGrid userGrid = new ListGrid(); 
	Label info = new Label("Doppio click sull evento per visualizzare le info: ");
	String idclick;
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	//	public static LinkedList<Evento> evento ;
	//	CellTable<Evento> table = new CellTable<Evento>();

	public UserSondaggio(final TabPanel pannello){				
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
		
		


		pannello.add(panel, "Amministrativo Eventi");
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
		ListGridField checkField = new ListGridField("check", "Aperto/Chiuso");
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
		countryGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {

			@SuppressWarnings("deprecation")
			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				// TODO Auto-generated method stub
				ListGridRecord record = (ListGridRecord)event.getRecord(); 
				detailViewer.setData(countryGrid.getSelection());
				idclick = record.getAttribute("id");
				inListJoiners();
				if (record.getAttribute("check").contentEquals("chiuso")){
					Window.alert("Evento Chiuso");}
				else {
					panel.add(lusers);
					panel.add(userGrid);
					panel.add(lcause);
					panel.add(tcause);
					panel.add(close);
					panel.add(delete);	
					
				}	
				
			}
		});
		
		
		
		
		greetingService.getAllUserEvents(Doodle_Main.idKey,new AsyncCallback<LinkedList<Evento>>() {

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

		panel.setSpacing(20);
		panel.add(countryGrid);
		panel.add(info);
		panel.add(detailViewer);
	

		close.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (event.getSource() == close)   
					inchiudievento();
			}
		});

		delete.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (event.getSource() == delete)  
					incancellaevento();

			}
		});

	}

	public void incancellaevento(){
		greetingService.cancellaevento(idclick, Cookies.getCookie("MyCookies"),  new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Window.alert("Evento Cancellato: "
						+ result);
				Window.Location.reload();
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Evento non Cancellato");

			}
		});
	}

	public void inchiudievento(){
		greetingService.chiudievento(idclick, Cookies.getCookie("MyCookies"),  new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stubs
				if (result.contentEquals("evento gia chiuso"))
					Window.alert("Evento gia chiuso in precendenza");
				else {
					Window.alert("Evento Chiuso: "+ result);
					Window.Location.reload();
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Evento non Chiuso");

			}
		});
	}

	public void inListJoiners(){
		greetingService.getAllUsersJoin(idclick, new AsyncCallback<LinkedList<User>>() {
			
			@Override
			public void onSuccess(LinkedList<User> result) {
				// TODO Auto-generated method stub
				System.out.println(result);
				userGrid.setData(UserGridData.getRecords(result));
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Can't load");
			}
		});


	}
}



