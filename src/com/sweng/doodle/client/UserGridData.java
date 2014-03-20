package com.sweng.doodle.client;

import java.util.LinkedList;

import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.sweng.doodle.shared.User;


public class UserGridData {  

	private static RecordList dataTable = new RecordList();

	public static RecordList getRecords(LinkedList<User> dataTable) {  
		return setUser(dataTable);

	}    

	public static ListGridRecord createRecord(String nome,String comm) {  
		ListGridRecord record = new ListGridRecord();    
		record.setAttribute("nome", nome);  
		record.setAttribute("commento", comm);  
		 
		   
		return record;  
	}  


	public static RecordList setUser(LinkedList<User> user){
		for(int i = 0 ; i < user.size(); i++)
			dataTable.add(createRecord(user.get(i).getNome(),user.get(i).getComm()));
		return dataTable;
	}


}  