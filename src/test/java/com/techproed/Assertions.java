package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertions {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void titleTest(){

        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        Assert.assertEquals(expectedTitle,actualTitle);
      //  if (actualTitle.equals(expectedTitle)){
        //    System.out.println("PASS");
       // }
       // else{
         //   System.out.println("FAİL");
       // }
    }
    @Test
    public void imageTest(){
        WebElement image=driver.findElement(By.id("hplogo"));
        Assert.assertTrue(image.isDisplayed());

    }
    @Test
    public void gmailLinkTest(){
        WebElement gmailLinkTest=driver.findElement(By.linkText("Gmail"));
        Assert.assertTrue("GmailLinkTest",gmailLinkTest.getText().equals("Gmail"));
        Assert.assertTrue(gmailLinkTest.isDisplayed());

    }
    @After
    public void tearDown(){
        driver.close();
    }


}
