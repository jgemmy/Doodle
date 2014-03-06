package com.sweng.doodle.client;

import java.util.Date;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class GridData {  

	private static ListGridRecord[] records;    

	public static ListGridRecord[] getRecords() {  
		if (records == null) {  
			records = getNewRecords();    
		}    
		return records;    
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


	@SuppressWarnings("deprecation")
	public static ListGridRecord[] getNewRecords() {  
		return new ListGridRecord[]{  
				createRecord("","", "", "", new Date(1776, 6, 4),new Date(1776, 6, 4))
		};  
	}  
}  