package com.examples;

import java.util.HashMap;
import java.util.Map;

public class DemoMap {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		HashMap<String, String>object=new HashMap<String,String>();
		object.put("1", "A");
		object.put("2", "B");
		object.put("3", "C");
		object.put("4", "D");
		object.put("5", "E");
		object.put("6", "F");
		object.put("7", "G");
		object.put("8", "H");
		object.put("9", "I");
		object.put("10", "J");
		
		for(Map.Entry<String,String>data:object.entrySet())
		{
			System.out.println("Key " +data.getKey()+" " +"Value " +data.getValue());
		}

	}

}
