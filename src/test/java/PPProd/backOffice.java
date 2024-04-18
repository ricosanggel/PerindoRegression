package PPProd;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import Utility.*;



public class backOffice {
	
	public static GetToken tken = new GetToken();

	@Test (priority=1, description="TC 1 Get Saksi")	
	public void getSaksi() throws InterruptedException {			
		given()
		.headers("Content-Type", "application/json")
		.header("authorization", "Bearer " + tken.getProdTokenAdmin())
		.params("page", "1")
		.params("page", "5")
		.when()
			.get(constant.URLProdSaksi)
		.then()  
			.statusCode(200)
		.log().all();
	}
	
	@Test (priority=2, description="TC 2 Get Rekruter")	
	public void getRekruter() throws InterruptedException {			
		given()
			.headers("Content-Type", "application/x-www-form-urlencoded")
			.headers("Content-Type", "application/json")
			.header("authorization", "Bearer " + tken.getProdTokenAdmin())
			.params("page", "1")
			.params("page", "5")
			.when()
				.get(constant.URLProdRekruter)
			.then()  
				.statusCode(200)
			.log().all();
		}
}

	

		

	