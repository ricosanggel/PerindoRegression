package pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class sayapProd {

	private static WebElement element = null;

	// Icon "Lihat Sayap - Kartini Perindo
	public static WebElement kartiniPerindo(WebDriver driver) {
		//a[@target='_blank']
		//cssSelector(".btn.btn--primary"
		element = driver.findElement(By.cssSelector(".btn.btn--primary"));
		return element;
	}

	// Icon "Lihat Sayap - Pemuda Perindo
	public static WebElement pemudaPerindo(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/main/section[2]/div/div[1]/div/a"));
		return element;
	}

	public static WebElement pagePemudaPerindo(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/main/div/ul/li[2]/img"));
		return element;
	}
	public static WebElement header_Kartini(WebDriver driver) {
		////*[@id=\"sc_blogger_545366807\"]/h2
		element = driver.findElement(By.xpath("//*[@id=\"sc_blogger_545366807\"]/h2"));
		return element;
	}
	public static WebElement header_Pemuda(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\"menu-item-2727\"]/a"));
		return element;
	}
	
	
	
}
