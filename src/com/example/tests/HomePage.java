package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void pesquisar(String string) {
		this.driver.findElement(By.id("query")).clear();
	    this.driver.findElement(By.id("query")).sendKeys("bermudas femininas");
	    this.driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		
	}

}
