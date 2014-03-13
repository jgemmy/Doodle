package com.sweng.doodle.client;

import java.util.Date;
import java.util.LinkedList;

import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.sweng.doodle.shared.Evento;


public class CountrySampleData {  

	private static RecordList dataTable = new RecordList();
	public static RecordList getRecords(LinkedList<Evento> dataTable) {  
		return setEventi(dataTable);

	}    

	public static ListGridRecord createRecord(String id, String nome, String luogo, String descrizione, Date dal, Date al) {  
		ListGridRecord record = new ListGridRecord();  
		record.setAttribute("id", id);  
		record.setAttribute("nome", nome);  
		record.setAttribute("luogo", luogo);  
		record.setAttribute("descrizione", descrizione);  
		record.setAttribute("dal", dal);  
		record.setAttribute("al", al);    
		return record;  
	}  


	public static RecordList setEventi(LinkedList<Evento> eventi){
		for(int i = 0 ; i < eventi.size(); i++)
			dataTable.add(createRecord(eventi.get(i).getID(), eventi.get(i).getNome(), eventi.get(i).getLuogo(), eventi.get(i).getDesc(), eventi.get(i).getDal(), eventi.get(i).getAl()));
		return dataTable;
	}


}  

