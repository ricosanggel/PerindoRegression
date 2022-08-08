package pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerProd {
	
	private static WebElement element= null;
	
	//Member.Partaiperindo button
	public static WebElement button_register (WebDriver driver) {
	
		element = driver.findElement (By.cssSelector("button.blue"));
	return element;
	}
	public static WebElement button_register2 (WebDriver driver) {
		
		element = driver.findElement (By.cssSelector("button.mt-2"));
	return element;
	}
	public static WebElement checkbox (WebDriver driver) {
		
		element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/form/label/span[2]"));
	return element;
		}
	public static WebElement input_Phone_Number (WebDriver driver) {
		
		element = driver.findElement (By.name("nohp"));
		return element;
	}
	public static WebElement input_password (WebDriver driver) {
		
		element = driver.findElement (By.name("password"));
	return element;
	}
	
	public static WebElement input_Konfirmasi_password (WebDriver driver) {
		
		element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/form/div[3]/div/input"));
	return element;
	}
}
	