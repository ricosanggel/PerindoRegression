package PPProd;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pagesobject.*;

public class partaiperindoUI {


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
		
	
	// TC 15 - Petunjuk Arah - Rumah Perindo
	@Test (priority=16, description ="TC 16 Petunjuk Arah")
	public void PetunjukArah() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));   
		driver.get("https://partaiperindo.com/rumah-perindo");
		driver.manage().window().maximize();
		rumahProd.petunjukArah(driver).click();
	
	}
 
	// TC 16 - Sayap Perindo - Kartini Perindo
	@Test (priority=17, description ="TC 17 Open Kartini Perindo")
	public void kartiniPerindo() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.navigate().to("https://partaiperindo.com/sayap-perindo");
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

	// TC 17 - Sayap Perindo - Pemuda Perindo
	@Test (priority=18, description ="TC 15 Open Pemuda Perindo")
	public void pemudaPerindo() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://partaiperindo.com/sayap-perindo");
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
	
	
	@Test (priority=19, description ="TC 19 login UI")
	// TC 18 - login
	public void login() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://member.partaiperindo.com/?_gl=1*75dbfo*_ga*MTY3NzI2MDQ5OS4xNjQwMTQxNjAy*_ga_F1L7J6WSC2*MTY1MjE1Mzk1Ni4xNDYuMC4xNjUyMTUzOTU2LjA.#/login");
		driver.manage().window().maximize();
		loginProd.input_username(driver).sendKeys("081223257356");
		loginProd.input_password(driver).sendKeys("Gagger_123");
		Thread.sleep(1000);
		loginProd.button_login_second(driver).click();
	}
	
	
}

	


