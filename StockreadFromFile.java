package Data_Structure;
import java.awt.List;
import java.io.*;
import java.util.*;
public class StockreadFromFile
{
    public static void main(String[]args) throws Exception
    {
		Scanner sc=new Scanner(System.in);
		String src="/home/bridgeit/gangadhar/Java/algorithm_pgm/File4.txt";	
		String temp="";

		int intValue[]=new int[50]; 
		try
		{
			FileReader fr=new FileReader(src);
			BufferedReader br=new BufferedReader(fr);
			int m;
			while((temp=br.readLine())!=null)
			{
				String st[] =temp.split(",");

				for(int i=0;i < st.length;i++)
				{
					intValue[i]=Integer.parseInt(st[i]);	
				}
			}	
			System.out.println("file contain");
			System.out.println();
			System.out.println("no of Shares:  BuyPrice:  Selling price");
			for(int i=0;i < 3;i++)
			{
				System.out.print(intValue[i]+"\t\t");	
			}
			System.out.println();
			int numberShares=intValue[0];
			int buyPrice=intValue[1];
			int sellPrice=intValue[2];
			Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");
        String name=input.nextLine();
        System.out.println(name + " here is the information of your stock transactions:");
      
        System.out.println("Amount of purchase:" + buyPrice*numberShares);
        System.out.println("Amount of sell:" + sellPrice*numberShares);
        System.out.println("Transaction fee paid:" + (15 + 15));
        System.out.println("Net profit:" + ((sellPrice*numberShares)-(numberShares*buyPrice)-30));       
    }
		catch(Exception e)
	{
		System.out.println("file not found");
	}
    }	
}