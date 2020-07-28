package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppleTests {
    WebDriver driver;
  public void setUp(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.get("https://www.apple.com/");
  }
  @Test
  public void appleTest(){
      WebElement iphone11=driver.findElement(By.xpath(("(//h2[@class='headline'])[1]")));




  }



}
