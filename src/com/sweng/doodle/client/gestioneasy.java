package com.sweng.doodle.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sweng.doodle.shared.Utils;


public class gestioneasy implements ClickHandler{
	Label nome= new Label("Nome Evento");
	Label luogo= new Label("Luogo:");
	Label descs = new Label("Descrizione:");
	Label from = new Label("Dal:");
	Label to= new Label("Al:");
	Label dore = new Label("Dalle ore:");
	Label aore= new Label("Alle ore:");
	TextBox tnome = new TextBox();
	TextBox tluogo = new TextBox();
	TextBox tdescs = new TextBox();
	TextBox tfrom = new TextBox();           
	TextBox tto = new TextBox();
	TextBox tdore = new TextBox();           
	TextBox taore = new TextBox();
	Button carica = new Button("Carica Evento");
	
	
	
	public gestioneasy(TabPanel pannello){
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
		panel.add(dore);
		panel.add(tdore);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(aore);
		panel.add(taore);
		panel.add(new HTML("<text> <br> </text>"));
		panel.add(carica);
		
		
	
		
		
		
//		panel.getElement().setAttribute("align", "center");
		pannello.add(panel, "Gestioneasy");
		
	}



	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		String snome,sluogo,sdescs;
		int ifrom,ito,idore,iaore;
		if (!((tnome.getText().length() == 0)) && (!(Utils.isStringNumeric(tnome.getText())))) 
			snome = new String(tnome.getText());
		if (!((tluogo.getText().length() == 0)) && (!(Utils.isStringNumeric(tluogo.getText())))) 
			sluogo = new String(tluogo.getText());
		if (!((tdescs.getText().length() == 0)) && (!(Utils.isStringNumeric(tdescs.getText())))) 
			sdescs = new String(tdescs.getText());
		if (!((tfrom.getText().length() == 0)) && ((Utils.isStringNumeric(tfrom.getText())))) 
			ifrom = new Integer(tnome.getText());
		if (!((tto.getText().length() == 0)) && (!(Utils.isStringNumeric(tto.getText())))) 
			ito = new Integer (tto.getText());
		if (!((tdore.getText().length() == 0)) && (!(Utils.isStringNumeric(tdore.getText())))) 
			idore = new Integer (tdore.getText());
		if (!((taore.getText().length() == 0)) && (!(Utils.isStringNumeric(taore.getText())))) 
			iaore = new Integer (taore.getText());
//		GreetingService.sondaggio(snome, sluogo, sdescs, ifrom, ito, idore, iaore){}
	}


}