package com.petSmile.SeleniumTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTestAgregarAgenda {
	private WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Programas\\Workspace\\PetSmile\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window();
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
	  
	  WebElement boton1 = driver.findElement(By.className("iniciarsesion"));
	  
	  txtUsername.sendKeys("test1");
	  txtPassword.sendKeys("test123");
	  boton1.click();
	  
	  
	  WebElement ingresarAgenda = driver.findElement(By.className("ingresarAgenda"));
	  ingresarAgenda.click();
	  
	  
	  Select selectOption = new Select(driver.findElement(By.className("rut"))); //driver.findElement(By.className("rut"));
	  selectOption.selectByValue("1-2");
	  	  	  
	  Select selectMascota = new Select(driver.findElement(By.className("mascota"))); //driver.findElement(By.className("rut"));
	  selectMascota.selectByValue("2");
	  
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	  
	  WebElement hora = driver.findElement(By.className("hora"));
	  hora.sendKeys("23.15");
	  
	  WebElement fecha = driver.findElement(By.className("fecha"));
	  fecha.sendKeys("2023-10-01");

	  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	  WebElement boton = driver.findElement(By.className("iniciarsesion"));
	  boton.click();
	  
	  
	  
	  
	  assertEquals("Pet Smile", driver.getTitle());
  }
}
