package com.sweng.doodle.client;

import java.util.Date;

import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.TimeUnit;
import com.smartgwt.client.widgets.calendar.HeaderLevel;
import com.smartgwt.client.widgets.calendar.Lane;
import com.smartgwt.client.widgets.calendar.Timeline;

public class Prova {
	VerticalPanel panel = new VerticalPanel();
	public Prova(TabPanel pannello){
		
		
		
		Lane[] developers = new Lane[]{  
	            new Lane("charlesMadigen", "Charles Madigen"),  
	            new Lane("tamaraKane", "Tamara Kane"),  
	            new Lane("darcyFeeney", "Darcy Feeney"),  
	            new Lane("kaiKong", "Kai Kong"),  
	            new Lane("shelleyFewel", "Shelley Fewel"),  
	            new Lane("garretMonroe", "Garret Monroe")  
	        };  
		Timeline calendar = new Timeline();  
        calendar.setHeight(451);  
        calendar.setStartDate(new Date(112, 5, 2));  
        calendar.setEndDate(new Date(112, 5, 22));  
        calendar.setData(TimelineData.getRecords());  
        calendar.setLanes(developers);  
        calendar.setCanResizeTimelineEvents(true);  
        calendar.setCanEditLane(true);  
        calendar.setShowEventDescriptions(false);  
  
        HeaderLevel[] headerLevels = new HeaderLevel[]{  
            new HeaderLevel(TimeUnit.WEEK),   
            new HeaderLevel(TimeUnit.DAY)  
        };  
        calendar.setHeaderLevels(headerLevels);  
  
        calendar.draw();  
        panel.add(calendar);
        pannello.add(panel, "Prova");
	}

}
