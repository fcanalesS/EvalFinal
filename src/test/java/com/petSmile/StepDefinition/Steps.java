package com.petSmile.StepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class Steps {
	private WebDriver driver;
	
	@Given("Abrir Chrome2")
	public void abrirChrome() {
		System.out.println("Abre el navegador");
		System.setProperty("webdriver.chrome.driver", "D:\\Programas\\Workspace\\PetSmile\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window();
		driver.get("http://localhost:8082/ReservaHora/");
	}
	@When("Ingresa Username {string} y Password {string}2")
	public void IngresaUserPassword(String string, String string2) {
		System.out.println("Se ingresan las credenciales de usuario");
		
		WebElement txtUsername = driver.findElement(By.className("username"));
		WebElement txtPassword = driver.findElement(By.className("password"));
	  
		
		
		txtUsername.sendKeys(string);
		txtPassword.sendKeys(string2);
		
	}
	@Then("Inicia Sesion2")
	public void IniciarSesion() {
		System.out.println("Se Ingresa al sitio con los datos ingresados en MyTest.feature");
		WebElement boton = driver.findElement(By.className("iniciarsesion"));
		boton.click();
		
		assertEquals("Pet Smile", driver.getTitle());
	}
	
}



