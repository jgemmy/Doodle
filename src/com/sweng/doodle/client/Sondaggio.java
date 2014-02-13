package com.sweng.doodle.client;

import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;


public class Sondaggio  {
	
	VerticalPanel panel = new VerticalPanel();
	ListGrid countryGrid = new ListGrid(); 
	
	public Sondaggio(TabPanel pannello){
		 countryGrid.setWidth(500);  
	        countryGrid.setHeight(224);  
	        countryGrid.setShowAllRecords(true);  
	        countryGrid.setCanEdit(false);  
	        countryGrid.setEditEvent(ListGridEditEvent.CLICK);  
	        countryGrid.setModalEditing(false);  
	        ListGridField idField = new ListGridField("ID", "ID Evento");
	        ListGridField nameField = new ListGridField("Eventname", "Nome Evento");  
	        ListGridField placeField = new ListGridField("Place", "Luogo");  
	        ListGridField descrField = new ListGridField("Descrip", "Descrizione");  
	        ListGridField fromField = new ListGridField("from", "Dalle");  
	        ListGridField toField = new ListGridField("to", "alle");  
	        countryGrid.setFields(new ListGridField[] {idField, nameField, placeField, descrField, fromField, toField});  
	        countryGrid.setData(GridData.getRecords());  
		panel.add(countryGrid);
		
		pannello.add(panel, "Sondaggio");
	} 
	
	
	
	
	

}
