package Data_Structure;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class node
{
    int data;
    node next;
    public node(int x)
    {
        data=x;
        next=null;
    }
}
class Queuemain
{
    node f=null,r=null;
    public boolean isEmpty()
    {
        if (f==null || r==null)
            return true;
        else
            return false;
    }
    public void enqueue(int x)
    {
        if (isEmpty()==true)
        {
            node p=new node (x);
            f=r=p;
        }
        else
        {
            node p=new node (x);
            r.next=p;
            r=p;
        }
    }
    public int dequeue()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        else
        {
            int x=f.data;
            f=f.next;
            return x;
        }
    }

    public void display()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
        }
        else
        {
            node temp=f;
            while (temp!=null)
            {
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
    }
}
public class TransactionDetails 
{
    public static void main(String[] args) throws IOException 
    {
    	Scanner sc=new Scanner(System.in);
    	Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh-mm-ss");
		String strDate= formatter.format(date);	
        int ch,x;
        String time;
      

        Queuemain que=new Queuemain();
        while(true)
        {
            System.out.println("Transaction Details");
            System.out.println("1.Insert element in queue");
            System.out.println("2.Remove element from queue");
            System.out.println("3.Display queue");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            ch=sc.nextInt();
          
            switch(ch)
            {
           		case 1:System.out.println("Enter element to be inserted");
           			x=sc.nextInt();
           			System.out.println(strDate);
           			que.enqueue(x);
           			
           			break;
           		case 2:System.out.println("Removed element:"+que.dequeue());
           		System.out.println(strDate);
           			break;
           		case 3:que.display();
           		System.out.println(strDate);
           			break;
           		case 4:System.exit(0);
           			break;
           		default:System.out.println("invalid input...! try again");
           			break;
           	}
         }
     }
 }
