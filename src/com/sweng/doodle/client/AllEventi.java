package com.sweng.doodle.client;

import java.util.LinkedList;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.sweng.doodle.shared.Evento;

public class AllEventi {

	ListGrid countryGrid = new ListGrid();  
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);


	Label id = new Label("ID Evento:");
	TextBox tid = new TextBox();
	Label name = new Label("Nome:");
	TextBox tname = new TextBox();

	public AllEventi(final TabPanel pannello){
		final DynamicForm form = new DynamicForm();  
		form.setWidth(250);  
		form.setTitleOrientation(TitleOrientation.TOP);  
		final RadioGroupItem radioGroupItem = new RadioGroupItem();    
		radioGroupItem.setColSpan("*");  
		radioGroupItem.setRequired(true);  
		radioGroupItem.setVertical(false);  
		radioGroupItem.setValueMap("Yes", "No");  
		radioGroupItem.setRedrawOnChange(true);  
		radioGroupItem.setTitle("Indiacare Disponibilita");
		
		final DetailViewer detailViewer = new DetailViewer();  
		detailViewer.setWidth(500);  
		detailViewer.setTop(250);  
		detailViewer.setFields(  
				new DetailViewerField("id", "ID"),  
				new DetailViewerField("nome", "Nome Evento"),  
				new DetailViewerField("luogo", "Luogo"),
				new DetailViewerField("descrizione", "Descrizione"),
				new DetailViewerField("dal", "Dal"),
				new DetailViewerField("al", "Al"),
				new DetailViewerField("check", "Stato"));  

		detailViewer.setEmptyMessage("Click a row in the grid");  
		form.setFields(radioGroupItem);

		VerticalPanel panel = new VerticalPanel();
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
		countryGrid.setFields(new ListGridField[] {idField, nameField, placeField, descrField, fromField, toField,checkField}); 
		countryGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {

			@SuppressWarnings("deprecation")
			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				// TODO Auto-generated method stub
				ListGridRecord record = (ListGridRecord)event.getRecord(); 
				tid.setValue(record.getAttribute("id"));
				detailViewer.setData(countryGrid.getSelection());

			}
		});
		inGetAllEvents();
		panel.add(countryGrid);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(id);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(tid);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(name);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(tname);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(detailViewer);
		panel.add(form);
		pannello.add(panel, "Eventi");
	}

	public void inGetAllEvents(){
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
	}
}
