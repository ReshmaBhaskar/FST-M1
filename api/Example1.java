package RESTExamples;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

	
public class Example1 {
	
	    @Test
	    public void GetPetDetails() {
	    	
	        // Specify the base URL to the RESTful web service
	        baseURI = "https://petstore.swagger.io/v2/pet";

	        // Make a request to the server by specifying the method Type and 
	        // resource to send the request to.
	        // Store the response received from the server for later use.
	        Response response = 
	            given().contentType(ContentType.JSON) // Set headers
	            .when().get("/findByStatus?status=sold"); // Run GET request

	        // Now let us print the body of the message to see what response
	        // we have received from the server
	        String responseBody = response.getBody().asString();
	        System.out.println("Response Body is =>  " + responseBody);
	        
	        //Print body in formatted way
	       // String responseBody2 = response.getBody().prettyPrint();
	        //System.out.println("Response Body2 is =>  " + responseBody2);
	        
	        //Print headers
	        Headers responseHeaders = response.then().extract().headers();
	        System.out.println("Response Header is =>  " + responseHeaders);
	        
	        
	        // Extract status from response
	        String responseJSON_status = response.then().extract().path("[0].status");
	        System.out.println("Response Json status is =>  " + responseJSON_status);
	        
	        // Extract name from response
	        String responseJSON_name = response.then().extract().path("[0].name");
	        System.out.println("Response Json name is =>  " + responseJSON_name);
	        

	        //Assertion for status of pet
	        response.then().extract().path("[0].status").equals("sold");
	    
	        
	        // Assertions
	        response.then().statusCode(200);
	        response.then().body("[0].status", equalTo("sold"));
	        
	        
	     
	    }

	}
