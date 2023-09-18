package com.petSmile.SeleniumTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
	private WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Programas\\Workspace\\PetSmile\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8082/ReservaHora/");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
  @Test
  public void f() {
	  WebElement txtUsername = driver.findElement(By.className("username"));
	  WebElement txtPassword = driver.findElement(By.className("password"));
	  
	  WebElement boton = driver.findElement(By.className("iniciarsesion"));
	  
	  txtUsername.sendKeys("test1");
	  txtPassword.sendKeys("test123");
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	  boton.click();
	  
	  assertEquals("Pet Smile", driver.getTitle());
  }
}
