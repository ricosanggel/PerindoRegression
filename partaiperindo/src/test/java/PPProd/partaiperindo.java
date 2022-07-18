package PPProd;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class partaiperindo {
	

	@Test (priority=1, description="TC 1 Login")	
	public void success_login_nonadmin() throws InterruptedException {			
		given().
			headers("Content-Type", "application/x-www-form-urlencoded").
			accept(ContentType.JSON)
		.params("number", "081223257356")
		.params("password", "ric123")
		.when().
			post("https://api.partaiperindo.com/auth/login")
		.then().
			log().all().
			statusCode(201)
			.extract().response();
		//test
	}
	
	
	@Test (priority=2, description="TC 2 Invalid Password when login")	
	public void failed_login_invalidpassword() throws InterruptedException {
			given().
				headers("Content-Type", "application/x-www-form-urlencoded").
				accept(ContentType.JSON)
			.params("number", "6281223257359")
			.params("password", "eqweq")
			.when().
				post("https://api.partaiperindo.com/auth/login")
			.then()  
				.statusCode(401)
			.log().all();
	}
	@Test (priority=3, description="TC 3 Invalid Phone Number when login")	
	public void failed_login_invalidphonenumberformat() throws InterruptedException {
		given().
			headers("Content-Type", "application/x-www-form-urlencoded").
			accept(ContentType.JSON)
		.params("number", "6281223")
		.params("password", "")
		.when().
			post("https://api.partaiperindo.com/auth/login")
		.then()  
			.statusCode(400)
		.log().all();
	Thread.sleep(1000);
	}
	@Test (priority=4, description="TC 4 Successful Forgot Password")	
	public void forgotpassword() throws InterruptedException {
		given() 
		.headers("Content-Type", "application/json")
		.params("number", "081223257356")
		.when()
			.get("https://api.partaiperindo.com/auth/forgotpassword")
		.then()  
			.statusCode(200)
		.log().all();
	Thread.sleep(5000);
	}
	//test deploy
	
	
	@Test (priority=5, description="TC 5 Successful Register")	
	public void register() throws InterruptedException {
		given()
		.headers("Content-Type", "application/json")
		.params("number", "081382648636")
		.when()
			.get("https://api.partaiperindo.com/auth/otp")
		.then()  
			.statusCode(200)
		.log().all();
	Thread.sleep(1000);
	}
	@Test (priority=6, description="TC 6 Successfull search content")	
	public void search() {
		given()
		.headers("Content-Type", "application/json")
		.params("keywords", "perindo")
		.params("page", "1")
		.params("limit", "10")
		.when()
			.get("https://api.partaiperindo.com/content/search")
		.then()  
			.statusCode(200)
		.log().all();
	}
	@Test (priority=7, description ="TC 7 Get All Listed aksi/berita")	
	public void getAllAksi() {
		given()
		.headers("Content-Type", "application/json")
		.when()
			.get("https://api.partaiperindo.com/content/listnewscategory")
		.then()  
			.statusCode(200)
		.log().all();
	}
	@Test (priority=8, description ="TC 8 Get Detail Aksi/Berita")	
	public void getAksiDetail() {
		given()
		.headers("Content-Type", "application/json")
		.when()
			.get("https://api.partaiperindo.com/content/news/partai-perindo-bali-komit-jaga-kamtibmas-jelang-pemilu-2024")
		.then()  
			.statusCode(200)
		.log().all();
	}
	@Test (priority=9, description ="TC 9 Failed Get Detail on Specific Aksi")	
	public void failed_getAksiNotFound() {
		given()
		.headers("Content-Type", "application/json")
		.when()
			.get("https://api.partaiperindo.com/content/news/partai-perindo-bali-komit-jaga-kamtibmas-jelang-pemilu-")
		.then()  
			.statusCode(404)
		.log().all();
	}
	@Test (priority=10, description ="TC 10 Get All Listed Agenda/Event")	
	public void getListAgenda() {
		given()
		.headers("Content-Type", "application/json")
		.params("limit", "8")
		.params("page", "1")
		.params("timeline", "")
		.params("cache", "")
		.when()
			.get("https://api.partaiperindo.com/content/listevent")
		.then()  
			.statusCode(200)
		.log().all();
	}
	@Test (priority=11, description ="TC 11 Get Detail on Specific Agenda")	
	public void getListAgendaDetail() {
		given()
		.headers("Content-Type", "application/json")
		.params("cache", "true")
		.when()
			.get("https://api.partaiperindo.com/content/event/kompetisi-digital-aksi-nyata-darikamuuntukindonesia")
		.then()  
			.statusCode(200)
		.log().all();
	}
	@Test (priority=12, description ="TC 12 Failed Get Detail on Specific Agenda")	
	public void failed_getListAgendaDetail() {
		given()
		.headers("Content-Type", "application/json")
		.params("cache", "true")
		.when()
			.get("https://api.partaiperindo.com/content/event/kompetisi-digital-aksi-nyata-darikamuuntu")
		.then()  
			.statusCode(404)
		.log().all();
	}
	@Test (priority=13, description ="TC 13 Get-Member")
	public static void getmember() throws InterruptedException {
		Response response = (Response) 
		given()
		.headers("Content-Type", "application/x-www-form-urlencoded")
					.accept(ContentType.JSON)
				.params("number", "081315402385")
				.params("password", "Arshad652018")
				.when().
					post("https://api.partaiperindo.com/auth/login")
				.then().
					log().all()
					.extract().response();
					String jsonString = response.asString();
					AssertJUnit.assertTrue(jsonString.contains("token"));
			        //This token will be used in later requests
					String token = response.jsonPath().getString("token");  
				
					Thread.sleep(1000);
			    given()
			    .header("authorization", "Bearer " + token)
				.header("Content-Type", "application/json")
				.when()
					.get("https://api.partaiperindo.com/member/profile")
				.then()
					.log().all()
					.statusCode(200);
	}	
}
	

		

	