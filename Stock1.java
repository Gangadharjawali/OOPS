package Data_Structure;
import java.util.*;
public class Stock1 
{
	Node head;
	class Node
	{
		int data;
		Node link;
		public Node(int d)
		{
			data=d;
			link=null;
		}		
	}
	public Node insert(int val)
	{
		Node n=new Node(val);
		n.link=head;
		head=n;
		return head;
	}
	public void display()
	{
		Node temp=head;
		System.out.println("net profit: Transaction fee: Amount of sell: Amount of purchase:");
		while(temp!=null)
		{
			System.out.print(temp.data+"\t\t");		
			temp=temp.link;		
		}
	}
    public static void main(String[]args) 
    {
    	Stock1 stack=new Stock1();
        String name;
        int numberShares;
        int buyPrice,sellPrice;
        Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");
        name=input.nextLine();
        System.out.println("How many shares bought?");
        numberShares=input.nextInt();
        System.out.println("Buy price?");
        buyPrice=input.nextInt();
        System.out.println("Sale price?");
        sellPrice=input.nextInt();
        input.close();
        System.out.println(name + " here is the information of your stock transactions:");
         stack.insert(numberShares*buyPrice);
        stack.insert(sellPrice*numberShares);
        stack.insert(15+15);
        stack.insert((sellPrice*numberShares)-(numberShares*buyPrice)-30);
        stack.display();
    }
}