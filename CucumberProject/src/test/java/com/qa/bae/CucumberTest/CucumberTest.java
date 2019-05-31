package com.qa.bae.CucumberTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTest {

	public static WebDriver driver;
	public static String url = "http://www.practiceselenium.com/welcome.html";

	@Before
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() {
		// Write code here that turns the phrase above into concrete actions
		driver.get(url);

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")).click();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(driver.getCurrentUrl().equals("http://www.practiceselenium.com/menu.html"));
		System.out.println("I can browse");
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")).click();

	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(driver.getCurrentUrl().equals("http://www.practiceselenium.com/check-out.html"));
		System.out.println("I can checkoutF");
	}


	@After
	public static void teardown() {
		driver.quit();
	}

}
