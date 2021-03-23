import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Task2_GET_Users {
	@Test
	void getUserDetails() 
	{	
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
						//request object
		RequestSpecification httpRequest=RestAssured.given();
						
						//Response object
		Response response=httpRequest.request(Method.GET,"/users");
					
		JsonPath jsonPath= response.jsonPath();
		ArrayList a= (ArrayList)jsonPath.get();
		
		int n=response.getStatusCode();
	    System.out.println("Status code is: "+n);
	    System.out.println();
	    
		System.out.println("---------------List Of USERS------------------");
		System.out.println();
		
		for(int i=0;i<a.size();i++) {
			LinkedHashMap l=(LinkedHashMap) a.get(i);
			System.out.println("USER ID: "+l.get("id"));
			System.out.println("NAME: "+l.get("name"));
			System.out.println("USERNAME: "+l.get("username"));
			System.out.println("EMAIL: "+l.get("email"));
			System.out.println("PHONE NUMBER: "+l.get("phone"));
			System.out.println("WEBSITE: "+l.get("website"));
			
			LinkedHashMap la=(LinkedHashMap) l.get("address");
			System.out.println("Street: "+la.get("street"));
			System.out.println("Suite: "+la.get("suite"));
			System.out.println("City: "+la.get("city"));
			System.out.println("Zipcode: "+la.get("zipcode"));
			//System.out.println();
			LinkedHashMap lc=(LinkedHashMap) l.get("company");
			System.out.println("Company Name: "+lc.get("name"));
			System.out.println("CatchPhrase: "+lc.get("catchPhrase"));
			System.out.println("bs: "+lc.get("bs"));
			
			System.out.println();
			System.out.println();
		}
	 		
	}
}
