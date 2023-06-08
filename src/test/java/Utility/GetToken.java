package Utility;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;




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
	        String token = response.jsonPath().getString("token");

	        return token;

	    }
	}
	

	

	
	    


