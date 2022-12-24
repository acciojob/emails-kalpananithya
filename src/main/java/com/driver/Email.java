package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){



        Boolean ol =false;
        Boolean le=false;
        Boolean ch=false;
        Boolean up=false;
        Boolean lo=false;
        Boolean di=false;
        Boolean sp=false;


        if(this.password.equals(oldPassword))
            ol=true;
        if(newPassword.length()>=8)
            le=true;

        for(int i=0;i<newPassword.length();i++)

        {
            if(Character.isUpperCase(newPassword.charAt(i)))
                up=true;
            else if(Character.isLowerCase(newPassword.charAt(i)))
                lo=true;
            else if(Character.isDigit(newPassword.charAt(i)))
                di=true;
            else if(!Character.isDigit(newPassword.charAt(i)) && !Character.isLetter(newPassword.charAt(i))
                    && !Character.isWhitespace(newPassword.charAt(i)))
                sp=true;

        }

                if(ol && le && up && lo && di && sp )
                    this.password=newPassword;


        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
