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
    
    public static ListGridRecord createRecord(int idevento, String nomevento, String luogo, String descr, Date dal, Date al, int dalle, int alle) {  
        ListGridRecord record = new ListGridRecord();  
        record.setAttribute("ID Evento", idevento);  
        record.setAttribute("Nome Evento", nomevento);  
        record.setAttribute("Luogo", luogo);  
        record.setAttribute("Descrizione Evento", descr);  
        record.setAttribute("Dal", dal);  
        record.setAttribute("Al", al);  
        record.setAttribute("Dalle", dalle);  
        record.setAttribute("Alle", alle);  
        return record;  
    }  
  
    
	public static ListGridRecord[] getNewRecords() {  
        return new ListGridRecord[]{  
                createRecord(1,"prova1", "prova1", "US", new Date(1776 - 1900, 6, 4),new Date(1776 - 1900, 6, 4), 1, 2)
                };  
    }  
}  