package Data_Structure;
import java.util.*;

	class Node
	{
		int data;
	    Node link;
	 
	    /*  Constructor  */
	    public Node()
	    {
	        link = null;
	        data = 0;
	    }    
	    /*  Constructor  */
	    public Node(int d,Node n)
	    {
	        data = d;
	        link = n;
	    }    
	    /*  Function to set link to next Node  */
	    public void setLink(Node n)
	    {
	        link = n;
	    }    
	    /*  Function to set data to current Node  */
	    public void setData(int d)
	    {
	        data = d;
	    }    
	    /*  Function to get link to next node  */
	    public Node getLink()
	    {
	        return link;
	    }    
	    /*  Function to get data from current Node  */
	    public int getData()
	    {
	        return data;
	    }
	}

	class linkedList
	{
	    Node start;
	    Node end ;
	    int size ;
	 
	    /*  Constructor  */
	    public linkedList()
	    {
	        start = null;
	        end = null;
	        size = 0;
	    }

	    public int getSize()
	    {
	        return size;
	    }    

	    public void insertAtEnd(int val)
	    {
	        Node nptr = new Node(val,null);    
	        size++ ;    
	        if(start == null) 
	        {
	            start = nptr;
	            end = start;
	        }
	        else 
	        {
	            end.setLink(nptr);
	            end = nptr;
	        }
	    }
	    public void deleteAtPos(int pos)
	    {        
	        if (pos == 1) 
	        {
	            start = start.getLink();
	            size--; 
	            return ;
	        }
	        if (pos == size) 
	        {
	            Node s = start;
	            Node t = start;
	            while (s != end)
	            {
	                t = s;
	                s = s.getLink();
	            }
	           
	            end = t;
	            end.setLink(null);
	            size --;
	            return;
	        }
	        Node ptr = start;
	        pos = pos - 1 ;
	        for (int i = 1; i < size - 1; i++) 
	        {
	            if (i == pos) 
	            {
	                Node tmp = ptr.getLink();
	                tmp = tmp.getLink();
	                ptr.setLink(tmp);
	                break;
	            }
	            ptr = ptr.getLink();
	        }
	        size-- ;
	    }    
	    public void display()
	    {
	        System.out.print("\nList of company shares= ");
	        if (size == 0) 
	        {
	            System.out.print("empty\n");
	            return;
	        }    
	        if (start.getLink() == null) 
	        {
	            System.out.println(start.getData() );
	            return;
	        }
	        Node ptr = start;
	        System.out.print(start.getData()+ " ");
	        ptr = start.getLink();
	        while (ptr.getLink() != null)
	        {
	            System.out.print(ptr.getData()+ " ");
	            ptr = ptr.getLink();
	        }
	        System.out.print(ptr.getData()+ "\n");
	    }
	}

	public class CompanyShares
	{    
	    public static void main(String[] args)
	    {             
	        Scanner sc = new Scanner(System.in);
	        linkedList list = new linkedList(); 
	        System.out.println("Company Shares\n");          
	        while(true)
	        {
	            System.out.println("1. add the shares");
	            System.out.println("2. remove the shares");
	            System.out.println("3. Display the shares");
	            System.out.println("4. total shares");
	            System.out.println("5. Exit");
	            int choice = sc.nextInt();            
	            switch (choice)
	            {
	            	case 1 : 
	            		System.out.println("Enter element to insert");
		                list.insertAtEnd( sc.nextInt() );                     
		                break;      
          
	            	case 2 : 
	            		System.out.println("Enter position");
	            		int p = sc.nextInt() ;
	            		if (p < 1 || p > list.getSize() )
	            			System.out.println("Invalid position\n");
	            		else
	            			list.deleteAtPos(p);
	            		break;
	            	case 3:list.display();
	            		break;                  
	            	case 4 : 
	            		System.out.println("Size = "+ list.getSize() +" \n");
	            		break;   
	            	case 5: System.exit(0);
	            	default : 
	            		System.out.println("Wrong Entry \n ");
	            		break;   
	            }
	                           
	        }              
	    }
	}