import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Task2_GET_IdPosts {
	@Test
	void getPostDetails() 
	{	
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
	    //request object
		RequestSpecification httpRequest=RestAssured.given();
		String postid="1";			
		//Response object
		Response response=httpRequest.request(Method.GET,"/"+postid+"/comments");
	
	
		
		String responseBody=response.getBody().asString();
		//System.out.println("Response Body is"+responseBody);
		
		JsonPath jsonPath= response.jsonPath();
		ArrayList a= (ArrayList)jsonPath.get();
		
		//Status code validation
		int n=response.getStatusCode();
	    System.out.println("Status code is: "+n);
	    System.out.println();
	    
		System.out.println("---------------List Of Posts with postId "+postid+"------------------");
		System.out.println();
		
		for(int i=0;i<a.size();i++) {
			LinkedHashMap l=(LinkedHashMap) a.get(i);
			System.out.println("POST ID: "+l.get("postId"));
			System.out.println("ID: "+l.get("id"));
			System.out.println("NAME: "+l.get("name"));
			System.out.println("EMAIL: "+l.get("email"));
			System.out.println("BODY: "+l.get("body"));
			System.out.println();
		}
		
		
		
	}
	
}
