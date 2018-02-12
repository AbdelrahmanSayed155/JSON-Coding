package com.abdelrahman.jsonFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertingObjectToJson {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(12,"Abdelrahman Sayed","kamal Street ","go@faceb4ook.com") );
		students.add(new Student(13,"Abdelrahman Sayed1","kamal Street15 ","go@gmail.com") );
		students.add(new Student(14,"Abdelrahman Sayed2","kamal Street 14","go@yahoo.com") );
		students.add(new Student(15,"Abdelrahman Sayed3","kamal Street 8","go@gmail.com") );
		students.add(new Student(16,"Abdelrahman Sayed4","kamal Street 9","go@facebook.com") );
		School school =  new School();
		school.setName("Tahrir");
		school.setAddress("18 kamal street ");
		school.setDesc("this is go ");
		school.setEmail("tahrir@gmail.com");
		school.setStudents(students);
		
	
		ObjectMapper mapper = new ObjectMapper();
	

		//Object to JSON in file
		

		//Object to JSON in String
		try {
			mapper.writeValue(new File("school.json"), school);
			String jsonInString = mapper.writeValueAsString(school);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
