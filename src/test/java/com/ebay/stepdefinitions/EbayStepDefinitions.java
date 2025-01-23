package com.ebay.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.page.locators.ebayPageLocators;

import static org.junit.Assert.*;

import java.util.Set;

public class EbayStepDefinitions {
	
	WebDriver driver; 
	  
	@Given("user launch ebay site")
	public void user_launches_ebay_site() throws Exception {

		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\UIAutomation\\UIAutomation\\src\\test\\resources\\Webdriver\\chromedriver.exe");

	    driver = new ChromeDriver();
	    driver.get("https://www.ebay.com/");
	    driver.manage().window().maximize();
	         
	    
	}

	  @Then("user enter book in the search box")
	    public void user_enters_in_the_search_box() throws InterruptedException {

		    
		    WebElement searchBox = driver.findElement(By.xpath(ebayPageLocators.SEARCH_BOX));
	        System.out.println(searchBox);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	      
	    	js.executeScript("arguments[0].click();", searchBox);
	       
	        
	        
	        js.executeScript("arguments[0].setAttribute('value', 'book')", searchBox );
	  }
	        
	        
	       @Then("user click search button")
	       public void user_click_search_button() throws InterruptedException {
	       
	    	   JavascriptExecutor js = (JavascriptExecutor) driver;
	      
	        WebElement searchButton = driver.findElement(By.xpath(ebayPageLocators.SEARCH_BUTTON));
	        js.executeScript("arguments[0].click();", searchButton);
	        
	       }
	       
	       @Then("User select first book option")
	       public void user_select_first_book_option() {
	    	   
	    	   JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement selectFirstOption = driver.findElement(By.xpath(ebayPageLocators.BOOK_OPTION));
	        js.executeScript("arguments[0].click();", selectFirstOption);
	      
	       }
	       
	       @And("click add to cart button")
	       public void click_add_to_cart_btn() {
	    	   JavascriptExecutor js = (JavascriptExecutor) driver;
	        
	        String parentWindow = driver.getWindowHandle();
	        Set<String> allWindows = driver.getWindowHandles();
	        for(String window : allWindows) {
	        	if(! window.equals(parentWindow)) {
	        		driver.switchTo().window(window);
	        		break;}}
	        
	        
	        WebElement addToCart = driver.findElement(By.xpath(ebayPageLocators.ADD_TO_CART));
	        js.executeScript("arguments[0].scrollIntoView(false);", addToCart);
	        js.executeScript("arguments[0].click();", addToCart);
	       }
	       
	       
	       @And ("verify count has been added to the cart")
	    	   public void count_added_to_the_cart() {
	       
	        WebElement cartOption=driver.findElement(By.xpath(ebayPageLocators.CART_OPTION));
	        String cartCount=cartOption.getText();
	        if(!cartCount.equals("0")) {
	        	System.out.println("Cart is  not empty and the count is: "  +cartCount);
		        
	        }
	        else {
	        System.out.println("Cart is empty");
	        
	        }
	       driver.quit();
	        
}
	     }
