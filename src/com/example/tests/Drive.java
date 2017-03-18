package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drive {
	private WebDriver driver;
	private String baseUrl;

	public WebDriver getDriver() {
		if (driver == null) {
		 System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu201631720\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 setBaseUrl("https://www.enjoei.com.br/");
		 driver.get(baseUrl);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	  
	  
}
