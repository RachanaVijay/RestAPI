import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import groovyjarjarantlr.collections.List;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Task2_GET_Posts<string> {
	

	@Test
	void getPostDetails() 
	{	
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		//request object
		RequestSpecification httpRequest=RestAssured.given();
						
		//Response object
		Response response=httpRequest.request(Method.GET,"/posts");
		
		JsonPath jsonPath= response.jsonPath();
		ArrayList a= (ArrayList)jsonPath.get();
		int n=response.getStatusCode();
	    System.out.println("Status code is: "+n);
	    System.out.println();
	    
		System.out.println("---------------List Of Posts------------------");
		System.out.println();
		
		for(int i=0;i<a.size();i++) {
			LinkedHashMap l=(LinkedHashMap) a.get(i);
			System.out.println("USER ID: "+l.get("userId"));
			System.out.println("ID: "+l.get("id"));
			System.out.println("TITLE: "+l.get("title"));
			System.out.println("BODY: "+l.get("body"));
			System.out.println();
		}
	 
        
		 
		
	}
}

/*
String bodyText=response.jsonPath().getString("body");
// System.out.println(bodyText);
 
 java.util.List<Object> list=response.jsonPath().get();

	 for(int i=0; i<list.size();i++ )
	 {
		 
		System.out.println(list.get(i)); 
			
	 }*/