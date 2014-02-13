package com.sweng.doodle.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;


public class GestioneEventi implements ClickHandler{
	Label nome= new Label("Nome Evento");
	Label luogo= new Label("Luogo:");
	Label descs = new Label("Descrizione:");
	Label fromtext = new Label("Dal:");
	Label to= new Label("al:");
	TextBox tnome = new TextBox();
	TextBox tluogo = new TextBox();
	TextBox tdescs = new TextBox();
	final TextBox tfrom = new TextBox();           
	final TextBox tto = new TextBox();
	final DatePicker dfrom = new DatePicker();
	final DatePicker dto = new DatePicker();
	Button carica = new Button("Carica Evento");
	
	
	
	public GestioneEventi(TabPanel pannello){
		VerticalPanel panel = new VerticalPanel();
		panel.setSize("100px", "100px");
		panel.add(nome);
		panel.add(tnome);
		panel.add(luogo);
		panel.add(tluogo);
		panel.add(descs);
		panel.add(tdescs);
		panel.add(fromtext);
		panel.add(tfrom);
		panel.add(dfrom);
		panel.add(to);
		panel.add(tto);
		panel.add(dto);
		panel.add(carica);
		
	
		dfrom.addValueChangeHandler(new ValueChangeHandler<Date>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
			tfrom.setText(event.getValue().toString());	
					
			}
		
		});
		dto.addValueChangeHandler(new ValueChangeHandler<Date>() {
						
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				tto.setText(event.getValue().toString());
				
			}
		});
		
		
		panel.getElement().setAttribute("align", "center");
		pannello.add(panel, "gestione");
		
	}


	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		if (!((tnome.getText().length() == 0)) && 
		   (tluogo.getText().length() == 0) ||
		   (tdescs.getText().length() == 0) ||
		   (tfrom.getText().length() == 0) ||
		   (tto.getText().length() == 0)) {
			Window.alert("Inserisci tutti i campi");
			return;
		}
		
	}
	
}


