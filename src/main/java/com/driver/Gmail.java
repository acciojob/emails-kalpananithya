package com.driver;

import org.apache.commons.lang3.tuple.Triple;

import java.util.Date;
import java.util.*;

public class Gmail extends Email {


    List<Mail> mail;
    List<Mail> trash;


    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {

        super(emailId);
        this.inboxCapacity=inboxCapacity;
        this.mail=new ArrayList<>();
        this.trash=new ArrayList<>();


    }

    public Gmail(String emailId) {
        super(emailId);
    }

    public void receiveMail(Date date, String sender, String message){


         Mail email =new Mail(date,sender,message);


            if(mail.size() == inboxCapacity) {
                Mail old= mail.get(0);

               mail.remove(old);
                trash.add(old);

            }
                  this.mail.add(email);

            }



        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.



    public void deleteMail(String message) {

        Mail delm = new Mail();
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for (int i = 0; i < mail.size()-1; i++) {
            if (mail.get(i).getMessage().equals(message))
                delm = mail.get(i);

            if (delm != null) {
                trash.add(delm);
                mail.remove(delm);
            }


        }

    }

    public String findLatestMessage() {
        if (mail.size() == 0)
            return (null);

          Mail m=mail.get(mail.size()-1);

            return (m.getMessage());


        }

        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox



    public String findOldestMessage() {
        if (mail.size() == 0)
            return (null);


        Mail m=mail.get(0);

        return (m.getMessage());
            // If the inbox is empty, return null
            // Else, return the message of the oldest mail present in the inbox


    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
          int count=0;

            for(int i=0;i<mail.size();i++)
            {
                if(mail.get(i).getDate().compareTo(start) >=0 && mail.get(i).getDate().compareTo(end) <=0 )
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
