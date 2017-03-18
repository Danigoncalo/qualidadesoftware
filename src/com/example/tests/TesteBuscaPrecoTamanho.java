package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteBuscaPrecoTamanho {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu201631720\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.enjoei.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEBuscaPrecoTamanho() throws Exception {
    driver.get(baseUrl + "/");
    
    //pagina inicial
    HomePage paginaInicial = new HomePage();
    driver.findElement(By.id("query")).clear();
    driver.findElement(By.id("query")).sendKeys("bermudas femininas");
    driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
    
    //pagina result busca
    driver.findElement(By.id("price_gte")).clear();
    driver.findElement(By.id("price_gte")).sendKeys("50");
    driver.findElement(By.id("price_lte")).clear();
    driver.findElement(By.id("price_lte")).sendKeys("500");
    
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    
    driver.findElement(By.linkText("PP")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
