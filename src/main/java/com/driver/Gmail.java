package com.driver;

import java.util.Date;
import java.util.*;

public class Gmail extends Email {


    List<Mail> mail=new ArrayList<>();
    List<Mail> trash=new ArrayList<>();


    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {

        super(emailId);
        this.inboxCapacity=inboxCapacity;


    }

    public Gmail(String emailId) {
        super(emailId);
    }

    public void receiveMail(Date date, String sender, String message){


      Mail email =new Mail(date,sender,message);
        Date lat=null;
        Mail m=null;




            if(this.mail.size() > inboxCapacity) {

                for (Mail d : this.mail) {
                    if (lat == null || d.getDate().after(lat))

                        lat = d.getDate();


                    m = d;
                }


                trash.add(m);
                this.mail.remove(m);
            }
                  this.mail.add(email);



            }



        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.



    public void deleteMail(String message) {


        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for (int i=0;i<mail.size()-1;i++)
        {
            Mail temp=mail.get(i);

            if (temp.getMessage().equals(message)) {
                trash.add(temp);
                mail.remove(temp);

            }
        }
    }


    public String findLatestMessage() {
        if (mail.size() == 0)
            return (null);

        Mail m = mail.get(0);
        Date r = m.getDate();
        Mail res = null;




            for (int i = 1; i < mail.size() - 1; i++)
            {
                Mail temp = mail.get(i);
                Date g = temp.getDate();
                if (g.after(r))
                {
                    r = g;
                    res = temp;
                }


        }


            return (res.getMessage());


        }




        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox



    public String findOldestMessage() {
        Date r = null;
        Mail temp = null;

        if (mail.size() == 0)
            return (null);
        else {


            for (Mail m : this.mail) {
                Date g = m.getDate();
                if (r == null || r.before(g))
                    r = g;
                temp = m;

            }

            return (temp.getMessage());
            // If the inbox is empty, return null
            // Else, return the message of the oldest mail present in the inbox

        }
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
          int count=0;

            for( Mail m: this.mail)
            {
                Date g=m.getDate();

                if(g.after(start)  || g.before(end))
                    count++;


            }
            return(count);








    }

    public int getInboxSize(){
        return this.mail.size();
        // Return number of mails in inbox

    }

    public int getTrashSize(){

        return trash.size();
        // Return number of mails in Trash

    }

    public void emptyTrash(){
        trash.clear();
        // clear all mails in the trash

    }

    public int getInboxCapacity() {
        return this.inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}
