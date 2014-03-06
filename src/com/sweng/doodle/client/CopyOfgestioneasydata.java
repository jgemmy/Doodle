package com.sweng.doodle.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.sweng.doodle.shared.Utils;


public class CopyOfgestioneasydata {
	Label nome= new Label("Nome Evento");
	Label luogo= new Label("Luogo:  (opzionale)");
	Label descs = new Label("Descrizione:  (opzionale)");
	Label from = new Label("Dal: , Dalle ore:");
	Label to= new Label("Al: , Alle ore:");

	
	TextBox tnome = new TextBox();
	TextBox tluogo = new TextBox();
	TextBox tdescs = new TextBox();
	DateBox tfrom = new DateBox();           
	DateBox tto = new DateBox();
	String snome = "empty";
	String sluogo= "empty";
	String sdescs= "empty";
	String ifrom = "empty";
	String ito = "empty";
	
	Button carica = new Button("Carica Evento");
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	
	
	public CopyOfgestioneasydata(TabPanel pannello){
		VerticalPanel panel = new VerticalPanel();
		panel.add(nome);
		panel.add(tnome);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(luogo);
		panel.add(tluogo);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(descs);
		panel.add(tdescs);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(from);
		panel.add(tfrom);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(to);
		panel.add(tto);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(carica);
		tto.setFormat(new DateBox.DefaultFormat 
				(DateTimeFormat.getFormat("EEEE,dd MMMM , yyyy"))); 
		tfrom.setFormat(new DateBox.DefaultFormat 
				(DateTimeFormat.getFormat("EEEE,dd MMMM , yyyy"))); 
//				(DateTimeFormat.getFormat("mm HH"))); 
	
	
		
		
		
//		panel.getElement().setAttribute("align", "center");
		pannello.add(panel, "Gestioneasy");
		carica.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				
				if (!((tnome.getText().length() == 0)) && (!(Utils.isStringNumeric(tnome.getText())))) 
					snome = new String(tnome.getText());
				if (!((tluogo.getText().length() == 0)) && (!(Utils.isStringNumeric(tluogo.getText())))) 
					sluogo = new String(tluogo.getText());
				if (!((tdescs.getText().length() == 0)) && (!(Utils.isStringNumeric(tdescs.getText())))) 
					sdescs = new String(tdescs.getText());
				if (!((tfrom.getValue().toString().length() == 0)))  
					ifrom = tfrom.getValue().toString();
				if (!((tto.getValue().toString().length() == 0))) 
					ito = tto.getValue().toString();
				inEvento();
			
			
			} 
			
		});
		
	}
	 public void inEvento(){
		 greetingService.caricaevento(snome, sluogo, sdescs, ifrom, ito,Dio.idKey, new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert("procedura remota fallita");
				}

				@Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
					Window.alert("Evento caricato con successo: id evento  = "+result);
				}
			});	
	 }
}



