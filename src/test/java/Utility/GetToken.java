package Utility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;



public class GetToken {
	
	
	 public String getTokenAdmin()
	    {
	        Response response = (Response)
	        given()
	                .headers("Content-Type", "application/x-www-form-urlencoded")
	                .accept(ContentType.JSON)
	                .params("number", "6288110930201")
	                .params("password", "ric123")
	                .when().
	                post("https://dev-api.partaiperindo.com/auth/login")
	                .then().
	                log().all()
	                .extract().response();
	        String jsonString = response.asString();
	        AssertJUnit.assertTrue(jsonString.contains("token"));
	        //This token will be used in later requests
	        String tokenDev = response.jsonPath().getString("token");

	        return tokenDev;

	    }
	
	
	 public String getProdToken()
	    {
	        Response response = (Response)
	        given()
	                .headers("Content-Type", "application/x-www-form-urlencoded")
	                .accept(ContentType.JSON)
	                .params("number", "6288210193067")
	                .params("password", "ric123")
	                .when().
	                post("https://api.partaiperindo.com/auth/login")
	                .then().
	                log().all()
	                .extract().response();
	        String jsonString = response.asString();
	        AssertJUnit.assertTrue(jsonString.contains("token"));
	        //This token will be used in later requests
	        String tokenProd = response.jsonPath().getString("token");

	        return tokenProd;

	    }
	 public String getDevToken()
	    {
	        Response response = (Response)
	        given()
	                .headers("Content-Type", "application/x-www-form-urlencoded")
	                .accept(ContentType.JSON)
	                .params("number", "6288210193067")
	                .params("password", "ric123")
	                .when().
	                post("https://dev-api.partaiperindo.com/auth/login")
	                .then().
	                log().all()
	                .extract().response();
	        String jsonString = response.asString();
	        AssertJUnit.assertTrue(jsonString.contains("token"));
	        //This token will be used in later requests
	        String tokenProd = response.jsonPath().getString("token");

	        return tokenProd;

	    }
	}
	

	

	
	    


