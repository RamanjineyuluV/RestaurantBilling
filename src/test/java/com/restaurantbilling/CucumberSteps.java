package com.restaurantbilling;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CucumberSteps {
	
	private WebDriver driver = null;
	
	@Given("^I go to app create page at '(.+)'$")
	public void i_have_test_data_in_table_format(String url) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\parulmittalsid\\javparulmittal\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@When("^I create an order for customer name '(.+)' having '(.+)' arrangment and a Subtotal (\\d+)$")
	public void i_create_an_order_for_customer_name_Case_having_Outdoor_arrangment_and_a_Subtotal(String name, String arr, int amt ) throws Throwable {
		driver.findElement(By.id("name")).sendKeys(name); 
		
		Select arraDropdown = new Select(driver.findElement(By.id("arrangement")));	
		arraDropdown.selectByVisibleText(arr);
		
		driver.findElement(By.id("subtotal")).sendKeys(String.valueOf(amt)); 	
		driver.findElement(By.id("btnSubmit")).click(); 

		

	}

	@Then("^I see an ouput of Discount (\\d+) , having GST (\\d+) and a Total (\\d+)$")
	public void i_see_an_ouput_of_Discount_having_GST_and_a_Total(int dis, int gst, int tot) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement discount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discount")));
		assertEquals(String.valueOf(dis), discount.getAttribute("textContent")); 
		assertEquals(String.valueOf(gst), driver.findElement(By.id("tax")).getAttribute("textContent")); 
		assertEquals(String.valueOf(tot), driver.findElement(By.id("total")).getAttribute("textContent")); 
	}

	


	
	
}

	