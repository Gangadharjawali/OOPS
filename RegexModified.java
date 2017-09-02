package Data_Structure;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;   
public class RegexModified
{
   public static void main(String[] args) 
   {
	   RegexDemo rd=new RegexDemo();
	   Scanner sc=new Scanner(System.in);
	   String name="hello <<name>>";
	   System.out.println("<<name>>");
	   System.out.println("enter your name to replace ");
	   String input=sc.nextLine();
	   if(input.matches("[a-zA-Z]+")==true)
	   {
		   name=rd.replace(name,input);
	   }
	   else
	   {
	         name="hello *invalid first name";
	   }   
	   System.out.println();
	   String fname=", We have your full name as <<full name>>";
	   System.out.println("<<full name>>");
	   System.out.println("enter the full name to replace ");
	   input=sc.nextLine();
	   
	   if(input.matches("[a-z A-Z]+")==true)
	   {
		   fname=rd.replace(fname,input);
	   }
	   else
	   {
	         fname=", We have your full name as *invalid full name";
	   }
	   System.out.println();
	   String number=" in our system. your contact number is +91-xxxxxxxxxx";
	   System.out.println("+91-xxxxxxxxxx");
	   System.out.println("enter the contact number to replace ");
	   input=sc.nextLine();
	   if(input.matches("[1-9]{10}")==true)
	   {
		   number=rd.replace(number,input);   
	   }
	   else
	   {
		   number=" in our system. your contact number is *invalid phone number";
	   }
	   System.out.println();
	   String date1=" Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016";
	  
	   Date date = new Date();
	   String temp=date.toString();
	   date1=rd.replace(date1, temp);
	   System.out.println(name+fname+number+date1);
   }
   public String replace(String str,String ptrn) 
   {
       Pattern pattern = Pattern.compile("<<name>>|<<full name>>|xxxxxxxxxx|01/01/2016");
       Matcher m = pattern.matcher(str);
       return m.replaceAll(ptrn);
     }
}