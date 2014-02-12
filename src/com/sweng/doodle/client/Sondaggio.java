package com.sweng.doodle.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;


public class Sondaggio  {
	
	Label idevento = new Label("ID EVENTO");
	TextBox tid = new TextBox();
	VerticalPanel panel = new VerticalPanel();
	ListGrid countryGrid = new ListGrid(); 
	
	public Sondaggio(TabPanel pannello){
		 countryGrid.setWidth(500);  
	        countryGrid.setHeight(224);  
	        countryGrid.setShowAllRecords(true);  
	        countryGrid.setCanEdit(false);  
	        countryGrid.setEditEvent(ListGridEditEvent.CLICK);  
	        countryGrid.setModalEditing(false);  
	        ListGridField nameField = new ListGridField("countryName", "Country");  
	        ListGridField capitalField = new ListGridField("capital", "Capital");  
	        ListGridField continentField = new ListGridField("continent", "Continent");  
	        countryGrid.setFields(new ListGridField[] {nameField, capitalField, continentField});  
	        countryGrid.setData(GridData.getRecords());  
		panel.add(countryGrid);
		panel.add(idevento);
		panel.add(tid);
	
		
		pannello.add(panel, "Sondaggio");
	} 
	
	
	
	
	

}
