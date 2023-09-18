package com.petSmile.StepDefinition3;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class Steps {
	private WebDriver driver;
	
	@Given("Abrir Chrome agenda")
	public void abrirChrome() {
		System.out.println("Abre el navegador");
		System.setProperty("webdriver.chrome.driver", "D:\\Programas\\Workspace\\PetSmile\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window();
		driver.get("http://localhost:8082/ReservaHora/");
	}
	@When("Ingresa Username {string} y Password {string} agenda")
	public void IngresaUserPassword(String string, String string2) {
		System.out.println("Se ingresan las credenciales de usuario");
		
		WebElement txtUsername = driver.findElement(By.className("username"));
		WebElement txtPassword = driver.findElement(By.className("password"));		
		
		txtUsername.sendKeys(string);
		txtPassword.sendKeys(string2);
		
		WebElement boton = driver.findElement(By.className("iniciarsesion"));
		boton.click();
		
	}
	@When("Elige menu Ingreso Agenda agenda")
	public void IngresoMenuAgenda() {
		WebElement ingresarAgenda = driver.findElement(By.className("ingresarAgenda"));
		ingresarAgenda.click();
	}
	@Then("Llena los datos de la agenda con idMascota {string}, Rut {string}, nombreMascota {string}, hora {string} y fecha {string} agenda")
	public void AgregarAgenda(String string, String string2, String string3, String string4, String string5) {
		
		WebElement boton = driver.findElement(By.className("iniciarsesion"));
		boton.click();
		
		Select selectOption = new Select(driver.findElement(By.className("rut"))); //driver.findElement(By.className("rut"));
		selectOption.selectByValue(string2);
		
		Select selectMascota = new Select(driver.findElement(By.className("mascota"))); //driver.findElement(By.className("rut"));
		selectMascota.selectByValue(string);
		
		WebElement hora = driver.findElement(By.className("hora"));
		hora.sendKeys(string4);
		  
		WebElement fecha = driver.findElement(By.className("fecha"));
		fecha.sendKeys(string5);
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		WebElement boton1 = driver.findElement(By.className("iniciarsesion"));
		boton1.click();
		
		assertEquals("Pet Smile", driver.getTitle());
	}
	
}



