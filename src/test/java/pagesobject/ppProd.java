package pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ppProd {
		
		private static WebElement element= null;
		
		//Search_icon
		public static WebElement search_button (WebDriver driver) {
			
			element = driver.findElement (By.xpath("//*[@id=\"__layout\"]/div/div[1]/header/ul[2]/li[1]/a/img"));	
			return element;
		
		}
		// Search - TextField
		public static WebElement search_textfield (WebDriver driver) {
			
			element = driver.findElement (By.xpath("//*[@id=\"__layout\"]/div/div[1]/header/ul/li[1]/input"));	
			
			return element;
		}
		// Agenda Partai Perindo
		public static WebElement Agenda (WebDriver driver) {
			
			element = driver.findElement (By.xpath("//*[@id=\"__layout\"]/div/main/section[1]/div[2]/div[1]/ul/li[2]/section/div/img"));	
			return element;
		}
		// Aksi Partai Perindo
		public static WebElement Aksi (WebDriver driver) {
			
			element = driver.findElement (By.xpath("//*[@id=\"__layout\"]/div/main/section[1]/div[2]/div[1]/ul/li[1]/section[1]/div/div/h4/a"));	
			return element;
		}
	}

	

