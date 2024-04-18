package PPProd;


import org.hamcrest.Matchers;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import Utility.*;
import org.hamcrest.Matcher;


public class partaiperindo {
	
	public static GetToken tken = new GetToken();

	@Test (priority=1, description="TC 1 Login")	
	public void success_login_nonadmin() throws InterruptedException {			
		given().
			headers("Content-Type", "application/x-www-form-urlencoded").
			accept(ContentType.JSON)
				.params("number", constant.mobilenumber1 )
				.params("password", constant.password1)
			.when().
				post(constant.URLProdLogin)
			.then().
				log().all()
				.assertThat().statusCode(201)
				.body("phone_number", Matchers.equalTo("+6285266660982"))
				.extract().response();
		
	}
		
	@Test (priority=2, description="TC 2 Invalid Password when login")	
	public void failed_login_invalidpassword() throws InterruptedException {
		given().
			headers("Content-Type", "application/x-www-form-urlencoded").
			accept(ContentType.JSON)
				.params("number", "6281223257359")
				.params("password", "eqweq")
			.when().
				post(constant.URLProdLogin)
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
				post(constant.URLProdLogin)
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
			.get(constant.URLProdForgotPass)
			.then()  
				.statusCode(200)
				.log().all();
			Thread.sleep(2000);
	}	
	
	@Test (priority=5, description="TC 5 Successful Register")	
	public void register() throws InterruptedException {
		given()
		.headers("Content-Type", "application/json")
		.params("number", "081382648636")
		.when()
			.get(constant.URLProdOTP)
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
			.get(constant.URLProdSearch)
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
			.get("https://api.partaiperindo.com/content/news/mantan-dirjen-imigrasi-siap-menjadi-bacaleg-partai-perindo-dapil-sulut")
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
			.assertThat().statusCode(200)
			.body("slug", Matchers.equalTo("kompetisi-digital-aksi-nyata-darikamuuntukindonesia"))
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
	public static void getMember() throws InterruptedException {
		 given()
		.header("authorization", "Bearer " + tken.getMemberProdToken())
		.header("Content-Type", "application/json")
		.when()
			.get("https://api.partaiperindo.com/member/profile")
		.then()
		.log().all()
			.assertThat().statusCode(200)
				.body("member_no", Matchers.equalTo("3275029004200001"));
	}	
	
	@Test (priority=14, description ="TC 14 Get List all Aspirasi")	
	public void listaspirasi() {
		given()
		.headers("Content-Type", "application/json")
		.params("cache", "true")
		.when()
			.get("https://api.partaiperindo.com/content/listaspirasiperindo")
		.then()  
			.statusCode(200)
		.log().all();
	}
	@Test (priority=15, description ="TC 15 Get List all gallery")	
	public void listgallery() {
		given()
		.headers("Content-Type", "application/json")
		.params("cache", "true")
		.when()
			.get("https://api.partaiperindo.com/content/listgallery")
		.then()  
			.statusCode(200)
		.log().all();
	}
	
	@Test (priority=16, description ="TC 16 Get Content-About")	
	public void about() {
		given()
		.headers("Content-Type", "application/json")
		.params("cache", "true")
		.when()
			.get("https://api.partaiperindo.com/content/about?type=embed")
		.then()  
			.statusCode(200)
		.log().all();
	}
	
	@Test (priority=17, description ="TC 17 Get Banner-Main")	
	public void bannerMain() {
		given()
		.headers("Content-Type", "application/json")
		.params("cache", "true")
		.when()
			.get("https://api.partaiperindo.com/content/banner?type=main")
		.then()  
			.statusCode(200)
		.log().all();
	}
	
	@Test (priority=18, description ="TC 18 Get Banner-Mobileapps")	
	public void bannerMobileApps() {
		given()
		.headers("Content-Type", "application/json")
		.params("banner_id", "7")
		.when()
			.get("https://api.partaiperindo.com/content/banner?type=mobileapps")
		.then()  
			.statusCode(200)
		.log().all();
	}
	
	@Test (priority=19, description ="TC 19 list bagian dari Perindo")	
	public void bagianDariPerindo() {
		given()
		.headers("Content-Type", "application/json")
		.when()
			.get("https://api.partaiperindo.com/content/listbagiandariperindo")
		.then()  
			.statusCode(200)
		.log().all();
	}
	
	@Test (priority=20, description ="TC 20 list Sayap Perindo")	
	public void sayapPerindo() {
		given()
		.headers("Content-Type", "application/json")
		.when()
			.get("https://api.partaiperindo.com/content/listsayapperindo")
		.then()  
			.statusCode(200)
		.log().all();	
	}
	
	@Test(priority = 21, description = "TC 21 Get list active Polling")	
	public void getListActivePolling() throws InterruptedException {
	    given()
	    .header("authorization", "Bearer " + tken.getMemberProdToken())
		.header("Content-Type", "application/json")
		.when()
			.get(constant.URLlistActivePolling)
		.then()
			.log().all()
			.assertThat().statusCode(200);
		
						
	}
	
	@Test(priority = 22, description = "TC 22 Get list event by date")	
	public void getListByDate() throws InterruptedException {
		 given()
		    .header("authorization", "Bearer TGa9vE_vp00U1aKGRjFYLrJhlimdvVw4Ysi6w4B_6NE=")
			.header("Content-Type", "application/json")
			.when()
				.get(constant.URLTestLuru)
			.then()
				.log().all()
				.assertThat().statusCode(200);	
	}
						
	
}

	

		

	