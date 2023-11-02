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


public WebDriver driver;

	
	@BeforeTest
	public void setUpTest() {
		
		//Set-ChromeDriver Path
		String driverPath = "C:\\Users\\ProBook\\Downloads\\chromedriver-win64\\chromedriver.exe";
		
//		String OS = System.getProperty("os.name");
//		
//		//OS Windows
//		if(OS.contains("Windows"))
//			{System.setProperty("webdriver.chrome.driver", "C:\\Users\\ProBook\\git\\Automation-Regression-Perindo\\partaiperindo\\driver\\chromedriver.exe	");
//		}else
//			{System.setProperty("webdriver.chrome.driver", "C:\\Users\\ProBook\\git\\Automation-Regression-Perindo\\partaiperindo\\driver\\chromedriver.exe");
//		}
//		
//		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true);
//		driver = new ChromeDriver(options);
	
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
				driver = new ChromeDriver(options);
	}
		
	
	// TC 21 - Petunjuk Arah - Rumah Perindo
	@Test (priority=21, description ="TC 21 Petunjuk Arah")
	public void PetunjukArah() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));   
		driver.get("https://partaiperindo.com/rumah-perindo");
		driver.manage().window().maximize();
		rumahProd.petunjukArah(driver).click();
		
	
	}
 
	// TC 22 - Sayap Perindo - Kartini Perindo
	@Test (priority=22, description ="TC 22 Open Kartini Perindo")
	public void kartiniPerindo() throws InterruptedException {
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.navigate().to("https://partaiperindo.com/sayap-perindo");
		driver.manage().window().maximize();
		sayapProd.kartiniPerindo(driver).click();
			Thread.sleep(3000);
			Set<String> windowhandles = driver.getWindowHandles();
			System.out.println("Child window handle is" + windowhandles);
				for( String windowHandle:windowhandles){ 
					driver.switchTo().window(windowHandle); 
				}		
				
			String Actual = sayapProd.header_Kartini(driver).getText();
				System.out.println(Actual);
			String Expected = "Berita Terbaru";
		assertEquals(Actual, Expected);
	
	}

	// TC 23 - Sayap Perindo - Pemuda Perindo
	@Test (priority=23, description ="TC 23 Open Pemuda Perindo")
	public void pemudaPerindo() throws InterruptedException {
		

		
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
}

	


