package com.qa.bae.CucumberTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParametisationTest {

	public static WebDriver driver;
	private String searchTerm;

	@Before
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Test
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		// Write code here that turns the phrase above into concrete actions
		WebElement search = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		search.click();
		search.sendKeys(Keys.chord(arg1, Keys.ENTER));
		this.searchTerm = arg1;
	}

	@Test
	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(driver.getPageSource().contains(searchTerm));

	}

	@After
	public static void teardown() {
		driver.quit();
	}
}
