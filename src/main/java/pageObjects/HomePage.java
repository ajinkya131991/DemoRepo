package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ConfigFileReader.ConfigFileReader;
 
public class HomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void perform_Search() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/ul/li[1]/a")).click();
		WebElement search = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2]/form/input[1]"));
		search.sendKeys("Dress");
		search.submit();
		Thread.sleep(5000);
	}
	
	public void navigateTo_HomePage() {
		configFileReader.getApplicationUrl();
	}
 
}
