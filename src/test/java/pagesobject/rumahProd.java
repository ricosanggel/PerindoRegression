package pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class rumahProd {
		
		private static WebElement element= null;
		
		//Icon Rumah Perindo
		public static WebElement petunjukArah (WebDriver driver) {
			
			element = driver.findElement (By.xpath("//*[@id=\"__layout\"]/div/main/section[2]/div/div/div[3]/div[2]/a"));	
			return element;
		}
	
	}

	

