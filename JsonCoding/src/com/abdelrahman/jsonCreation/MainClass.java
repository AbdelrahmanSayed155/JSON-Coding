package com.abdelrahman.jsonCreation;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MainClass {
	
	public static String convertJsonToString() throws IOException{
		  JSONObject obj1 = new JSONObject();
	      obj1.put("name","foo");
	      obj1.put("num",new Integer(100));
	      obj1.put("balance",new Double(1000.21));
	      obj1.put("is_vip",new Boolean(true));
	      StringWriter out = new StringWriter();
		  obj1.writeJSONString(out);
	      String jsonText = out.toString();
	      System.out.print(jsonText);
	      return jsonText;
	}
	
	public static String parseJson(){
		JSONParser parser = new JSONParser();
	      String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
			
	      try{
	         Object obj = parser.parse(s);
	         JSONArray array = (JSONArray)obj;
				
	         System.out.println("The 2nd element of array");
	         System.out.println(array.get(1));
	         System.out.println();

	         JSONObject obj2 = (JSONObject)array.get(1);
	         System.out.println("Field \"1\"");
	         System.out.println(obj2.get("1"));    

	         s = "{}";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s = "[5,]";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s = "[5,,2]";
	         obj = parser.parse(s);
	         System.out.println(obj);
	      }catch(ParseException pe){
			
	         System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
	      }
		return "";
	}
	
	public  static String extractElementsFromJson() throws ParseException{
		String jsonString  ="{\"balance\":1000.21,\"is_vip\":true,\"num\":100,\"newBalance\":1.05,\"name\":\"foo\"}";
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
	    jsonObject = (JSONObject) parser.parse(jsonString);
		String msgType = (String) jsonObject.get("name");
		return msgType;
	}
	
	public static void createJsonAsString(){
		JSONObject obj = new JSONObject();
	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));
	      obj.put("newBalance", new Double(1.05));
	      System.out.print(obj);
	      
	}
	
	public static void laodJsonFile(){
		JSONParser parser =   new JSONParser();
		try{
		Object obj = parser.parse(new FileReader("data.json"));
		JSONObject jsonObj = (JSONObject)obj;
		String playElemnt = (String)jsonObj.get("play");
		System.out.println(playElemnt);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String []args){
	
		 System.out.println("+++++");
		 laodJsonFile();
		 System.out.println("+++++");
	      try{
		   String output1 =  extractElementsFromJson();
		   System.out.println(output1);
	      }catch (Exception e) {
			e.printStackTrace();
		}
	      
	}

}
