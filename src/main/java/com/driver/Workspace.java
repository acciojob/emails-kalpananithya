package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar=new ArrayList<>(); // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId);

    }

    public void addMeeting(Meeting meeting){

        calendar.add(meeting);
        //add the meeting to calendar

    }

    public int findMaxMeetings(){

        Meeting m=calendar.get(0);
        int ct=0;
        LocalTime t1= m.getStartTime();
        LocalTime t2=m.getEndTime();

        for(int i=1;i<calendar.size()-1;i++)
        {
           Meeting temp=calendar.get(i);
            LocalTime time1= m.getStartTime();
            LocalTime time2=m.getEndTime();

           if(temp.getStartTime().isAfter(t1)  && temp.getStartTime().isBefore(t2))
              ct++;

           t1=time1;
           t2=time2;


        }


          return ct++;


        }


        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

    }



