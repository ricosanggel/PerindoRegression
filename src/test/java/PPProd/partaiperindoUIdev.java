package PPProd;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.constantdev;
import pagesobject.*;

public class partaiperindoUIdev {


public static WebDriver driver;
	
	@BeforeTest
	public void setUpTest() {
		
		String OS = System.getProperty("os.name");
		
		//OS Windows
		if(OS.contains("Windows"))
			{System.setProperty("webdriver.chrome.driver", "C:\\jenkins\\chromedriver.exe");
		}else
			{System.setProperty("webdriver.chrome.driver", "C:\\Users\\ProBook\\git\\Automation-Regression-Perindo\\partaiperindo\\driver\\chromedriver.exe");
		}
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
			
	}
		
	
	// TC 21 - Petunjuk Arah - Rumah Perindo
	@Test (priority=21, description ="TC 21 Petunjuk Arah")
	public void PetunjukArah() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));   
		driver.get(constantdev.URLRumahPerindo);
		driver.manage().window().maximize();
		rumahProd.petunjukArah(driver).click();
	}
 
	// TC 22 - Sayap Perindo - Kartini Perindo
	@Test (priority=22, description ="TC 22 Open Kartini Perindo")
	public void kartiniPerindo() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.navigate().to(constantdev.URLSayapPerindo);
		driver.manage().window().maximize();
		sayapProd.kartiniPerindo(driver).click();
			Set<String> windowhandles = driver.getWindowHandles();
			System.out.println("Child window handle is" + windowhandles);
				for( String windowHandle:windowhandles){ 
					driver.switchTo().window(windowHandle); 
				}		
			String Actual = sayapProd.header_Kartini(driver).getText();
				System.out.println(Actual);
			String Expected = "Kartini Perindo";
		
		assertEquals(Actual, Expected);
	
	}

	// TC 23 - Sayap Perindo - Pemuda Perindo
	@Test (priority=23, description ="TC 23 Open Pemuda Perindo")
	public void pemudaPerindo() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get(constantdev.URLSayapPerindo);
		driver.manage().window().maximize();
		sayapProd.pagePemudaPerindo(driver).click();
		sayapProd.pemudaPerindo(driver).click();
			Set<String> windowhandles = driver.getWindowHandles();
			System.out.println("Child window handle is" + windowhandles);
				for( String windowHandle:windowhandles){ 
					driver.switchTo().window(windowHandle); 
					//test
				}		
			String Actual = sayapProd.header_Pemuda(driver).getText();
			String Expected = "DPP Partai Perindo";
		System.out.println(sayapProd.header_Pemuda(driver).getText());
		assertEquals(Actual, Expected);
	}
	
	
	
	/*TC 18 - login
	public void login() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://member.partaiperindo.com/?_gl=1*75dbfo*_ga*MTY3NzI2MDQ5OS4xNjQwMTQxNjAy*_ga_F1L7J6WSC2*MTY1MjE1Mzk1Ni4xNDYuMC4xNjUyMTUzOTU2LjA.#/login");
		driver.manage().window().maximize();
		loginProd.input_username(driver).sendKeys("081223257356");
		loginProd.input_password(driver).sendKeys("Gagger_123");
		Thread.sleep(1000);
		loginProd.button_login_second(driver).click();
	}
	*/
	
}

	


