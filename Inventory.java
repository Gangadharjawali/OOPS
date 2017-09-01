package json;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class Inventory
{
	void writeData() 
	{
		Scanner sc = new Scanner(System.in);	
		String names[] = {"Rice" , "Wheat" , "Pulses"};		
		JSONObject finalObject = new JSONObject();	
		for (String name : names) 
		{	
			System.out.println("Enter the types of " + name + " : ");
			int count = sc.nextInt();	
			JSONArray array = new JSONArray();		
			for(int i = 0; i < count; i++) 
			{	
				JSONObject jsonObject  = new JSONObject();
				System.out.println("Enter name: ");
				jsonObject.put("name", sc.next());
				System.out.println("Enter weight: ");
				jsonObject.put("weight", sc.nextInt());
				System.out.println("Enter price: ");
				jsonObject.put("price", sc.nextInt());
				array.add(jsonObject);
			}			
			finalObject.put(name , array);
		}
		sc.close();
		PrintWriter printWriter = null;	
		try 
		{
			printWriter = new PrintWriter("/home/bridgeit/gangadhar/Java/functional-Programmes/Json.txt");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		printWriter.write(finalObject.toJSONString());
		printWriter.close();
	}
	void readData() 
	{
		JSONArray array = new JSONArray();	
		JSONParser parser = new JSONParser();	
		JSONObject object;
		try 
		{
			object = (JSONObject) parser.parse(new FileReader("/home/bridgeit/gangadhar/Java/functional-Programmes/Json.txt"));
			array = (JSONArray) object.get("Rice");
			System.out.println("Rice inventory value: " + getValue(array));
			array = (JSONArray) object.get("Pulses");
			System.out.println("Pulses inventory value: " + getValue(array));
			array = (JSONArray) object.get("Wheat");
			System.out.println("Wheat inventory value: " + getValue(array));
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (org.json.simple.parser.ParseException e) 
		{
			e.printStackTrace();
		}
	}
	long getValue(JSONArray array)
	{
		Iterator iterator = array.iterator();
		long value = 0;	
		while(iterator.hasNext()) 
		{
			JSONObject obj = (JSONObject)iterator.next();
			long weight = (long)obj.get("weight");
			long price = (long)obj.get("price");
			value = value + weight * price;	
		}
		return value;
	}
	public static void main(String[] args) 
	{
		Inventory in = new Inventory();
		in.writeData();	
		in.readData();			
	}
}
