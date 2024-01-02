package EmailApp;

import java.util.Scanner;

public class EmailInfo {
    Scanner scn = new Scanner(System.in);


    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private int defaultPasswordLength=7;
    private String password;
    private int mailboxCapacity=500;
    private String alternateEmail;
    private String companySuffix="google.com";

    public EmailInfo(String firstName , String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
        //System.out.println("EMAIL CREATED : "+this.firstName+" "+this.lastName);
        this.department = setDepartment();
        //System.out.println("DEPARTMENT : "+this.department);
        this.password =randomPasswordGenrator(defaultPasswordLength);
        //	System.out.println("YOUR PASSWORD : "+this.password);
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
        //System.out.println("YOUR EMAIL : "+email);
    }

    private String setDepartment(){
        System.out.println("DEPARTMENT CODES --->");
        System.out.println("1.Sales");
        System.out.println("2.Devlopment");
        System.out.println("3.Accounting");
        System.out.println("0.None");
        System.out.print("Enter Department Code : ");
        int opt = scn.nextInt();
        if(opt==1) {
            return "sales";
        }
        else if(opt==2) {
            return "dev";
        }
        else if(opt==3) {
            return "account";
        }
        else {
            return "";
        }

    }

    private String randomPasswordGenrator(int length) {
        String PasswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] Password = new char[length];
        for(int i=0;i<length;i++) {
            int randvalue = (int)(Math.random()*PasswordSet.length());
            Password[i]=PasswordSet.charAt(randvalue);
        }
        return new String(Password);
    }

    public void showInfo() {
        System.out.println("DISPLAY NAME : "+firstName+" "+lastName);
        System.out.println("COMPANY NAME : "+companySuffix);
        System.out.println("COMPANY EMAIL : "+email);
        System.out.println("PASSWORD : "+password);
        System.out.println("MAILBOX CAPACITY : "+mailboxCapacity+"MB");
        System.out.println("DO YOU WANT TO CHANGE PASSWORD?");
        System.out.println("yes FOR YES \t no FOR NO");
        String opt1=scn.next();
        if(opt1.equals("yes")) {
            System.out.print("ENTER YOUR PASSWORDS : ");
            String password1=scn.next();
            System.out.print("CONFIRM YOUR PASSWORDS : ");
            String password2=scn.next();
            if(password1.equals(password2)) {
                System.out.println("PASSWORD CHANGED");
                System.out.println("NEW PASSWORD : "+password2);
            }
            else {
                System.out.println("PASSWORD DIDN'T MATCHED ,TRY AGAIN ");
            }

        }
        else {
            System.out.println("THANKS , YOUR WORK HAS DONE ");
        }
    }

}
