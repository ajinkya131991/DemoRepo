package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



import ConfigFileReader.ConfigFileReader;
import PageObjectManager.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepDefinitions 
{
	WebDriver driver;
	HomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	
	@Given("^: user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
		configFileReader= new ConfigFileReader();
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+configFileReader.getDriverPath());
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\jars\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("http://shop.demoqa.com/");
		driver.navigate().to(configFileReader.getApplicationUrl());
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		//homePage.navigateTo_HomePage();
	
	}

	@When("^:he search for \"([^\"]*)\"$")
	public void he_search_for(String arg1) throws Throwable {
		
		
		homePage.perform_Search();
	
		
		/*driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/ul/li[1]/a")).click();
		WebElement search = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2]/form/input[1]"));
		search.sendKeys("Dress");
		search.submit();
		Thread.sleep(5000);*/

	}

	@When("^:choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		
		driver.navigate().to("http://shop.demoqa.com/product/39mm-mesh-bracelet-watch/");
	   
	}

	@When("^:moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
		
		driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//i[@class='icon_bag_alt']"));
		actions.moveToElement(menu).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Checkout']")).click();		
		Thread.sleep(5000);
	   
	}

	@When("^:enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws Throwable {
		
		checkoutPage = pageObjectManager.getCheckoutPage();
		checkoutPage.fill_PersonalDetails();	
		
		/*WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Lakshay");
		
		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Sharma");
		
		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("test@gmail.com");
		
		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		phone.sendKeys("07438862327");
				
		WebElement countryDropDown = driver.findElement(By.cssSelector("#billing_country_field .select2-arrow"));
		countryDropDown.click();
		Thread.sleep(2000);
		
		List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
		for(WebElement country : countryList){
			if(country.getText().equals("India")) {
				country.click();	
				Thread.sleep(3000);
				break;
			}		
		}
						
		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
		city.sendKeys("Delhi");
		
		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
		address.sendKeys("Shalimar Bagh");
		
		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		postcode.sendKeys("110088");*/
		
		System.out.println("Here");
	 
	}

	@When("^:select same delivery address$")
	public void select_same_delivery_address() throws Throwable {
		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
		shipToDifferetAddress.click();
		Thread.sleep(3000);

	}

	@When("^: Select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1) throws Throwable {
		List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
		paymentMethod.get(0).click();
		
		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();
		
	}

	@When("^: Place the order$")
	public void place_the_order() throws Throwable {
		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
		
		driver.quit();
	  
	}

}
