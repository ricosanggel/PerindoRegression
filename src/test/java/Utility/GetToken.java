package Utility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.AssertJUnit;

import com.google.gson.JsonObject;

import static io.restassured.RestAssured.given;



public class GetToken {
	
	 public static String base_url_dev = "https://dev-api.partaiperindo.com";
	 public static String base_url_prod = "https://api.partaiperindo.com";
	
	 public String getDevTokenAdmin()
	    {
	        Response response = (Response)
	        given()
	                .headers("Content-Type", "application/x-www-form-urlencoded")
	                .accept(ContentType.JSON)
	                .params("number", "6288110930201")
	                .params("password", "ric123")
	                .when().
	                post(base_url_dev+"/auth/login")
	                .then().
	                log().all()
	                .extract().response();
	        String jsonString = response.asString();
	        AssertJUnit.assertTrue(jsonString.contains("token"));
	        //This token will be used in later requests
	        String tokenAdminDev = response.jsonPath().getString("token");

	        return tokenAdminDev;

	    }
	 
	 public String getProdTokenAdmin()
	    {
	        Response response = (Response)
	        given()
	                .headers("Content-Type", "application/x-www-form-urlencoded")
	                .accept(ContentType.JSON)
	                .params("number", "+6281223257356")
	                .params("password", "ric321")
	                .when().
	                post(base_url_prod+"/auth/login")
	                .then().
	                log().all()
	                .extract().response();
	        String jsonString = response.asString();
	        AssertJUnit.assertTrue(jsonString.contains("token"));
	        //This token will be used in later requests
	        String tokenAdminProd = response.jsonPath().getString("token");

	        return tokenAdminProd;

	    }
	
	
	 public String getMemberProdToken()
	    {
	        Response response = (Response)
	        given()
	                .headers("Content-Type", "application/x-www-form-urlencoded")
	                .accept(ContentType.JSON)
	                .params("number", "6288210193067")
	                .params("password", "ric123")
	                .when().
	                post(base_url_prod+"/auth/login")
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
	                post(base_url_dev+"/auth/login")
	                .then().
	                log().all()
	                .extract().response();
	        String jsonString = response.asString();
	        AssertJUnit.assertTrue(jsonString.contains("token"));
	        //This token will be used in later requests
	        String tokenDev = response.jsonPath().getString("token");

	        return tokenDev;

	    }
	 public String getDevAccessToken()
		    {
	        JsonObject jsonObject = new JsonObject();
	        jsonObject.addProperty("grant_type", "client_credentials");
	        String requestBody = "{ \"grant_type\": \"client_credentials\" }";
	        // String requestBody = "{ \"key\": \"value\" }";
	        Response response = (Response)
	                given()
	                        .header("Accept", " application/json")
	                        .header("Authorization","Basic MDJiMWU2MzFhYjRjNDZmM2FjYTg5Yzk0NjI5OTkyNDU6ODY2ZmZlYmFiZjRmNDNhZmJkMjM5MWQ0Yjg4YjEwNTI=")
	                        .header("Content-Type","application/x-www-form-urlencoded")
	                        .formParam("grant_type", "client_credentials")
	                        .when()
	                        // .multiPart("json", jsonObject, "application/json")
	                        .post(base_url_dev+ "/insurance/openapi/token").then()
	                        //.log().all()
	                        .extract().response();
	        // .statusCode(201);
	        String accessTokenDev = response.jsonPath().getString("access_token");
	        System.out.println(accessTokenDev);
	        
	        return "Bearer "+accessTokenDev;
	    }
	 
	 public String getProdAccessToken()
	    {
     JsonObject jsonObject = new JsonObject();
     jsonObject.addProperty("grant_type", "client_credentials");
     String requestBody = "{ \"grant_type\": \"client_credentials\" }";
     // String requestBody = "{ \"key\": \"value\" }";
     Response response = (Response)
             given()
                     .header("Accept", " application/json")
                     .header("Authorization","Basic MDJiMWU2MzFhYjRjNDZmM2FjYTg5Yzk0NjI5OTkyNDU6ODY2ZmZlYmFiZjRmNDNhZmJkMjM5MWQ0Yjg4YjEwNTI=")
                     .header("Content-Type","application/x-www-form-urlencoded")
                     .formParam("grant_type", "client_credentials")
                     .when()
                     // .multiPart("json", jsonObject, "application/json")
                     .post(base_url_prod+ "/insurance/openapi/token").then()
                     //.log().all()
                     .extract().response();
     // .statusCode(201);
     String accessTokenProd = response.jsonPath().getString("access_token");
     System.out.println(accessTokenProd);
     
     return "Bearer "+accessTokenProd;
 }
	 

	}
	

	

	
	    


