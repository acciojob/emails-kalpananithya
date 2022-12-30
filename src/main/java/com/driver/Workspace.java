package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar = new ArrayList<>(); // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId);

    }

    public void addMeeting(Meeting meeting) {

        calendar.add(meeting);
        //add the meeting to calendar

    }

    public int findMaxMeetings() {


        ArrayList<Pair<LocalTime,Integer>> endmeet=new ArrayList<>();


        for(int i=0;i<calendar.size();i++)
        {
            endmeet.add(Pair.of(calendar.get(i).getEndTime(),i));

        }
        Collections.sort(endmeet);
         int ct=1;
        LocalTime end=endmeet.get(0).getLeft();

        if(!endmeet.isEmpty())
          ct+=1;

        for(int j=1;j<calendar.size();j++)
        {
            if(calendar.get(endmeet.get(j).getRight()).getStartTime().compareTo(end)>0)

            ct+=1;
             end=endmeet.get(j).getLeft();

        }








        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        return (ct);


    }
}