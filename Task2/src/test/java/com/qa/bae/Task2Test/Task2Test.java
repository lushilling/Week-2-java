package com.qa.bae.Task2Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2Test {
	
	public static WebDriver driver;
	public static String url = "http://automationpractice.com/index.php";

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void task2Test() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		search.sendKeys("Dress");
		search.sendKeys(Keys.ENTER);
		
		WebElement selectDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		selectDress.click();
		
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		addToCart.click();
		
		Thread.sleep(2000);
		
		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		checkout.click();
		
		Thread.sleep(3000);
		
		WebElement result = driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span"));
		
		assertEquals("Your shopping cart contains: 1 Product", result.getText());
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}


}
