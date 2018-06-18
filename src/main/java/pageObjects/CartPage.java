package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
 
public class CartPage {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//button[@class='single_add_to_cart_button button alt']") 
	private WebElement btn_Cart;
	
	@FindBy(how = How.CSS, using = ".checkout-button.alt") 
	private WebElement btn_ContinueToCheckout;
	
	
	public void clickOn_Cart() throws InterruptedException {
		btn_Cart.click();
		Thread.sleep(5000);
	}
	
	public void clickOn_ContinueToCheckout(){
		btn_ContinueToCheckout.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
	}
	
}
