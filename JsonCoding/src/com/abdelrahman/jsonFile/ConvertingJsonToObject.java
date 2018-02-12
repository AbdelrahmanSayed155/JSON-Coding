package com.abdelrahman.jsonFile;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertingJsonToObject {
	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "{'name' : 'mkyong'}";

		//JSON from file to Object
		School obj;
		try {
			obj = mapper.readValue(new File("school.json"), School.class);
			System.out.println("School Name:"+obj.getName());
			System.out.println("School Eamil:"+obj.getEmail());
			System.out.println("School address:"+obj.getAddress());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

}
