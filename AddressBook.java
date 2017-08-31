package Data_Structure;
import java.util.*;
public class AddressBook {
	HashMap<String,Integer> map = new <String,Integer>HashMap();
	Scanner sc=new Scanner(System.in);
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		AddressBook ab=new AddressBook();
		while(true)
		{
			System.out.println("Select the options");
			System.out.println("1 Add the users");
			System.out.println("2 Delete the users");
			System.out.println("3 Search the Users");
			System.out.println("4 Display");
			System.out.println("5 Exit");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:ab.add1();
				break;
			case 2:ab.delete();
				break;
			case 3:ab.Search();
				break;
			case 4:ab.display();
				break;
			case 5:System.exit(0);
				break;
			default :System.out.println("invalid option ....! Try agin");
				break;
			}
		}
	}
	public void add1()
	{
		
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter the Address");
		String Address=sc.next();
		System.out.println("enter the Picode");
		int phone_no=sc.nextInt();

		name+=" "+Address;
		map.put(name,phone_no);
		System.out.println(map);
	}
	public void delete()
	{
		int n=sc.nextInt();
		if(map.containsKey(n)==true)
		{
			map.remove(n);
		}
		System.out.println(map);	
	}
	public void Search()
	{
		int n=sc.nextInt();
		if(map.containsKey(n)==true)
		{
			System.out.println("searched elements found"+n);
		}
		System.out.println("elements not found");		
	}
	public void display()
	{
		if(map.isEmpty()==true)
		{
			System.out.println("address book is empty");
		}
		else{
			System.out.println(map);
		}
	}
}