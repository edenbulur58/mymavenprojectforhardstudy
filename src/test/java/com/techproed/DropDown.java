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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    WebDriver driver;
@Before
public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/dropdown");
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
@Test
public void dropDownTest(){
WebElement selectElement=driver.findElement(By.id("dropdown"));

    Select options=new Select(selectElement);
String firstSelectedOptions=options.getFirstSelectedOption().getText();
    System.out.println(firstSelectedOptions);

   // options.selectByIndex(0);
    options.selectByIndex(1);
options.selectByValue("2");
options.selectByVisibleText("Option 1");
List<WebElement>listOfOptions=options.getOptions();
    for (WebElement e:listOfOptions) {
        System.out.println("List of options==>"+ e.getText());
    }
    System.out.println(listOfOptions.size());
    System.out.println(listOfOptions.size()==4?true:false);
    Assert.assertFalse(listOfOptions.size()==4);
}

@ After
    public void tearDown(){
   // driver.quit();
}


}
