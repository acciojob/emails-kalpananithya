package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;
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


        int ct = 1;

        for (int i = 0; i < calendar.size() - 1; i++) {

            Meeting t1 = calendar.get(i);

            for (int j = i; j < calendar.size() - 1; j++) {





                    Meeting temp2;
                    temp2 = calendar.get(j);

                    if (temp2.getStartTime().isAfter(t1.getStartTime()) && temp2.getEndTime().isAfter(t1.getEndTime()))

                        ct++;



            }
        }


        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        return (ct);


    }
}