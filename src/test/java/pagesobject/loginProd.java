package pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class loginProd {
	
	WebDriver driver;
	public loginProd(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	private static WebElement element= null;
	
	//Member.Partaiperindo button
	public static WebElement button_login (WebDriver driver) {
		
			element = driver.findElement (By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/a[2]/button"));
			return element;		
	}
	public static WebElement button_login_Home (WebDriver driver) {
		
		element = driver.findElement (By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/form/button"));
	return element;	
	}
	public static WebElement button_login_second (WebDriver driver) {
		
		element = driver.findElement (By.cssSelector(".btn-fill.red.rounded.mt-2"));
	return element;		
	}
	public static WebElement input_username (WebDriver driver) {
			
			element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/form/div[1]/input"));
		return element;
	}
	public static WebElement input_password (WebDriver driver) {
				
			element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/form/div[2]/input"));
		return element;	
	}
		public static WebElement forgot_button (WebDriver driver) {
		
		element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/a/div"));
		return element;				
	}
	public static WebElement forgot_inputnumber (WebDriver driver) {
		
		element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/form/div[1]/input"));
		return element;				
	}
	public static WebElement forgot_inputnewpass (WebDriver driver) {
		
		element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/form/div[2]/input"));
		return element;				
	}
	public static WebElement forgot_inputconfirmnewpass (WebDriver driver) {
		
		element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/form/div[3]/input"));
		return element;				
	}
	public static WebElement forgot_button2 (WebDriver driver) {
		
		element = driver.findElement (By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/form/button"));
		return element;				
	}
	
}
